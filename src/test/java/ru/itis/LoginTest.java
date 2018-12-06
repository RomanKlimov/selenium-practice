package ru.itis;

import org.junit.Assert;
import org.junit.Test;
import ru.itis.bases.TestBase;
import ru.itis.entities.AccountData;

public class LoginTest extends TestBase {

    @Test
    public void loginWithValidData() {
        AccountData userData = new AccountData("test00007", "qwerty007");
        getAppManager().getNavigationHelper().getLoginPage();
        getAppManager().getLoginHelper().doLogin(userData);

        Assert.assertTrue(getAppManager().getLoginHelper().isLoggedIn(userData.getLogin()));
    }

    @Test
    public void loginWithInvalidData() {
        AccountData userData = new AccountData("test00007", "invalidPassword");
        getAppManager().getNavigationHelper().getLoginPage();
        getAppManager().getLoginHelper().doLogin(userData);

        Assert.assertFalse(getAppManager().getLoginHelper().isLoggedIn(userData.getLogin()));
    }

}
