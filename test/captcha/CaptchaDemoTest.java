package captcha;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class CaptchaDemoTest {

    private CaptchaDemo captchaDemo;

    @Before
    public void setUp() throws Exception {
        captchaDemo = new CaptchaDemo();
    }

    @Test
    public void getQuestion_shouldReturnQuestionThatMatchWithExpectRegularExpression() throws Exception {
        assertThat(captchaDemo.getCaptchaQuestion().matches(".*(\\d)[+*-](\\d).*"), is(true));
    }

    @Test
    public void checkAnswer_whenGivenCorrectAnswer_shouldReturnTrue() throws Exception {
        captchaDemo.getCaptchaQuestion();

        Captcha currentCaptcha = captchaDemo.getCurrentCaptcha();

        assertThat(captchaDemo.checkAnswer(currentCaptcha.getExpectedResult()), is(true));
    }

    @Test
    public void checkAnswer_whenGivenIncorrectAnswer_shouldReturnFalse() throws Exception {
        captchaDemo.getCaptchaQuestion();

        Captcha currentCaptcha = captchaDemo.getCurrentCaptcha();

        assertThat(captchaDemo.checkAnswer((currentCaptcha.getExpectedResult() + 3) * 2), is(false));
    }
}