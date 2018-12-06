package ru.itis;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.fail;
import ru.itis.helpers.LoginHelper;
import ru.itis.helpers.NavigationHelper;
import ru.itis.helpers.PostHelper;

public class AppManager {

    public WebDriver webDriver;
    public WebDriverWait wait;
    public String baseUrl = "https://news.ycombinator.com/newest";

    private StringBuffer verificationErrors = new StringBuffer();
    private NavigationHelper navigationHelper;
    private LoginHelper loginHelper;
    private PostHelper postHelper;

    private static AppManager instance;

    public PostHelper getPostHelper() {
        return postHelper;
    }

    public LoginHelper getLoginHelper() {
        return loginHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public AppManager() {
        webDriver = new FirefoxDriver();
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wait = new WebDriverWait(this.webDriver, 20);
        navigationHelper = new NavigationHelper(this);
        loginHelper = new LoginHelper(this);
        postHelper = new PostHelper(this);
    }

    public static AppManager getInstance() {
        AppManager result = instance;
        if (result == null) {
            synchronized (AppManager.class) {
                result = instance;
                if (result == null)
                    instance = result = new AppManager();
            }
        }
        return result;
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public void stop(){
        webDriver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    public void shutDown() {
        try {
            webDriver.quit();
        } catch (Throwable e) {
            //ignore
        }
    }

}
