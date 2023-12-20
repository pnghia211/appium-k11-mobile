package api_learning;

import driver.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import models.pages.LoginScreenMod01;
import platform.Platform;

public class LoginWithMod01 {
    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platform.android);

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

