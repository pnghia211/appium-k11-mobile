package models.components;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import support.SwipeEx;

public class SwipeComponent {

    private final AppiumDriver<MobileElement> appiumDriver;

    public By navSwipeSel = MobileBy.AccessibilityId("Swipe");

    public SwipeComponent(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public void clickNavSwipeBtn() {
        WebDriverWait wait = new WebDriverWait(appiumDriver, 5);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(navSwipeSel));
        appiumDriver.findElement(navSwipeSel).click();
    }

    public void swipeLeft() {
        SwipeEx swipe = new SwipeEx(appiumDriver);
        for (int i = 0; i < 5; i++) {
            swipe.swipeLeft();
        }
    }

    public void swipeRight() {
        SwipeEx swipe = new SwipeEx(appiumDriver);
        for (int i = 0; i < 5; i++) {
            swipe.swipeRight();
        }
    }

    public void swipeUp() {
        SwipeEx swipe = new SwipeEx(appiumDriver);
        swipe.swipeUp();
    }

    public void swipeToEle() {
        String element = "You found me!!!";
        MobileElement youFoundMeEle = appiumDriver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))" +
                        ".scrollIntoView(new UiSelector().text(\"" + element + "\"))"));
    }

}
