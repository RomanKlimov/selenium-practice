package ru.itis.helpers;

import org.openqa.selenium.By;
import ru.itis.AppManager;
import ru.itis.bases.HelperBase;

public class NavigationHelper extends HelperBase {

    public NavigationHelper(AppManager appManager) {
        super(appManager);
    }

    public void getLoginPage() {
        getAppManager().getWebDriver().get("https://news.ycombinator.com/newest");
    }

    public void getSubmitPage() {
        getAppManager().getWebDriver().findElement(By.xpath("//a[@href='submit']")).click();
    }

}
