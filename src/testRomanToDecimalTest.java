import static org.junit.Assert.*;
public class testRomanToDecimalTest {

    @org.junit.Test
    public void romanToDeciaml() {
        assertEquals(RomanToDecimal.romanToDecimal("XI"),11);
        assertEquals(RomanToDecimal.romanToDecimal("IXIX"),20);
        assertNotEquals(RomanToDecimal.romanToDecimal("Joe"),20);

    }
}