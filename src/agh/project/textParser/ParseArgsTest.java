package agh.project.textParser;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Matthew on 2016-12-07.
 */
public class ParseArgsTest {
    @Test
    public void argTest() throws Exception {
        String[] testTable = {"konstytucja.txt","xD","12"};
        ParseArgs test1 = new ParseArgs(testTable);
        assertFalse(test1.argTest());

    }

}