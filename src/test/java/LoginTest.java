import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class LoginTest {

    private String siteName = "https://news.ycombinator.com/login?goto=news";
    private String email = "{your login}";
    private String password = "{your password}";
    private WebDriver webDriver;
    private WebDriverWait wait;

    @Before
    public void setUp() throws Exception {
        this.webDriver = new FirefoxDriver();
        this.webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        this.wait = new WebDriverWait(this.webDriver, 20);
    }

    @Test
    public void testLogin(){

        this.webDriver.get(this.siteName);
        this.webDriver.findElement(By.name("acct")).sendKeys(this.email);
        this.webDriver.findElement(By.name("pw")).sendKeys(this.password);
        this.webDriver.findElement(By.xpath("//input[@value='login']")).click();
        wait.until(ExpectedConditions.titleContains("Hacker News"));

    }

}
