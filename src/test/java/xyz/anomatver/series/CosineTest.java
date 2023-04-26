package xyz.anomatver.series;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CosineTest {
    private static final double DELTA = 0.001; // погрешность сравнения

    @Test
    public void testCosZero() {
        double x = 0;
        double expected = 1.0;
        double actual = Cosine.cos(x);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void testCosPi() {
        double x = Math.PI;
        double expected = -1.0;
        double actual = Cosine.cos(x);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void testCosPiOverTwo() {
        double x = Math.PI / 2;
        double expected = 0.0;
        double actual = Cosine.cos(x);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void testCosNegativePi() {
        double x = -1 * Math.PI;
        double expected = -1.0;
        double actual = Cosine.cos(x);
        assertEquals(expected, actual, DELTA);
    }
}

