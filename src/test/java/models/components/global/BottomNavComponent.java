package models.components.global;

import driver.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import platform.Platform;

public class BottomNavComponent {
    private final AppiumDriver<MobileElement> appiumDriver;
    private final By navLoginBtn = MobileBy.AccessibilityId("Login");


    public BottomNavComponent(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public void clickNavLoginBtn () {
        appiumDriver.findElement(navLoginBtn).click();
    }
}
