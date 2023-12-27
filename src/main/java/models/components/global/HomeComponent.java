package models.components.global;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class HomeComponent {
    private final AppiumDriver<MobileElement> appiumDriver;

    private By homeScreenSel = MobileBy.AccessibilityId("Home-screen");
    private By supportTextSel = MobileBy.xpath("//*[contains(@text, \"Support\")]");

    public HomeComponent(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public MobileElement homeScreen() {
        return appiumDriver.findElement(homeScreenSel);
    }

    public MobileElement supportText() {
        return appiumDriver.findElement(supportTextSel);
    }
}
