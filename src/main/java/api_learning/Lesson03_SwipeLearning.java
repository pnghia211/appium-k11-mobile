package api_learning;

import driver.Lesson02_DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import platform.Lesson02_Platform;
import support.SwipeEx;

import java.util.List;

public class Lesson03_SwipeLearning {
    public static void main(String[] args) {

        AppiumDriver<MobileElement> appiumDriver = Lesson02_DriverFactory.getDriver(Lesson02_Platform.android);

        WebDriverWait wait = new WebDriverWait(appiumDriver, 3);
        MobileElement navSwipeEle = appiumDriver.findElement(MobileBy.AccessibilityId("Swipe"));
        wait.until(ExpectedConditions.visibilityOf(navSwipeEle));
        navSwipeEle.click();
        MobileElement swipeScreen = appiumDriver.findElement(MobileBy.AccessibilityId("Swipe-screen"));
        wait.until(ExpectedConditions.visibilityOf(swipeScreen));

        String viewTextExpected = "EXTENDABLE";

        SwipeEx swipe = new SwipeEx(appiumDriver);
//        swipe.swipeLeft();

        for (int time = 0; time < 5; time++) {
            List<MobileElement> slideTextContainers = appiumDriver.findElements(MobileBy.AccessibilityId("slideTextContainer"));
//            MobileElement slideTextContainer = slideTextContainers.get(1).findElement(MobileBy.className("android.widget.TextView"));
            MobileElement slideTextContainer = time == 0 ? slideTextContainers.get(0).findElement(MobileBy.className("android.widget.TextView"))
                    : slideTextContainers.get(1).findElement(MobileBy.className("android.widget.TextView"));

            String viewText = slideTextContainer.getText();
            if (viewText.equals(viewTextExpected)) {
                System.out.println(viewTextExpected + " have been found!!!");
                break;
            } else {
                swipe.swipeLeft();
            }
        }
        appiumDriver.quit();
    }
}

