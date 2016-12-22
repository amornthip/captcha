package captcha;


public class Captcha {

    private int first;
    private int second;
    private String operator;
    private int expectedResult;


    public Captcha(int first, String operator, int second, int expectedResult) {
        this.first = first;
        this.second = second;
        this.operator = operator;
        this.expectedResult = expectedResult;
    }

    public int getFirst() {
        return first;
    }

    public int getExpectedResult() {
        return expectedResult;
    }


    @Override
    public String toString() {
        return first + operator + second + " = ";
    }

    public boolean checkAnswer(int answer) {
        return this.getExpectedResult() == answer;
    }
}
