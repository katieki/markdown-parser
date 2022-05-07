//https://howtodoinjava.com/java/io/java-read-file-to-string-examples/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParse {
    // add comment to test Makefile
    // added change new line
    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (,
        // then read link upto next )
        int currentIndex = 0;
        while (currentIndex < markdown.length()) {
            int openBracket = markdown.indexOf("[", currentIndex);
            if (openBracket > 0 && markdown.charAt(openBracket - 1) == '!') {
                openBracket = markdown.indexOf("[", openBracket + 1);
            }
            if (openBracket < 0) {
                return toReturn;
            }

            int closeBracket = markdown.indexOf("]", openBracket);
            int openParen = markdown.indexOf("(", closeBracket);
            int closeParen = markdown.indexOf(")", openParen);
            // Check for incorrect syntax of brackets and parentheses
            if (((markdown.indexOf("[", openBracket + 1) > closeParen ||
                    markdown.indexOf("[", openBracket + 1) < 0 &&
                            openParen == closeBracket + 1))
                    && closeBracket >= 0) {
                toReturn.add(markdown.substring(openParen + 1, closeParen));
                currentIndex = closeParen + 1;
            } else if (markdown.indexOf("[", openBracket + 1) == -1 ||
                    closeParen < 0) {
                return toReturn;
            } else {
                currentIndex = markdown.indexOf("[", openBracket + 1);
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
