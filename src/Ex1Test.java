import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class Ex1Test {
    @Test
    void computeNumberTest() {
        String s2 = "1011b2";
        int v = Ex1.number2Int(s2);
        assertEquals(v,11);
        String s10 = "1011bA";
        v = Ex1.number2Int(s10);
        s2 = Ex1.int2Number(v,2);
        int v2 = Ex1.number2Int(s2);
        assertEquals(v,v2);
        assertTrue(Ex1.equals(s10,s2));
    }

    @Test
    void isBasisNumberTest() {
        String[] good = {"1", "1b2", "01b2", "123bA", "ABbG", "0bA"};
        for(int i=0;i<good.length;i=i+1) {
            boolean ok = Ex1.isNumber(good[i]);
            assertTrue(ok);
        }
        String[] not_good = {"b2", "2b2", "1G3bG", "B bG", "0bbA", "abB", "!@b2", "A", "1bb2"};
        for(int i=0;i<not_good.length;i=i+1) {
            boolean not_ok = Ex1.isNumber(not_good[i]);
            assertFalse(not_ok);
        }
    }
    @Test
    void int2NumberTest() {
        // Valid tests for positive numbers and different bases
        assertEquals("10b2", Ex1.int2Number(2, 2));  // 2 in base 2
        assertEquals("7b8", Ex1.int2Number(7, 8));  // 7 in base 8
        assertEquals("1bG", Ex1.int2Number(1, 16));  // 1 in base 16

        // Invalid cases - bases out of range (less than 2 or more than 16)
        assertEquals("", Ex1.int2Number(-1, 10));  // Negative number
        assertEquals("", Ex1.int2Number(10, 1));   // Base less than 2
        assertEquals("", Ex1.int2Number(10, 17));  // Base greater than 16
    }

    @Test
    void maxIndexTest() {
        String[] arr1 = {"4563", "10b2", "16211b7", "35415b7"}; // All numbers are valid
        int maxIdx1 = Ex1.maxIndex(arr1);
        assertEquals(3, maxIdx1); // "35415b7" is the number with the largest decimal value

        // Array with only valid numbers
        String[] arr2 = {"100b2", "101b3", "111b4", "1010b5"}; // All numbers are valid
        int maxIdx2 = Ex1.maxIndex(arr2);
        assertEquals(3, maxIdx2); // "1010b5" is the largest value

        // Array with valid numbers and different values
        String[] arr3 = {"10b2", "11b2", "100b2", "101b2"}; // All numbers are valid
        int maxIdx3 = Ex1.maxIndex(arr3);
        assertEquals(3, maxIdx3); // "101b2" is the largest number
    }


    @Test
    void testNegativeNumber() {
        // Test if input with a negative number returns -1
        assertEquals(-1, Ex1.number2Int("-101b2"));
    }

    @Test
    void testZero() {
        assertEquals("0b2", Ex1.int2Number(0, 2));  // 0 in base 2
        assertEquals("0b8", Ex1.int2Number(0, 8));  // 0 in base 8
        assertEquals("0bG", Ex1.int2Number(0, 16));  // 0 in base 16
    }

    @Test
    void testLargeNumber() {
        // Test if input with large numbers works correctly
        assertEquals(1000000, Ex1.number2Int("22666622b7"));
    }


}
