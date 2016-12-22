package captcha;

import java.security.InvalidParameterException;

public class Calculator {

    public int calculate(int first, Operators operator, int second) {
        if(operator == null)
            throw new InvalidParameterException();

        return operator.apply(first, second);
    }
}
