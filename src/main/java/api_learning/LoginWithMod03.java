package api_learning;

import driver.Lesson02_DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import models.pages.LoginScreenMod03;
import org.testng.asserts.SoftAssert;
import platform.Lesson02_Platform;

public class LoginWithMod03 {
    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver = Lesson02_DriverFactory.getDriver(Lesson02_Platform.android);

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

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertAll();
        appiumDriver.quit();
    }
}

