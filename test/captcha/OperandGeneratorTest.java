package captcha;

import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class OperandGeneratorTest {

    private OperandGenerator operandGenerator;
    private List<Integer> numbers;

    @Before
    public void setUp() throws Exception {
        numbers = IntStream.rangeClosed(1, 9).boxed().collect(Collectors.toList());
        operandGenerator = new OperandGenerator(1, 9);
    }

    @Test
    public void generate_whenGivenMinIs1AndMaxIs9_shouldGenerateListOfIntegerFrom1to9() throws Exception {
        operandGenerator = new OperandGenerator(1, 9);
        assertThat(operandGenerator.getOperands(), is(numbers));
    }

    @Test
    public void generate_whenGivenMaxValueIs10_shouldReturnValueNotExceedMaxValue() throws Exception {
        assertThat(operandGenerator.generate() < 10 , is(true));
    }

    @Test
    public void generate_whenGivenMaxValueIs20_shouldReturnValueNotExceedMaxValue() throws Exception {
        assertThat(operandGenerator.generate() < 20 , is(true));
    }
}