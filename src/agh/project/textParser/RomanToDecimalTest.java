package agh.project.textParser;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Matthew on 2016-12-07.
 */
public class RomanToDecimalTest {
    @Test
    public void romanToDecimal() throws Exception {
        RomanToDecimal parse = new RomanToDecimal();
        assertEquals(5,parse.romanToDecimal("V"));
        assertEquals(2352,parse.romanToDecimal("MMCCCLII"));
        assertEquals(597,parse.romanToDecimal("DXCVII"));

    }

    @Test
    public void processDecimal() throws Exception {
        RomanToDecimal parse = new RomanToDecimal();
        assertEquals(3, parse.processDecimal(9,15,12));
        assertEquals(29,parse.processDecimal(20,8,9));

    }

}