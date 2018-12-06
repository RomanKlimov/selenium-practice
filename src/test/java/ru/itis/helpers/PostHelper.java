package ru.itis.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.itis.AppManager;
import ru.itis.bases.HelperBase;

import java.util.List;

public class PostHelper extends HelperBase {
    public PostHelper(AppManager appManager) {
        super(appManager);
    }
    public static String postTitle = "ТЕСТОВЫЙ ПОСТ";
    public static String postBody = "ТЕСТОВЫЙ ПОСТ";

    public void addPost() {
        getAppManager().getWebDriver().findElement(By.xpath("/html/body/center/table/tbody/tr[3]/td/form/table/tbody/tr[1]/td[2]/input")).sendKeys(postTitle);
        getAppManager().getWebDriver().findElement(By.xpath("/html/body/center/table/tbody/tr[3]/td/form/table/tbody/tr[4]/td[2]/textarea")).sendKeys(postBody);
        getAppManager().getWebDriver().findElement(By.xpath("//*[@id=\"hnmain\"]/tbody/tr[3]/td/form/table/tbody/tr[6]/td[2]/input")).click();
    }

    public boolean getLastAddedPostTitl() {
        getAppManager().getNavigationHelper().getBaseUrl();
        List<WebElement> storylink = getAppManager().getWebDriver().findElements(By.className("storylink"));
        for (WebElement element : storylink) {
            if (element.getText().equals("ТЕСТОВЫЙ ПОСТ")) {
                return false;
            }
        }
        return true;
    }












































}



















