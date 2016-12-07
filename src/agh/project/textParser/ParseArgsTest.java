package agh.project.textParser;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Matthew on 2016-12-07.
 */
public class ParseArgsTest {
    // have to creat new instance for every assert, arg table is private variable

    @Test
    public void argTest() throws Exception {
        String[] testTable = {"konstytucja.txt","9","12"};
        String[] testTable1 = {"konstytucja.txt","9"};
        String[] testTable2 = {"konstytucja.txt","IV"};
        ParseArgs test = new ParseArgs(testTable);
        ParseArgs test1 = new ParseArgs(testTable1);
        ParseArgs test2 = new ParseArgs(testTable2);
        assertTrue(test.argTest());
        assertTrue(test1.argTest());
        assertTrue(test2.argTest());


    }
    @Test(expected = IllegalArgumentException.class)
    public void argExceptionTest1(){
        String[] testTable = {"konstytucja.txt","9xDD","12"};
        ParseArgs test = new ParseArgs(testTable);
        test.argTest();
    }
    @Test(expected = IllegalArgumentException.class)
    public void argExceptionTest2() {
        String[] testTable = {"konstytucja.txt", "IVlol"};
        ParseArgs test = new ParseArgs(testTable);
        test.argTest();
    }
    @Test(expected = IllegalArgumentException.class)
    public void argExceptionTest3() {
        String[] testTable = {"konstytucja.png", "9", "12"};
        ParseArgs test = new ParseArgs(testTable);
        test.argTest();
    }
    @Test(expected = IllegalArgumentException.class)
    public void argExceptionTest4() {
        String[] testTable = {"konstytucja.txt", "9", "12", "exception", "xD"};
        ParseArgs test = new ParseArgs(testTable);
        test.argTest();
    }


}