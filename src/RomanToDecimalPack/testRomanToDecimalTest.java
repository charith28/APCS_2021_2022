package RomanToDecimalPack;

import RomanToDecimalPack.RomanToDecimal;

import static org.junit.Assert.*;
public class testRomanToDecimalTest {

    @org.junit.Test
    public void romanToDecimal() {
        assertEquals(RomanToDecimal.romanToDecimal("XI"),11);
        assertEquals(RomanToDecimal.romanToDecimal("xx"),20);
        assertEquals(RomanToDecimal.romanToDecimal("Xx"),20);
        assertEquals(RomanToDecimal.romanToDecimal("CMLXXIX"),979);
        assertEquals(RomanToDecimal.romanToDecimal("DCCXXV"),725);
        assertEquals(RomanToDecimal.romanToDecimal("DXXXVI"),536);
        assertEquals(RomanToDecimal.romanToDecimal("CCXXVI"),226);
        assertEquals(RomanToDecimal.romanToDecimal("DCCLXIV"),764);
        assertEquals(RomanToDecimal.romanToDecimal("CCCXXXIX"),339);
        assertEquals(RomanToDecimal.romanToDecimal("CCCLXXVII"),377);
        assertEquals(RomanToDecimal.romanToDecimal("IXIX"),-1);
        assertEquals(RomanToDecimal.romanToDecimal("IVDDCCXXX"),-1);
        assertEquals(RomanToDecimal.romanToDecimal("XVIICMX"),-1);
        assertEquals(RomanToDecimal.romanToDecimal("IIV"),-1);
        assertEquals(RomanToDecimal.romanToDecimal("MRCOCHRAN"),-1);
        assertEquals(RomanToDecimal.romanToDecimal("XCISIS"),-1);
        assertEquals(RomanToDecimal.romanToDecimal("COMPSCIISCOOOL"),-1);
        assertEquals(RomanToDecimal.romanToDecimal("TAKETHIS-JAVA"),-1);
        assertNotEquals(RomanToDecimal.romanToDecimal("Joe"),20);
        assertNotEquals(RomanToDecimal.romanToDecimal("IC"),101);

    }
}