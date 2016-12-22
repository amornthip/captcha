package captcha;

public class CaptchaGenerator {

    private Calculator calculator;
    private OperandGenerator operandGenerator;
    private OperatorGenerator operatorGenerator;

    public CaptchaGenerator(Calculator calculator, OperandGenerator operandGenerator, OperatorGenerator operatorGenerator) {
        this.calculator = calculator;
        this.operandGenerator = operandGenerator;
        this.operatorGenerator = operatorGenerator;
    }

    public Captcha generate() {
        Integer first = operandGenerator.generate();
        Integer second = operandGenerator.generate();
        Operators operator = operatorGenerator.generate();
        Integer expectedResult = calculator.calculate(first, operator, second);

        return new Captcha(first, operator.toString(), second, expectedResult);
    }
}
