package ru.itis.helpers;

import org.openqa.selenium.NoSuchElementException;
import ru.itis.AppManager;
import ru.itis.bases.HelperBase;
import ru.itis.entities.AccountData;
import org.openqa.selenium.By;

public class LoginHelper extends HelperBase {
    public static String userLogin = "test00007";
    public static String userPassword = "qwerty007";
    public static String invalidUser = "invalid";
    public static String invalidPassword = "invalid";

    public static AccountData USER = new AccountData(userLogin, userPassword);
    public static AccountData INVALIDUSER = new AccountData(invalidUser, invalidPassword);

    public LoginHelper(AppManager appManager) {
        super(appManager);
    }

    public void doLogin(AccountData data){

        if (isLoggedIn(data.getLogin())) {
            return;
        } else if (isLoggedIn()) {
            doLogout();
        }
        getAppManager().getWebDriver().findElement(By.xpath("//*[@id=\"hnmain\"]/tbody/tr[1]/td/table/tbody/tr/td[3]/span/a")).click();
        getAppManager().getWebDriver().findElement(By.name("acct")).sendKeys(data.getLogin());
        getAppManager().getWebDriver().findElement(By.name("pw")).sendKeys(data.getPassword());
        getAppManager().getWebDriver().findElement(By.xpath("//input[@value='login']")).click();
    }

    public String getUserLoginOnPage() {
        getAppManager().getNavigationHelper().getBaseUrl();
        String userLogin = getAppManager().getWebDriver().findElement(By.id("me")).getText();
        return userLogin;
    }

    public boolean isLoggedIn() {
        try {
            getAppManager().getWebDriver().findElement(By.id("logout"));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isLoggedIn(String username) {
        if (isLoggedIn()) {
            String userLogin = getUserLoginOnPage();
            return userLogin != null && userLogin.contains(username);
        }
        return false;
    }

    private void doLogout() {
        getAppManager().getNavigationHelper().getBaseUrl();
        getAppManager().getWebDriver().findElement(By.id("logout")).click();
    }




}
