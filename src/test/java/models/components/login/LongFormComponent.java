package models.components.login;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LongFormComponent {
    private final AppiumDriver<MobileElement> appiumDriver;
    private final By userNameSel = MobileBy.AccessibilityId("input-email");
    private final  By passwordSel = MobileBy.AccessibilityId("input-password");
    private final By loginBtnSel = MobileBy.AccessibilityId("button-LOGIN");

    private final By invalidEmailSel = MobileBy.xpath("//*[contains(@text, \"Please enter a valid email address\")]");
    private final By invalidPasswordSel = MobileBy.xpath("//*[contains(@text, \"Please enter at least 8 characters\")]");
    private final By validLoginSel = MobileBy.xpath("//*[contains(@text, \"Success\")]");


    public LongFormComponent(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public LongFormComponent inputUserName(String userNameTxt) {
        MobileElement userEle = appiumDriver.findElement(userNameSel);
        userEle.clear();
        userEle.sendKeys(userNameTxt);
        return this;
    }

    public LongFormComponent inputPassword(String passwordTxt) {
        MobileElement passwordEle = appiumDriver.findElement(passwordSel);
        passwordEle.clear();
        passwordEle.sendKeys(passwordTxt);
        return this;
    }

    public String verifyValidLoginStr() {
        WebDriverWait wait = new WebDriverWait(appiumDriver,2000);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(validLoginSel));
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
