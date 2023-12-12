package test_flows;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.components.global.BottomNavComponent;
import models.pages.MainScreen;

public class BaseFlow {
    protected final AppiumDriver<MobileElement> appiumDriver;

    public BaseFlow(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }


    public void goToFormScreen () {
        MainScreen mainScreen = new MainScreen(appiumDriver);
        BottomNavComponent bottomNavComp = mainScreen.bottomNavComp();
        bottomNavComp.clickNavLoginBtn();
    }

    public void goToLoginScreen () {
        MainScreen mainScreen = new MainScreen(appiumDriver);
        BottomNavComponent bottomNavComp = mainScreen.bottomNavComp();
        bottomNavComp.clickNavLoginBtn();
    }
}
