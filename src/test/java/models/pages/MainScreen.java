package models.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.components.global.BottomNavComponent;
import models.components.login.LoginFormComponent;

public class MainScreen {
    private final AppiumDriver<MobileElement> appiumDriver;

    public MainScreen(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public BottomNavComponent bottomNavComp() {
        return new BottomNavComponent(appiumDriver);
    }

    public LoginFormComponent loginFormComp() {
        return new LoginFormComponent(appiumDriver);
    }
}
