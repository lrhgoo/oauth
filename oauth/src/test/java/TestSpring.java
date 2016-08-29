import com.mind.oauth.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by lrh on 2016/8/16.
 */

@RunWith(value = SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class TestSpring {

    private static final String PASSWORD_SECRET = "sz-mind-secret-key";

    private static final PasswordEncoder passwordEncoder = new StandardPasswordEncoder(PASSWORD_SECRET);

    @Test
    public void  t1() {
        System.out.println(passwordEncoder.encode("wyf"));
        System.out.println(passwordEncoder.encode("wyf"));
        System.out.println(passwordEncoder.encode("wyf"));
        System.out.println(passwordEncoder.encode("wyf"));
    }
}
