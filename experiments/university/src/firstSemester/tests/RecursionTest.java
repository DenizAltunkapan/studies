package firstSemester.tests;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import firstSemester.Recursion;


public class RecursionTest {

    @Test
    void powerTest() {
        assertEquals(27, Recursion.power(3, 3));
    }

    @Test
    void sumBasicTest() {
        for (int i = 0; i < 100; i++) {
            assertEquals((i * (i + 1)) / 2, Recursion.sum(i));
        }
    }

    @Test
    void sumExceptionTest() {
        assertThrows(IllegalArgumentException.class, () -> Recursion.sum(-1));
    }
}




