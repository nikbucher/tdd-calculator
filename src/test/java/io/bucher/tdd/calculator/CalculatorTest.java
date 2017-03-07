package io.bucher.tdd.calculator;

import org.junit.Test;

import java.util.StringTokenizer;

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

    @Test
    public void calculate_3_multipliedby_4_equals_12() {
        // given
        final String subtraction = "3 * 4";

        // when
        final int result = calculate(subtraction);

        // then
        assertThat(result, equalTo(12));
    }

    private int calculate(String expression) {
        final StringTokenizer tokens = new StringTokenizer(expression, " ");
        if (hasAnyTokens(tokens)) {
            int result = nextNumber(tokens);
            while (tokens.hasMoreTokens()) {
                final String operator = tokens.nextToken();
                result = calculate(result, operator, nextNumber(tokens));
            }
            return result;
        } else {
            return 0;
        }
    }

    private boolean hasAnyTokens(StringTokenizer tokens) {
        return tokens.countTokens() > 0;
    }

    private int calculate(int number, String operator, int nextNumber) {
        switch (operator) {
            case "+":
                return number + nextNumber;
            case "-":
                return number - nextNumber;
            default:
                throw new IllegalStateException();
        }
    }

    private int nextNumber(StringTokenizer tokens) {
        return parseInt(tokens.nextToken());
    }

}
