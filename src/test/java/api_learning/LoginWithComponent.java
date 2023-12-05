package api_learning;

import driver.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.components.login.LoginFormComponent;
import models.pages.MainScreen;
import platform.Platform;

public class LoginWithComponent {
    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platform.ANDROID);

        try {

            // Base flow
            MainScreen mainScreen = new MainScreen(appiumDriver);
            mainScreen.bottomNavComp().clickNavLoginBtn();

            // Login flow
            LoginFormComponent loginFormComp = mainScreen.loginFormComp();
            loginFormComp.inputUserName("teo@sth.com")
                        .inputPassword("12345678")
                        .clickLoginBtn();

        } catch (Exception e) {
            e.printStackTrace();
        }
        appiumDriver.quit();
    }
}
