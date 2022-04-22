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
        Path fileName = Path.of("test-file_us.md");
        String content = Files.readString(fileName);
        List<String> result = List.of("https://something.com", "some-page.html");
        assertEquals(result, MarkdownParse.getLinks(content));
    }
}