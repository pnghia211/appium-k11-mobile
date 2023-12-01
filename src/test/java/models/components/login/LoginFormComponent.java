package models.components.login;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class LoginFormComponent {
    private final AppiumDriver<MobileElement> appiumDriver;
    By userNameSel = MobileBy.AccessibilityId("input-email");
    By passwordSel = MobileBy.AccessibilityId("input-password");
    By loginBtnSel = MobileBy.AccessibilityId("button-LOGIN");

    public LoginFormComponent(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public LoginFormComponent inputUserName(String userNameTxt) {
        appiumDriver.findElement(userNameSel).sendKeys(userNameTxt);
        return this;
    }
    public LoginFormComponent inputPassword(String passwordTxt) {
        appiumDriver.findElement(passwordSel).sendKeys(passwordTxt);
        return this;
    }
    public void clickLoginBtn() {
        appiumDriver.findElement(loginBtnSel).click();
    }

}
