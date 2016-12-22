package captcha;

import java.util.Random;


public class RandomUtil {
    public int random(int size) {
        Random rand = new Random();
        return rand.nextInt(size);
    }
}
