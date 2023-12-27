package test_flows.authen;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import models.components.SwipeComponent;
import models.pages.MainScreen;
import org.testng.Assert;
import support.SwipeEx;
import test_flows.BaseFlow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SwipeFlow extends BaseFlow {

    public SwipeFlow(AppiumDriver<MobileElement> appiumDriver) {
        super(appiumDriver);
    }

    public void swipeLeft() {
        MainScreen mainScreen = new MainScreen(appiumDriver);
        SwipeComponent swipeComp = mainScreen.swipeComp();
        swipeComp.swipeLeft();
    }

    public void swipeRight() {
        MainScreen mainScreen = new MainScreen(appiumDriver);
        SwipeComponent swipeComp = mainScreen.swipeComp();
        swipeComp.swipeRight();
    }

    public void swipeUp() {
        MainScreen mainScreen = new MainScreen(appiumDriver);
        SwipeComponent swipeComp = mainScreen.swipeComp();
        swipeComp.swipeUp();
    }

    public void swipeDownToEle() {
        MainScreen mainScreen = new MainScreen(appiumDriver);
        SwipeComponent swipeComp = mainScreen.swipeComp();
        swipeComp.swipeToEle();
    }

    public void swipeAndVerify() {
        List<String> expectedTitle = Arrays.asList("FULLY OPEN SOURCE", "GREAT COMMUNITY", "JS.FOUNDATION", "SUPPORT VIDEOS", "EXTENDABLE", "COMPATIBLE");
        List<String> actualTitle = new ArrayList<>();
        actualTitle.add(getFirstTitle());

        SwipeEx swipe = new SwipeEx(appiumDriver);
        for (int time = 0; time < 5; time++) {
            swipe.swipeLeft();
            getTitle();
            actualTitle.add(getTitle());
        }
        if (actualTitle.isEmpty()) {
            Assert.fail("[ERR] actual title list is empty!!!");
        }
        Assert.assertEquals(expectedTitle, actualTitle);
    }

    private String getTitle() {
        List<MobileElement> slideTextContainers = appiumDriver.findElements(MobileBy.AccessibilityId("slideTextContainer"));
        return slideTextContainers.get(1).findElement(MobileBy.className("android.widget.TextView")).getText();
    }

    private String getFirstTitle() {
        List<MobileElement> slideTextContainers = appiumDriver.findElements(MobileBy.AccessibilityId("slideTextContainer"));
        return slideTextContainers.get(0).findElement(MobileBy.className("android.widget.TextView")).getText();
    }
}
