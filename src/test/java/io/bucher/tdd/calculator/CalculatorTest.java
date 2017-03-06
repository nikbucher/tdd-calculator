package io.bucher.tdd.calculator;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class CalculatorTest {
    @Test
    public void empty_string_is_0() {
        // given
        final String empty = "";

        // when
        final int result = calculate(empty);

        // then
        assertThat(result, equalTo(0));
    }

    @Test
    public void number_2_is_2() {
        // given
        final String two = "2";

        // when
        final int result = calculate(two);

        // then
        assertThat(result, equalTo(2));
    }

    @Test
    public void number_4_is_4() {
        // given
        final String four = "4";

        // when
        final int result = calculate(four);

        // then
        assertThat(result, equalTo(4));
    }

    private int calculate(String number) {
        if ("".equals(number)) {
            return 0;
        } else {
            return 2;
        }
    }
}
