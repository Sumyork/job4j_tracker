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
        int selected1 = input.askInt("Enter menu:");
        assertThat(selected1).isEqualTo(1);
        int selected2 = input.askInt("Enter menu:");
        assertThat(selected2).isEqualTo(2);
        int selected3 = input.askInt("Enter menu:");
        assertThat(selected3).isEqualTo(3);
        int selected4 = input.askInt("Enter menu:");
        assertThat(selected4).isEqualTo(4);
        int selected5 = input.askInt("Enter menu:");
        assertThat(selected5).isEqualTo(5);
        int selected6 = input.askInt("Enter menu:");
        assertThat(selected6).isEqualTo(6);
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