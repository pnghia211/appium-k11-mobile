package models.components.global;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BottomNavComponent {
    private final AppiumDriver<MobileElement> appiumDriver;
    private final By navHomeBtn = MobileBy.AccessibilityId("Home");
    private final By navLoginBtn = MobileBy.AccessibilityId("Login");
    private final By navFormsBtn = MobileBy.AccessibilityId("Forms");
    private final By navWebviewBtn = MobileBy.AccessibilityId("Webview");


    public BottomNavComponent(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public void clickNavHomeBtn () {
        appiumDriver.findElement(navHomeBtn).click();
    }
    public void clickNavFormsBtn () {
        appiumDriver.findElement(navFormsBtn).click();
    }

    public void clickWebviewBtn () {
        appiumDriver.findElement(navWebviewBtn).click();
    }

    public void clickNavLoginBtn () {
        WebDriverWait wait = new WebDriverWait(appiumDriver,10);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(navLoginBtn));
        appiumDriver.findElement(navLoginBtn).click();
    }
}
