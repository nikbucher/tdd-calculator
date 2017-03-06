package io.bucher.tdd.calculator;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class CalculatorTest {
    @Test
    public void assert_true_is_true() {
        // given

        // when

        // then
        assertThat(true, equalTo(true));
    }
}
