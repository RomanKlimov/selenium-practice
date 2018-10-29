import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;


public class LoginTest  extends TestBase{

    @Before
    public void setUp() throws Exception {
        this.webDriver = new FirefoxDriver();
        this.webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        this.wait = new WebDriverWait(this.webDriver, 20);
    }

    @Test
    public void testLogin(){
        AccountData user = new AccountData();

        this.webDriver.get(siteName);
        this.webDriver.findElement(By.name("acct")).sendKeys(user.login);
        this.webDriver.findElement(By.name("pw")).sendKeys(user.password);
        this.webDriver.findElement(By.xpath("//input[@value='login']")).click();
        wait.until(ExpectedConditions.titleContains("Hacker News"));
    }

    @Test
    public void testSubmit() {
        AccountData user = new AccountData();
        this.webDriver.get(siteName2);
        this.webDriver.findElement(By.name("acct")).sendKeys(user.login);
        this.webDriver.findElement(By.name("pw")).sendKeys(user.password);
        this.webDriver.findElement(By.xpath("//input[@value='login']")).click();
        this.webDriver.findElement(By.name("title")).sendKeys("testPost");
        this.webDriver.findElement(By.name("text")).sendKeys("testPost");
        this.webDriver.findElement(By.xpath("//input[@value='submit']")).click();
    }

}
