package models.components.login;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginFormComponent {
    private final AppiumDriver<MobileElement> appiumDriver;
    private final By userNameSel = MobileBy.AccessibilityId("input-email");
    private final By passwordSel = MobileBy.AccessibilityId("input-password");
    private final By loginBtnSel = MobileBy.AccessibilityId("button-LOGIN");

    private final By invalidEmailSel = MobileBy.xpath("//*[contains(@text, \"Please enter a valid email address\")]");
    private final By invalidPasswordSel = MobileBy.xpath("//*[contains(@text, \"Please enter at least 8 characters\")]");
    private final By validLoginSel = MobileBy.xpath("//*[contains(@text, \"Success\")]");


    public LoginFormComponent(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver, Duration.ofSeconds(10)),this);
    }

    @Step("Input username as {userNameTxt}")
    public LoginFormComponent inputUserName(String userNameTxt) {
        MobileElement userEle = appiumDriver.findElement(userNameSel);
        userEle.clear();
        userEle.sendKeys(userNameTxt);
        return this;
    }

    @Step("Input password as {passwordTxt}")
    public LoginFormComponent inputPassword(String passwordTxt) {
        MobileElement passwordEle = appiumDriver.findElement(passwordSel);
        passwordEle.clear();
        passwordEle.sendKeys(passwordTxt);
        return this;
    }

    public String verifyValidLoginStr() {
        WebDriverWait wait = new WebDriverWait(appiumDriver, 2000);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(validLoginSel));
        return appiumDriver.findElement(validLoginSel).getText();
    }


    @AndroidFindBy(xpath = "//*[contains(@text, \"Please enter a valid email address\")]")
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"Please enter a valid email address\"")
    private MobileElement invalidEmailStr;

    public String verifyInvalidEmailStr() {
        return invalidEmailStr.getText();
    }

    @AndroidFindBy(xpath = "//*[contains(@text, \"Please enter at least 8 characters\")]")
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"Please enter at least 8 characters\"")
    private MobileElement invalidPasswordStr;

    public String verifyInvalidPasswordStr() {
        return invalidPasswordStr.getText();
    }

    @Step("Click login button")
    public void clickLoginBtn() {
        appiumDriver.findElement(loginBtnSel).click();
    }
}
