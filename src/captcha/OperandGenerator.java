package captcha;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class OperandGenerator {

    private List<Integer> operands;

    public OperandGenerator(int min, int max) {
        this.operands =  IntStream.rangeClosed(min, max).boxed().collect(Collectors.toList());
    }

    public Integer generate() {
        Random rand = new Random();
        int randomNum = rand.nextInt((operands.size()));
        return operands.get(randomNum);
    }

    public List<Integer> getOperands() {
        return operands;
    }
}
