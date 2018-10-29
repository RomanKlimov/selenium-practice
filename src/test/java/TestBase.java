import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBase {
    public String siteName = "https://news.ycombinator.com/login?goto=news";
    public String siteName2 = "https://news.ycombinator.com/submit";
    public WebDriver webDriver;
    public WebDriverWait wait;
}
