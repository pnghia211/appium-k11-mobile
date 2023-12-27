package models.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.components.Forms.FormsComponent;
import models.components.SwipeComponent;
import models.components.WebviewComponent;
import models.components.global.BottomNavComponent;
import models.components.global.HomeComponent;
import models.components.login.LoginFormComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainScreen {
    private final AppiumDriver<MobileElement> appiumDriver;

    public MainScreen(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public BottomNavComponent bottomNavComp() {
        return new BottomNavComponent(appiumDriver);
    }

    public HomeComponent homeComp() {
        return new HomeComponent(appiumDriver);
    }

    public WebviewComponent webviewComp() {
        return new WebviewComponent(appiumDriver);
    }

    public LoginFormComponent loginFormComp() {
        return new LoginFormComponent(appiumDriver);
    }

    public FormsComponent formsComp() {
        return new FormsComponent(appiumDriver);
    }

    public SwipeComponent swipeComp() {
        return new SwipeComponent(appiumDriver);
    }
}
