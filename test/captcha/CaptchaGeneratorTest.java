package captcha;


import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.MockitoAnnotations.initMocks;

public class CaptchaGeneratorTest {
    @Mock
    private Calculator calculator;
    @Mock
    private OperandGenerator operandGenerator;
    @Mock
    private OperatorGenerator operatorGenerator;

    private CaptchaGenerator captchaGenerator;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
        captchaGenerator = new CaptchaGenerator(calculator, operandGenerator, operatorGenerator);
        Mockito.when(operatorGenerator.generate()).thenReturn(Operators.ADD);
        Mockito.when(calculator.calculate(anyInt(), any(Operators.class), anyInt())).thenReturn(4);

    }

    @Test
    public void generate_shouldCallOperandGeneratorForTwoTimes() throws Exception {
        Mockito.when(operandGenerator.generate()).thenReturn(2);

        captchaGenerator.generate();

        Mockito.verify(operandGenerator, Mockito.times(2)).generate();
    }

    @Test
    public void generate_shouldReturnCaptchaWithCorrectExpectField() throws Exception {
        Mockito.when(operandGenerator.generate()).thenReturn(2);

        Captcha randomedCaptcha = captchaGenerator.generate();

        assertThat(randomedCaptcha.getFirst(), is(2));
    }

    @Test
    public void generate_shouldCallCalculatorForOneTime() throws Exception {
        Mockito.when(operandGenerator.generate()).thenReturn(2);
        Mockito.when(operatorGenerator.generate()).thenReturn(Operators.ADD);

        captchaGenerator.generate();

        Mockito.verify(calculator, Mockito.times(1)).calculate(2, Operators.ADD, 2);
    }

    @Test
    public void generate_shouldCallOperatorGeneratorForOneTime() throws Exception {
        Mockito.when(operandGenerator.generate()).thenReturn(2);

        captchaGenerator.generate();

        Mockito.verify(operatorGenerator, Mockito.times(1)).generate();
    }

    @Test
    public void generate_shouldSetExpectedResultFromResultOfCalculator() throws Exception {
        Mockito.when(operandGenerator.generate()).thenReturn(2);
        Mockito.when(calculator.calculate(2, Operators.ADD, 2)).thenReturn(4);

        Captcha generatedCaptcha = captchaGenerator.generate();

        assertThat(generatedCaptcha.getExpectedResult(), is(4));
    }
}