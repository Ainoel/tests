package tests;

import org.junit.Test;

import static evaluator.Evaluator.eval;
import static org.junit.Assert.*;

public class EvaluatorTests {
    static double DELTA = 0.00000000001d;
    static int RUNS = 1000;

    @Test
    public void testInverseOperations() {
        for (int i = 1; i < RUNS; i++) {
            assertEquals(i, eval(i + "*" + i + "/" + i), DELTA);
            assertEquals(i, eval(i + "+" + i + "-" + i), DELTA);
        }
    }

    @Test
    public void testMultiplyByZero() {
        for (int i = 2; i < RUNS; i++) {
            assertEquals(i, eval(i + "+" + i + " * 0"), DELTA);
            assertEquals(0d, eval(i + "^" + i / (RUNS / 10) + " * 0"), DELTA);
        }
    }

    @Test
    public void testSingle() {
        for (int i = 1; i < RUNS; i++) {
            assertEquals(i, eval(String.valueOf(i)), DELTA);
            assertEquals(-i, eval("-" + i), DELTA);
        }
    }

    @Test
    public void testPower2() {
        for (int i = 1; i < RUNS; i++) {
            assertEquals(Math.pow(i, 2), eval(i + "*" + i), DELTA);
        }
    }

    @Test
    public void testDoubledMinus() {
        for (int i = 0; i < RUNS; i += 2) {
            assertEquals(i, eval("-".repeat(i) + i), DELTA);
        }
    }

    @Test
    public void testParenthesized() {
        for (int i = 1; i < RUNS; i++) {
            assertEquals(i * 3, eval(i + " * (1 + 2)"), DELTA);
            assertEquals(Math.pow(i, 8d), eval(i + " ^ (2 * 4)"), DELTA);
        }
    }

    @Test
    public void testDivideBy0() {
        for (int i = 1; i < RUNS; i++) {
            assertTrue(Double.isInfinite(eval(i + " / 0")));
        }
    }

    @Test
    public void testInfinite() {
        for (int i = 10; i < RUNS; i++) {
            assertTrue(Double.isInfinite(eval(i + " ^ 10000")));
        }
    }
}
