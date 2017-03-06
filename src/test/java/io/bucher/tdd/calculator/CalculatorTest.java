package io.bucher.tdd.calculator;

import org.junit.Test;

import static java.lang.Integer.parseInt;
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

    @Test
    public void number_minus3_is_minus3() {
        // given
        final String minusThree = "-3";

        // when
        final int result = calculate(minusThree);

        // then
        assertThat(result, equalTo(-3));
    }

    @Test
    public void number_4_with_space_is_4() {
        // given
        final String four = "4 ";

        // when
        final int result = calculate(four);

        // then
        assertThat(result, equalTo(4));
    }

    @Test
    public void add_2_plus_3_equals_5() {
        // given
        final String addition = "2 + 3";

        // when
        final int result = calculate(addition);

        // then
        assertThat(result, equalTo(5));
    }

    @Test
    public void add_2_plus_3_plus_4_equals_9() {
        // given
        final String addition = "2 + 3 + 4";

        // when
        final int result = calculate(addition);

        // then
        assertThat(result, equalTo(9));
    }

    @Test
    public void subtract_8_minus_5_equals_3() {
        // given
        final String subtraction = "8 - 5";

        // when
        final int result = calculate(subtraction);

        // then
        assertThat(result, equalTo(3));
    }

    private int calculate(String expression) {
        expression = expression.trim();
        if ("".equals(expression)) {
            return 0;
        } else if (expression.contains(" ")) {
            return calculate(expression.split(" "));
        } else {
            return getAnInt(expression);
        }
    }

    private int calculate(String[] tokens) {
        int i = 0;
        int result = getAnInt(tokens[i++]);
        while (i < tokens.length) {
            switch (tokens[i++]) {
                case "+":
                    result += getAnInt(tokens[i++]);
                    break;
                case "-":
                    result -= getAnInt(tokens[i++]);
                    break;
                default:
                    throw new IllegalStateException();
            }
        }
        return result;
    }


    private int getAnInt(String number) {
        return parseInt(number.trim());
    }
}
