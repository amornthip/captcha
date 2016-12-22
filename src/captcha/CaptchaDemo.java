package captcha;

import java.util.Scanner;

public class CaptchaDemo {

    private final CaptchaGenerator captchaGenerator;
    private Captcha captcha;

    public CaptchaDemo() {
        Calculator calculator = new Calculator();
        OperandGenerator operandGenerator = new OperandGenerator(1, 9);
        OperatorGenerator operatorGenerator = new OperatorGenerator(new RandomUtil());
        captchaGenerator = new CaptchaGenerator(calculator, operandGenerator, operatorGenerator);
    }

    public String getCaptchaQuestion(){
        captcha = captchaGenerator.generate();
        return captcha.toString();
    }

    public boolean checkAnswer(int inputAnswer){
        return captcha.checkAnswer(inputAnswer);
    }

    public Captcha getCurrentCaptcha() {
        return captcha;
    }

    public static void main(String[] Args){
        Calculator calculator = new Calculator();
        OperandGenerator operandGenerator = new OperandGenerator(1, 9);
        OperatorGenerator operatorGenerator = new OperatorGenerator(new RandomUtil());
        CaptchaGenerator captchaGenerator = new CaptchaGenerator(calculator, operandGenerator, operatorGenerator);

        boolean continueCaptcha = true;
        while(continueCaptcha){
            Captcha captcha = captchaGenerator.generate();
            System.out.print(captcha);
            Scanner reader = new Scanner(System.in);
            int inputAnswer = reader.nextInt();
            if(captcha.checkAnswer(inputAnswer)) {
                System.out.println("Correct result");
                break;
            }else{
                System.out.println("Wrong result!! Please try again.");
                System.out.println("Correct result is " + captcha.getExpectedResult());
            }
        }

    }
}
