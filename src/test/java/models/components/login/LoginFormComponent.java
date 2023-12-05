package models.components.login;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class LoginFormComponent {
    private final AppiumDriver<MobileElement> appiumDriver;
    private final By userNameSel = MobileBy.AccessibilityId("input-email");
    private final  By passwordSel = MobileBy.AccessibilityId("input-password");
    private final By loginBtnSel = MobileBy.AccessibilityId("button-LOGIN");

    private final By invalidEmailSel = MobileBy.xpath("//*[contains(@text, \"Please enter a valid email address\")]");
    private final By invalidPasswordSel = MobileBy.xpath("//*[contains(@text, \"Please enter at least 8 characters\")]");
    private final By validLoginSel = MobileBy.xpath("//*[contains(@text, \"OK\")]");




    public LoginFormComponent(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public LoginFormComponent inputUserName(String userNameTxt) {
        MobileElement userEle = appiumDriver.findElement(userNameSel);
        userEle.clear();
        userEle.sendKeys(userNameTxt);
        return this;
    }

    public LoginFormComponent inputPassword(String passwordTxt) {
        MobileElement passwordEle = appiumDriver.findElement(passwordSel);
        passwordEle.clear();
        passwordEle.sendKeys(passwordTxt);
        return this;
    }

    public String verifyValidLoginStr() {
        return appiumDriver.findElement(validLoginSel).getText();
    }

    public String verifyInvalidEmailStr() {
        return appiumDriver.findElement(invalidEmailSel).getText();
    }

    public String verifyInvalidPasswordStr() {
        return appiumDriver.findElement(invalidPasswordSel).getText();
    }

    public void clickLoginBtn() {
        appiumDriver.findElement(loginBtnSel).click();
    }
}
