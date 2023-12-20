package api_learning;

import driver.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import platform.Platform;

public class LoginFormTest {
    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platform.android);

        try {
            MobileElement navLoginBtn = appiumDriver.findElement(MobileBy.AccessibilityId("Login"));
            navLoginBtn.click();

            MobileElement emailEle = appiumDriver.findElement(MobileBy.AccessibilityId("input-email"));
            MobileElement passwordEle = appiumDriver.findElement(MobileBy.AccessibilityId("input-password"));
            MobileElement loginBtnEle = appiumDriver.findElement(MobileBy.AccessibilityId("button-LOGIN"));

            emailEle.sendKeys("teo@sth.com");
            passwordEle.sendKeys("12345678");
            loginBtnEle.click();

            WebDriverWait wait = new WebDriverWait(appiumDriver, 5);
            MobileElement loginPopUp = appiumDriver.findElement(MobileBy.id("android:id/alertTitle"));
            System.out.println(loginPopUp.getText());
            wait.until(ExpectedConditions.visibilityOf(loginPopUp));

        } catch (Exception e) {
            e.printStackTrace();
        }

        appiumDriver.quit();
    }

}
