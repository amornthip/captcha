package captcha;

import java.util.Arrays;
import java.util.List;

public class OperatorGenerator {

    private RandomUtil randomUtil;
    private List<Operators> operators = Arrays.asList(Operators.ADD, Operators.MULTIPLY, Operators.SUBTRACT);

    public OperatorGenerator(RandomUtil randomUtil) {
        this.randomUtil = randomUtil;
    }


    public Operators generate() {
        int randomIndex = randomUtil.random(operators.size());
        return operators.get(randomIndex);
    }
}
