package captcha;

import org.junit.Before;
import org.junit.Test;

import java.security.InvalidParameterException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by amornthip on 12/20/2016 AD.
 */
public class CalculatorTest {

    private Calculator calculator;

    @Before
    public void setUp() throws Exception {
        calculator = new Calculator();
    }

    @Test
    public void calculate_whenOperatorIsPlus_shouldReturnPlusResult() throws Exception {
        assertThat(calculator.calculate(1, Operators.ADD, 2), is(3));
    }

    @Test
    public void calculate_whenOperatorIsMinus_shouldReturnMinusResult() throws Exception {
        assertThat(calculator.calculate(1, Operators.SUBTRACT, 2), is(-1));
    }

    @Test
    public void calculate_whenOperatorIsTimes_shouldReturnTimesResult() throws Exception {
        assertThat(calculator.calculate(2, Operators.MULTIPLY, 3), is(6));
    }

    @Test(expected = InvalidParameterException.class)
    public void calculate_whenOperatorIsInvalid_shouldThrowExceptions() throws Exception {
        calculator.calculate(2, null, 3);
    }

}