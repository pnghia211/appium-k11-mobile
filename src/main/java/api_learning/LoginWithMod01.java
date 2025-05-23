package api_learning;

import driver.Lesson02_DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import models.pages.LoginScreenMod01;
import platform.Lesson02_Platform;

public class LoginWithMod01 {
    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver = Lesson02_DriverFactory.getDriver(Lesson02_Platform.android);

        try {
            MobileElement navLoginBtn = appiumDriver.findElement(MobileBy.AccessibilityId("Login"));
            navLoginBtn.click();

            LoginScreenMod01 loginScreen = new LoginScreenMod01(appiumDriver);
            loginScreen.userName().sendKeys("teo@sth.com");
            loginScreen.password().sendKeys("12345678");
            loginScreen.loginBtn().click();

        } catch (Exception e) {
            e.printStackTrace();
        }

        appiumDriver.quit();
    }
}

