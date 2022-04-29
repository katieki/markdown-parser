import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;
import java.io.IOException;
import java.nio.file.*;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void getLinksTest() throws IOException {
        Path fileName = Path.of("test-file.md");
        String content = Files.readString(fileName);
        List<String> result = List.of("https://something.com",
                "some-thing.html");
        assertEquals(result, MarkdownParse.getLinks(content));
    }

    @Test
    public void getLinksTest_2() throws IOException {
        Path fileName = Path.of("test-file2.md");
        String content = Files.readString(fileName);
        List<String> result = List.of("https://something.com",
                "some-page.html");
        assertEquals(result, MarkdownParse.getLinks(content));
    }

    @Test
    public void getLinksTest_3() throws IOException {
        Path fileName = Path.of("test-file3.md");
        String content = Files.readString(fileName);
        List<String> result = new ArrayList<>();
        assertEquals(result, MarkdownParse.getLinks(content));
    }

    @Test
    public void getLinksTest_4() throws IOException {
        Path fileName = Path.of("test-file4.md");
        String content = Files.readString(fileName);
        List<String> result = new ArrayList<>();
        assertEquals(result, MarkdownParse.getLinks(content));
    }

    @Test
    public void getLinksTest_5() throws IOException {
        Path fileName = Path.of("test-file5.md");
        String content = Files.readString(fileName);
        List<String> result = new ArrayList<>();
        assertEquals(result, MarkdownParse.getLinks(content));
    }

    @Test
    public void getLinksTest_6() throws IOException {
        Path fileName = Path.of("test-file6.md");
        String content = Files.readString(fileName);
        List<String> result = new ArrayList<>();
        assertEquals(result, MarkdownParse.getLinks(content));
    }

    @Test
    public void getLinksTest_7() throws IOException {
        Path fileName = Path.of("test-file7.md");
        String content = Files.readString(fileName);
        List<String> result = new ArrayList<>();
        assertEquals(result, MarkdownParse.getLinks(content));
    }

    @Test
    public void getLinksTest_8() throws IOException {
        Path fileName = Path.of("test-file8.md");
        String content = Files.readString(fileName);
        List<String> result = List.of("a link on the first line");
        assertEquals(result, MarkdownParse.getLinks(content));
    }

    @Test
    public void failingTest() throws IOException {
        Path fileName = Path.of("test-file8.md");
        String content = Files.readString(fileName);
        List<String> result = null;
        assertEquals(result, MarkdownParse.getLinks(content));
    }
}