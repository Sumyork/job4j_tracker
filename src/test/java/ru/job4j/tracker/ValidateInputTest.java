package ru.job4j.tracker;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class ValidateInputTest {
    @Test
    public void whenInvalidInput() {
        Output output = new StubOutput();
        Input in = new MockInput(
                new String[] {"one", "1"}
        );
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(1);
    }

    @Test
    public void whenValidInput() {
        Output output = new StubOutput();
        Input in = new MockInput(
                new String[] {"1"}
        );
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(1);
    }

    @Test
    public void whenValidMultipleInput() {
        Output output = new StubOutput();
        Input in = new MockInput(
                new String[] {"1", "2", "3", "4", "5", "6"}
        );
        ValidateInput input = new ValidateInput(output, in);
        int count = 1;
        while (count < 7) {
            int selected = input.askInt("Enter menu:");
            assertThat(selected).isEqualTo(count++);
        }
    }

    @Test
    public void whenValidNegativeNumberInput() {
        Output output = new StubOutput();
        Input in = new MockInput(
                new String[] {"-1"}
        );
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(-1);
    }
}