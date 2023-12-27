package test_flows;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.components.SwipeComponent;
import models.components.global.BottomNavComponent;
import models.components.global.HomeComponent;
import models.pages.MainScreen;
import tests.Main;

public class BaseFlow {
    protected final AppiumDriver<MobileElement> appiumDriver;

    public BaseFlow(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public void goToHomeScreen() {
        MainScreen mainScreen = new MainScreen(appiumDriver);
        BottomNavComponent bottomNavComp = mainScreen.bottomNavComp();
        bottomNavComp.clickNavHomeBtn();
    }

    public void goToLoginScreen() {
        MainScreen mainScreen = new MainScreen(appiumDriver);
        BottomNavComponent bottomNavComp = mainScreen.bottomNavComp();
        bottomNavComp.clickNavLoginBtn();
    }

    public void goToWebviewScreen() {
        MainScreen mainScreen = new MainScreen(appiumDriver);
        BottomNavComponent bottomNavComp = mainScreen.bottomNavComp();
        bottomNavComp.clickWebviewBtn();
    }

    public void goToFormScreen() {
        MainScreen mainScreen = new MainScreen(appiumDriver);
        BottomNavComponent bottomNavComp = mainScreen.bottomNavComp();
        bottomNavComp.clickNavFormsBtn();
    }

    public void goToSwipeScreen() {
        MainScreen mainScreen = new MainScreen(appiumDriver);
        SwipeComponent swipeComp = mainScreen.swipeComp();
        swipeComp.clickNavSwipeBtn();
    }
}
