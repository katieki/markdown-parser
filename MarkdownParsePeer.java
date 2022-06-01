import java.io.IOException;
import java.nio.channels.ClosedByInterruptException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParsePeer {

    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>(); 
        // find the next [, then find the ], then find the (, then read link upto next )
        int currentIndex = 0;
        while(currentIndex < markdown.length()) {
           // System.out.println("hello");
            int openBracket = markdown.indexOf("[", currentIndex);
            int closeBracket = markdown.indexOf("]", openBracket);
            int openParen = markdown.indexOf("(", closeBracket);
            int closeParen = markdown.indexOf(")", openParen);
            
            //fixed infinite loop due to no link in test-file3.md
            if (openParen == -1 || closeParen == -1 || openBracket == -1 || closeBracket == -1){
                break;
            }

            //fixed infinite loop due to no title in test-file4.md
            else if(openBracket == -1 || closeBracket == -1){
                openParen = markdown.indexOf("(", currentIndex); 
                closeParen = markdown.indexOf(")", currentIndex);
            }

            //if there is no link but there are open and closed parentheses
            else if(Math.abs(openParen-closeParen) == 1){
                break;
            }
            
            toReturn.add(markdown.substring(openParen + 1, closeParen));
            currentIndex = closeParen + 1;
            
            //fixed infinite loop due to extra line in test-file2.md
            if (markdown.length()- 2 <= currentIndex){
                break;
            }
        }

        return toReturn;
    }


    public static void main(String[] args) throws IOException {
        Path fileName = Path.of(args[0]);
        String content = Files.readString(fileName);
        ArrayList<String> links = getLinks(content);
	    System.out.println(links);
    }
}