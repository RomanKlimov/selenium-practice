import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public String siteName = "https://news.ycombinator.com/login?goto=news";
    public String siteName2 = "https://news.ycombinator.com/submit";
    public String homePage = "https://news.ycombinator.com/";
    public WebDriver webDriver;
    public WebDriverWait wait;
    Set allCookies;
    AccountData user = new AccountData();

    @Before
    public void setUp() throws Exception {
        this.webDriver = new FirefoxDriver();
        this.webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        this.wait = new WebDriverWait(this.webDriver, 20);
    }

    public void OpenHomePage() {
        this.webDriver.get(homePage);
    }

    public void Login(){
        this.webDriver.findElement(By.xpath("//*[@id=\"hnmain\"]/tbody/tr[1]/td/table/tbody/tr/td[3]/span/a")).click();

        this.webDriver.findElement(By.name("acct")).sendKeys(user.login);
        this.webDriver.findElement(By.name("pw")).sendKeys(user.password);
        this.webDriver.findElement(By.xpath("//input[@value='login']")).click();
    }

    public void OpenSubmitPage() {
        this.webDriver.findElement(By.xpath("//a[@href='submit']")).click();
    }

    public void CreatePost() {
        this.webDriver.findElement(By.xpath("/html/body/center/table/tbody/tr[3]/td/form/table/tbody/tr[1]/td[2]/input")).sendKeys("ТЕСТОВЫЙ ПОСТ");
        this.webDriver.findElement(By.xpath("/html/body/center/table/tbody/tr[3]/td/form/table/tbody/tr[4]/td[2]/textarea")).sendKeys("ТЕСТОВЫЙ ПОСТ");
        this.webDriver.findElement(By.xpath("//*[@id=\"hnmain\"]/tbody/tr[3]/td/form/table/tbody/tr[6]/td[2]/input")).click();
    }
}
