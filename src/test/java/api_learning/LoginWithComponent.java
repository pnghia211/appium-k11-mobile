package api_learning;

import driver.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import models.components.login.LoginFormComponent;
import models.pages.LoginScreen;
import models.pages.LoginScreenMod03;
import platform.Platform;

public class LoginWithComponent {
    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platform.ANDROID);

        try {
            LoginScreen loginScreen = new LoginScreen(appiumDriver);
            loginScreen.bottomNavComp().clickNavLoginBtn();

            LoginFormComponent loginFormComp = loginScreen.loginFormComp();
            loginFormComp.inputUserName("teo@sth.com")
                    .inputPassword("12345678")
                    .clickLoginBtn();

        } catch (Exception e) {
            e.printStackTrace();
        }
        appiumDriver.quit();
    }
}
