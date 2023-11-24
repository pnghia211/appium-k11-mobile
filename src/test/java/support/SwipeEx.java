package support;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;

import java.time.Duration;

public class SwipeEx {

    final AppiumDriver<MobileElement> appiumDriver;

    public SwipeEx(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public void swipeUp() {


        // Calculate touch point
        int xStartPoint = 50 * getScreenWidth() / 100;
        int xEndPoint = 50 * getScreenWidth() / 100;

        int yStartPoint = 50 * getScreenHeight() / 100;
        int yEndPoint = 10 * getScreenHeight() / 100;

        // Convert coordinate
        PointOption startPoint = new PointOption<>().withCoordinates(xStartPoint, yStartPoint);
        PointOption endPoint = new PointOption<>().withCoordinates(xEndPoint, yEndPoint);
        TouchAction touchAction = new TouchAction(appiumDriver);
        touchAction.press(startPoint).waitAction(new WaitOptions().withDuration(Duration.ofMillis(1000)))
                .moveTo(endPoint).release().perform();
    }

    public void swipeDown() {

        // Calculate touch point
        int xStartPoint = 50 * getScreenWidth() / 100;
        int xEndPoint = 50 * getScreenWidth() / 100;

        int yStartPoint = 50 * getScreenHeight() / 100;
        int yEndPoint = 10 * getScreenHeight() / 100;

        // Convert coordinate
        PointOption startPoint = new PointOption<>().withCoordinates(xStartPoint, yStartPoint);
        PointOption endPoint = new PointOption<>().withCoordinates(xEndPoint, yEndPoint);
        TouchAction touchAction = new TouchAction(appiumDriver);
        touchAction.press(endPoint).waitAction(new WaitOptions().withDuration(Duration.ofMillis(1000)))
                .moveTo(startPoint).release().perform();
    }

    public void swipeLeft () {

        // Calculate touch point
        int xStartPoint = 50 * getScreenWidth() / 100;
        int xEndPoint = 10 * getScreenWidth() / 100;

        int yStartPoint = 70 * getScreenHeight() / 100;
        int yEndPoint = 70 * getScreenHeight() / 100;

        // Convert coordinate
        PointOption startPoint = new PointOption<>().withCoordinates(xStartPoint, yStartPoint);
        PointOption endPoint = new PointOption<>().withCoordinates(xEndPoint, yEndPoint);
        TouchAction touchAction = new TouchAction(appiumDriver);
        touchAction.press(startPoint).waitAction(new WaitOptions().withDuration(Duration.ofMillis(1000)))
                .moveTo(endPoint).release().perform();
    }

    public void swipeRight () {

        // Calculate touch point
        int xStartPoint = 50 * getScreenWidth() / 100;
        int xEndPoint = 10 * getScreenWidth() / 100;

        int yStartPoint = 70 * getScreenHeight() / 100;
        int yEndPoint = 70 * getScreenHeight() / 100;

        // Convert coordinate
        PointOption startPoint = new PointOption<>().withCoordinates(xStartPoint, yStartPoint);
        PointOption endPoint = new PointOption<>().withCoordinates(xEndPoint, yEndPoint);
        TouchAction touchAction = new TouchAction(appiumDriver);
        touchAction.press(endPoint).waitAction(new WaitOptions().withDuration(Duration.ofMillis(1000)))
                .moveTo(startPoint).release().perform();
    }


    private int getScreenWidth () {
        Dimension screenSize = appiumDriver.manage().window().getSize();
        return screenSize.getWidth();

    }

    private int getScreenHeight () {
        Dimension screenSize = appiumDriver.manage().window().getSize();
        return screenSize.getHeight();
    }
}
