package captcha;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Matchers.anyInt;
import static org.mockito.MockitoAnnotations.initMocks;


public class OperatorGeneratorTest {

    @Mock
    private RandomUtil randomUtil;

    private OperatorGenerator operatorGenerator;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
        operatorGenerator = new OperatorGenerator(randomUtil);
    }

    @Test
    public void generate_shouldCallRandomUtilWithExpectedParameter() throws Exception {
        operatorGenerator.generate();

        Mockito.verify(randomUtil).random(3);
    }

    @Test
    public void generate_whenRandomUtilReturnZero_shouldReturnFirstElementOfOperators() throws Exception {
        Mockito.when(randomUtil.random(anyInt())).thenReturn(0);

        Operators randomOperator = operatorGenerator.generate();
        assertThat(randomOperator, is(Operators.ADD));
    }

    @Test
    public void generate_whenRandomUtilReturnOne_shouldReturnSecondElementOfOperators() throws Exception {
        Mockito.when(randomUtil.random(anyInt())).thenReturn(1);

        Operators randomOperator = operatorGenerator.generate();
        assertThat(randomOperator, is(Operators.MULTIPLY));
    }

    @Test
    public void generate_whenRandomUtilReturnTwo_shouldReturnThirdElementOfOperators() throws Exception {
        Mockito.when(randomUtil.random(anyInt())).thenReturn(2);

        Operators randomOperator = operatorGenerator.generate();
        assertThat(randomOperator, is(Operators.SUBTRACT));
    }
}