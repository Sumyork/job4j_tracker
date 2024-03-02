package ru.job4j.function;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class FunctionCalculatorTest {
    @Test
    void whenLinearFunctionThenLinearResults() {
        FunctionCalculator function = new FunctionCalculator();
        List<Double> result = function.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result).containsAll(expected);
    }

    @Test
    void whenLinearFunctionThenExponentialResults() {
        FunctionCalculator function = new FunctionCalculator();
        List<Double> result = function.diapason(2, 7, x -> Math.pow(2, x));
        List<Double> expected = Arrays.asList(8D, 16D, 32D, 64D);
        assertThat(result).containsAll(expected);
    }

    @Test
    void whenLinearFunctionThenQuadraticResults() {
        FunctionCalculator function = new FunctionCalculator();
        List<Double> result = function.diapason(2, 6, x -> Math.pow(x, 2) + 6 * x - 38);
        List<Double> expected = Arrays.asList(-11D, 2D, 17D);
        assertThat(result).containsAll(expected);
    }
}