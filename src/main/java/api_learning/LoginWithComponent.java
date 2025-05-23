package api_learning;

import driver.Lesson02_DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.components.login.LoginFormComponent;
import models.pages.MainScreen;
import platform.Lesson02_Platform;

public class LoginWithComponent {
    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver = Lesson02_DriverFactory.getDriver(Lesson02_Platform.android);

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
