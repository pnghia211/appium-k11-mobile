package api_learning;

import driver.Lesson02_DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import models.pages.LoginScreenMod02;
import platform.Lesson02_Platform;

public class LoginWithMod02 {
    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver = Lesson02_DriverFactory.getDriver(Lesson02_Platform.android);

        try {
            MobileElement navLoginBtn = appiumDriver.findElement(MobileBy.AccessibilityId("Login"));
            navLoginBtn.click();

            LoginScreenMod02 loginScreen = new LoginScreenMod02(appiumDriver);
            loginScreen.inputUserName("teo@sth.com");
            loginScreen.inputPassword("12345678");
            loginScreen.clickLoginBtn();
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        appiumDriver.quit();
    }
}

