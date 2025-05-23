package api_learning;

import driver.Lesson02_DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import platform.Lesson02_Platform;

public class Lesson02_LoginFormTest {
    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver = Lesson02_DriverFactory.getDriver(Lesson02_Platform.android);

        try {
            MobileElement navLoginBtn = appiumDriver.findElement(MobileBy.AccessibilityId("Login"));
            navLoginBtn.click();

            MobileElement emailEle = appiumDriver.findElement(MobileBy.AccessibilityId("input-email"));
            MobileElement passwordEle = appiumDriver.findElement(MobileBy.AccessibilityId("input-password"));
            MobileElement loginBtnEle = appiumDriver.findElement(MobileBy.AccessibilityId("button-LOGIN"));

            emailEle.sendKeys("teo@sth.com");
            passwordEle.sendKeys("12345678");
            loginBtnEle.click();

            WebDriverWait wait = new WebDriverWait(appiumDriver, 10);
            wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.id("android:id/alertTitle")));
            MobileElement loginPopUp = appiumDriver.findElement(MobileBy.id("android:id/alertTitle"));
            System.out.println(loginPopUp.getText());

        } catch (Exception e) {
            e.printStackTrace();
        }
        appiumDriver.quit();
    }
}
