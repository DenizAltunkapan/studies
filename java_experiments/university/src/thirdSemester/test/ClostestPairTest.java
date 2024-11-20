package thirdSemester.test;

import org.junit.jupiter.api.Test;
import thirdSemester.ClosestPair;
import thirdSemester.Point;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClostestPairTest {

    @Test
    void test1() {
        Point[] points = {
                new Point(0.0, 0.0),
                new Point(1.0, 1.0),
                new Point(2.0, 2.0),
                new Point(3.0, 3.0),
                new Point(4.0, 4.0),
                new Point(5.0, 5.0)
        };
        double result = ClosestPair.closestPair(points);
        assertEquals(1.4142, result, 0.0001);
    }

    @Test
    void test2() {
        Point[] points = {
                new Point(1.0, 1.0),
                new Point(1.0, 2.0),
                new Point(1.0, 3.0),
                new Point(1.0, 4.0),
                new Point(1.0, 5.0),
                new Point(1.0, 6.0)
        };
        double result = ClosestPair.closestPair(points);
        assertEquals(1.0, result, 0.0001);
    }

    @Test
    void test3() {
        Point[] points = {
                new Point(1.0, 1.0),
                new Point(2.0, 1.0),
                new Point(3.0, 1.0),
                new Point(4.0, 1.0),
                new Point(5.0, 1.0),
                new Point(6.0, 1.0)
        };
        double result = ClosestPair.closestPair(points);
        assertEquals(1.0, result, 0.0001);
    }

    @Test
    void test4() {
        Point[] points = {
                new Point(0.0, 0.0),
                new Point(0.0, 1.0),
                new Point(1.0, 0.0),
                new Point(1.0, 1.0),
                new Point(2.0, 0.0),
                new Point(2.0, 1.0)
        };
        double result = ClosestPair.closestPair(points);
        assertEquals(1.0, result, 0.0001);
    }

    @Test
    void test5() {
        Point[] points = {
                new Point(0.0, 0.0),
                new Point(0.0, 2.0),
                new Point(1.0, 1.0),
                new Point(3.0, 3.0),
                new Point(4.0, 4.0),
                new Point(5.0, 5.0)
        };
        double result = ClosestPair.closestPair(points);
        assertEquals(1.4142, result, 0.0001);
    }

    @Test
    void test6() {
        Point[] points = {
                new Point(1.0, 1.0),
                new Point(1.1, 1.1),
                new Point(5.0, 5.0),
                new Point(10.0, 10.0),
                new Point(12.0, 12.0),
                new Point(15.0, 15.0)
        };
        double result = ClosestPair.closestPair(points);
        assertEquals(0.1414, result, 0.0001);
    }

    @Test
    void test7() {
        Point[] points = {
                new Point(0.0, 0.0),
                new Point(2.0, 2.0),
                new Point(3.0, 3.0),
                new Point(5.0, 5.0),
                new Point(6.0, 6.0),
                new Point(7.0, 7.0)
        };
        double result = ClosestPair.closestPair(points);
        assertEquals(1.4142, result, 0.0001);
    }

    @Test
    void test8() {
        Point[] points = {
                new Point(1.0, 1.0),
                new Point(2.0, 2.0),
                new Point(3.0, 3.0),
                new Point(4.0, 4.0),
                new Point(5.0, 5.0),
                new Point(6.0, 6.0)
        };
        double result = ClosestPair.closestPair(points);
        assertEquals(1.4142, result, 0.0001);
    }

    @Test
    void test9() {
        Point[] points = {
                new Point(1.0, 1.0),
                new Point(1.0, 1.5),
                new Point(1.0, 2.0),
                new Point(1.0, 2.5),
                new Point(1.0, 3.0),
                new Point(1.0, 3.5)
        };
        double result = ClosestPair.closestPair(points);
        assertEquals(0.5, result, 0.0001);
    }

    @Test
    void test10() {
        Point[] points = {
                new Point(5.0, 5.0),
                new Point(6.0, 6.0),
                new Point(7.0, 7.0),
                new Point(8.0, 8.0),
                new Point(9.0, 9.0),
                new Point(10.0, 10.0)
        };
        double result = ClosestPair.closestPair(points);
        assertEquals(1.4142, result, 0.0001);
    }

    @Test
    void test11() {
        Point[] points = {
                new Point(0.0, 0.0),
                new Point(1.0, 0.0),
                new Point(0.0, 1.0),
                new Point(1.0, 1.0),
                new Point(2.0, 0.0),
                new Point(2.0, 1.0)
        };
        double result = ClosestPair.closestPair(points);
        assertEquals(1.0, result, 0.0001);
    }

    @Test
    void test12() {
        Point[] points = {
                new Point(10.0, 10.0),
                new Point(20.0, 20.0),
                new Point(30.0, 30.0),
                new Point(40.0, 40.0),
                new Point(50.0, 50.0),
                new Point(60.0, 60.0)
        };
        double result = ClosestPair.closestPair(points);
        assertEquals(14.1421, result, 0.0001);
    }

    @Test
    void test13() {
        Point[] points = {
                new Point(1.0, 2.0),
                new Point(3.0, 4.0),
                new Point(5.0, 6.0),
                new Point(7.0, 8.0),
                new Point(9.0, 10.0),
                new Point(11.0, 12.0)
        };
        double result = ClosestPair.closestPair(points);
        assertEquals(2.8284, result, 0.0001);
    }

    @Test
    void test14() {
        Point[] points = {
                new Point(0.0, 0.0),
                new Point(0.1, 0.1),
                new Point(0.2, 0.2),
                new Point(0.3, 0.3),
                new Point(0.4, 0.4),
                new Point(0.5, 0.5)
        };
        double result = ClosestPair.closestPair(points);
        assertEquals(0.1414, result, 0.0001);
    }

    @Test
    void test15() {
        Point[] points = {
                new Point(100.0, 100.0),
                new Point(200.0, 200.0),
                new Point(300.0, 300.0),
                new Point(400.0, 400.0),
                new Point(500.0, 500.0),
                new Point(600.0, 600.0)
        };
        double result = ClosestPair.closestPair(points);
        assertEquals(141.4214, result, 0.0001);
    }
}
