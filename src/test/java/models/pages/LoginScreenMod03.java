package models.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class LoginScreenMod03 {
    private final AppiumDriver<MobileElement> appiumDriver;
    By userNameSel = MobileBy.AccessibilityId("input-email");
    By passwordSel = MobileBy.AccessibilityId("input-password");
    By loginBtnSel = MobileBy.AccessibilityId("button-LOGIN");

    public LoginScreenMod03(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }
    public LoginScreenMod03 inputUserName(String userNameTxt) {
        if (!userNameTxt.isEmpty()) appiumDriver.findElement(userNameSel).sendKeys(userNameTxt);
        return this;
    }
    public LoginScreenMod03 inputPassword(String passwordTxt) {
        if (!passwordTxt.isEmpty()) appiumDriver.findElement(passwordSel).sendKeys(passwordTxt);
        return this;
    }
    public void clickLoginBtn() {
        appiumDriver.findElement(loginBtnSel).click();
    }
}
