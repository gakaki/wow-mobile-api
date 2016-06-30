import com.sun.org.apache.xpath.internal.operations.Bool;
import com.wow.user.util.PasswordUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.NoSuchAlgorithmException;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TestPwd.class)
public class TestPwd {

    private static final Logger logger = LoggerFactory.getLogger(TestPwd.class);

    @Test
    public void TestPasswordGenAndValidate() throws NoSuchAlgorithmException {

        String userPwd          = "z123456";
        String pwdHash          = PasswordUtil.passwordHashGenerate(userPwd);
        Boolean res_validate    = PasswordUtil.passwordHashValidate(userPwd,pwdHash);
        assertTrue(res_validate == true);
    }
    @Test
    public void TestPasswordValidate() throws NoSuchAlgorithmException {
        String userPwd          = "z5896321";
        String pwdHashTest      = "4a8068bf0ff40948a2ff557520ede477:RQdJesFxhOI6EfLGJJUMaDE57YR5iEOF";
        Boolean res_validate    = PasswordUtil.passwordHashValidate(userPwd,pwdHashTest);
        assertTrue(res_validate == true);
    }

}