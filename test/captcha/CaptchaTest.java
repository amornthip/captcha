package captcha;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CaptchaTest {

    private Captcha captcha;

    @Before
    public void setUp() throws Exception {
        captcha = new Captcha(10, "+", 20, 30);
    }

    @Test
    public void toString_shouldReturnExpectedExpression() throws Exception {
        assertThat(captcha.toString(), is("10+20 = "));
    }

    @Test
    public void checkAnswer_WhenGivenExpectedResult_shouldReturnTrue() throws Exception {
        assertThat(captcha.checkAnswer(30), is(true));
    }

    @Test
    public void checkAnswer_WhenGivenUnExpectedResult_shouldReturnFalse() throws Exception {
        assertThat(captcha.checkAnswer(40000), is(false));
    }
}