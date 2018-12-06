package ru.itis.bases;

import lombok.Data;
import org.junit.Before;
import ru.itis.bases.TestBase;
import ru.itis.entities.AccountData;
import ru.itis.helpers.LoginHelper;

@Data
public class AuthTestBase extends TestBase {
    @Before
    public void setUp() throws Exception {
        super.setUp();

        AccountData userData = new AccountData("test00007", "qwerty007");
        getAppManager().getNavigationHelper().getLoginPage();
        getAppManager().getLoginHelper().doLogin(userData);
    }
}
