package api_learning;

import driver.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import models.pages.LoginScreenMod03;
import platform.Platform;

public class LoginWithMod03 {
    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platform.ANDROID);

        try {
            MobileElement navLoginBtn = appiumDriver.findElement(MobileBy.AccessibilityId("Login"));
            navLoginBtn.click();

            LoginScreenMod03 loginScreen = new LoginScreenMod03(appiumDriver);
            loginScreen.inputUserName("teo@sth.com")
                    .inputPassword("12345678")
                    .clickLoginBtn();

        } catch (Exception e) {
            e.printStackTrace();
        }

        appiumDriver.quit();
    }
}

