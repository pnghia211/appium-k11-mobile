package models.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class LoginScreenMod01 {
    private final AppiumDriver<MobileElement> appiumDriver;
    By userNameSel = MobileBy.AccessibilityId("input-email");
    By passwordSel = MobileBy.AccessibilityId("input-password");
    By loginBtnSel = MobileBy.AccessibilityId("button-LOGIN");

    public LoginScreenMod01(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public MobileElement userName() {
        return appiumDriver.findElement(userNameSel);
    }

    public MobileElement password() {
        return appiumDriver.findElement(passwordSel);
    }

    public MobileElement loginBtn() {
        return appiumDriver.findElement(loginBtnSel);
    }
}
