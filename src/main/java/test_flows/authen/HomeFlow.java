package test_flows.authen;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.components.global.HomeComponent;
import models.pages.MainScreen;
import org.testng.Assert;
import test_flows.BaseFlow;

public class HomeFlow extends BaseFlow {

    public HomeFlow(AppiumDriver<MobileElement> appiumDriver) {
        super(appiumDriver);
    }

    public void verifyHomeScreen() {
        MainScreen mainScreen = new MainScreen(appiumDriver);
        HomeComponent homeComp = mainScreen.homeComp();
        if (!homeComp.homeScreen().isDisplayed()) {
            Assert.fail("[ERR] home screen is not displaying");
        }
    }

    public void verifySupport() {
        MainScreen mainScreen = new MainScreen(appiumDriver);
        HomeComponent homeComp = mainScreen.homeComp();
        if (!homeComp.supportText().isDisplayed()) {
            Assert.fail("[ERR] support text is not displaying");
        }
    }
}
