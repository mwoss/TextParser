package agh.project.textParser;

import org.junit.Test;
import java.io.PrintStream;
import java.io.ByteArrayOutputStream;

import static org.junit.Assert.*;

/**
 * Created by Matthew on 2016-12-07.
 */
public class TextOutTest {
    @Test
    public void writeArticle() throws Exception {
        String[] arg = {"konstytucja.txt"};
        String f = arg[0];
        Text x = new Text(f);
        Parser parser = new Parser(x);
        parser.Parse();
        TextOut out = new TextOut(parser);
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        out.writeArticle(2);
        String tester = outContent.toString();
        assertEquals("Art. 2.\n" + "Rzeczpospolita Polska jest demokratycznym państwem prawnym, urzeczywistniającym\n" + "zasady sprawiedliwości społecznej.\n", tester);
    }

    @Test
    public void writeArticles() throws Exception {

    }

    @Test
    public void writeChapter() throws Exception {

    }
}