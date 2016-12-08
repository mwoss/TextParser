package agh.project.textParser;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Matthew on 2016-12-07.
 */
public class ParserTest {
    @Test
    public void parse() throws Exception {
        String arg[] = {"konstytucja.txt"};
        String f = arg[0];
        Text x = new Text(f);
        Parser pars = new Parser(x);
        pars.Parse();
        String test = pars.chapters.get(0).Articles.get(1);

        assertEquals(13, pars.chapters.size());

        assertEquals(243, pars.chapters.getLast().lastArticle);

        assertEquals("Art. 2.\n" + "Rzeczpospolita Polska jest demokratycznym państwem prawnym, urzeczywistniającym\n" + "zasady sprawiedliwości społecznej.", test);

    }

}