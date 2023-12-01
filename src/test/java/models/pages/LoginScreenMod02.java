package models.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class LoginScreenMod02 {
    private final AppiumDriver<MobileElement> appiumDriver;
    By userNameSel = MobileBy.AccessibilityId("input-email");
    By passwordSel = MobileBy.AccessibilityId("input-password");
    By loginBtnSel = MobileBy.AccessibilityId("button-LOGIN");

    public LoginScreenMod02(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public void inputUserName(String userNameTxt) {
        appiumDriver.findElement(userNameSel).sendKeys(userNameTxt);
    }

    public void inputPassword(String passwordTxt) {
        appiumDriver.findElement(passwordSel).sendKeys(passwordTxt);
    }

    public void clickLoginBtn() {
        appiumDriver.findElement(loginBtnSel).click();
    }
}
