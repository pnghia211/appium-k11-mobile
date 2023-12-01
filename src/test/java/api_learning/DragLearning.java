package api_learning;

import driver.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import platform.Platform;

import java.time.Duration;

public class DragLearning {

    static AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platform.ANDROID);
    public static void main(String[] args) {

        MobileElement navLoginBtn = appiumDriver.findElement(MobileBy.AccessibilityId("Drag"));
        navLoginBtn.click();

        DragLearning dragLearning = new DragLearning();
        dragLearning.dragP1();
        dragLearning.dragP2();
        dragLearning.dragP3();
        dragLearning.dragP4();
        dragLearning.dragP5();
        dragLearning.dragP6();
        dragLearning.dragP7();
        dragLearning.dragP8();
        dragLearning.dragP9();
    }

    private void dragP1 () {
        // Calculate touch point
        int xStartPoint = 50 * getScreenWidth() / 100;
        int xEndPoint = 35 * getScreenWidth() / 100;

        int yStartPoint = 90 * getScreenHeight() / 100;
        int yEndPoint = 20 * getScreenHeight() / 100;

        // Convert coordinate
        PointOption startPoint = new PointOption<>().withCoordinates(xStartPoint, yStartPoint);
        PointOption endPoint = new PointOption<>().withCoordinates(xEndPoint, yEndPoint);
        TouchAction touchAction = new TouchAction(appiumDriver);
        touchAction.press(startPoint).waitAction(new WaitOptions().withDuration(Duration.ofMillis(500)))
                .moveTo(endPoint).release().perform();
    }

    private void dragP2 () {
        // Calculate touch point
        int xStartPoint = 55 * getScreenWidth() / 100;
        int xEndPoint = 50 * getScreenWidth() / 100;

        int yStartPoint = 85 * getScreenHeight() / 100;
        int yEndPoint = 20 * getScreenHeight() / 100;

        // Convert coordinate
        PointOption startPoint = new PointOption<>().withCoordinates(xStartPoint, yStartPoint);
        PointOption endPoint = new PointOption<>().withCoordinates(xEndPoint, yEndPoint);
        TouchAction touchAction = new TouchAction(appiumDriver);
        touchAction.press(startPoint).waitAction(new WaitOptions().withDuration(Duration.ofMillis(500)))
                .moveTo(endPoint).release().perform();
    }

    private void dragP3 () {
        // Calculate touch point
        int xStartPoint = 45 * getScreenWidth() / 100;
        int xEndPoint = 65 * getScreenWidth() / 100;

        int yStartPoint = 85 * getScreenHeight() / 100;
        int yEndPoint = 20 * getScreenHeight() / 100;

        // Convert coordinate
        PointOption startPoint = new PointOption<>().withCoordinates(xStartPoint, yStartPoint);
        PointOption endPoint = new PointOption<>().withCoordinates(xEndPoint, yEndPoint);
        TouchAction touchAction = new TouchAction(appiumDriver);
        touchAction.press(startPoint).waitAction(new WaitOptions().withDuration(Duration.ofMillis(500)))
                .moveTo(endPoint).release().perform();
    }

    private void dragP4 () {
        // Calculate touch point
        int xStartPoint = 10 * getScreenWidth() / 100;
        int xEndPoint = 30 * getScreenWidth() / 100;

        int yStartPoint = 85 * getScreenHeight() / 100;
        int yEndPoint = 30 * getScreenHeight() / 100;

        // Convert coordinate
        PointOption startPoint = new PointOption<>().withCoordinates(xStartPoint, yStartPoint);
        PointOption endPoint = new PointOption<>().withCoordinates(xEndPoint, yEndPoint);
        TouchAction touchAction = new TouchAction(appiumDriver);
        touchAction.press(startPoint).waitAction(new WaitOptions().withDuration(Duration.ofMillis(500)))
                .moveTo(endPoint).release().perform();
    }

    private void dragP5 () {
        // Calculate touch point
        int xStartPoint = 30 * getScreenWidth() / 100;
        int xEndPoint = 50 * getScreenWidth() / 100;

        int yStartPoint = 90 * getScreenHeight() / 100;
        int yEndPoint = 30 * getScreenHeight() / 100;

        // Convert coordinate
        PointOption startPoint = new PointOption<>().withCoordinates(xStartPoint, yStartPoint);
        PointOption endPoint = new PointOption<>().withCoordinates(xEndPoint, yEndPoint);
        TouchAction touchAction = new TouchAction(appiumDriver);
        touchAction.press(startPoint).waitAction(new WaitOptions().withDuration(Duration.ofMillis(500)))
                .moveTo(endPoint).release().perform();
    }

    private void dragP6 () {
        // Calculate touch point
        int xStartPoint = 85 * getScreenWidth() / 100;
        int xEndPoint = 75 * getScreenWidth() / 100;

        int yStartPoint = 85 * getScreenHeight() / 100;
        int yEndPoint = 30 * getScreenHeight() / 100;

        // Convert coordinate
        PointOption startPoint = new PointOption<>().withCoordinates(xStartPoint, yStartPoint);
        PointOption endPoint = new PointOption<>().withCoordinates(xEndPoint, yEndPoint);
        TouchAction touchAction = new TouchAction(appiumDriver);
        touchAction.press(startPoint).waitAction(new WaitOptions().withDuration(Duration.ofMillis(500)))
                .moveTo(endPoint).release().perform();
    }

    private void dragP7 () {
        // Calculate touch point
        int xStartPoint = 65 * getScreenWidth() / 100;
        int xEndPoint = 25 * getScreenWidth() / 100;

        int yStartPoint = 90 * getScreenHeight() / 100;
        int yEndPoint = 40 * getScreenHeight() / 100;

        // Convert coordinate
        PointOption startPoint = new PointOption<>().withCoordinates(xStartPoint, yStartPoint);
        PointOption endPoint = new PointOption<>().withCoordinates(xEndPoint, yEndPoint);
        TouchAction touchAction = new TouchAction(appiumDriver);
        touchAction.press(startPoint).waitAction(new WaitOptions().withDuration(Duration.ofMillis(500)))
                .moveTo(endPoint).release().perform();
    }

    private void dragP8 () {
        // Calculate touch point
        int xStartPoint = 75 * getScreenWidth() / 100;
        int xEndPoint = 50 * getScreenWidth() / 100;

        int yStartPoint = 85 * getScreenHeight() / 100;
        int yEndPoint = 40 * getScreenHeight() / 100;

        // Convert coordinate
        PointOption startPoint = new PointOption<>().withCoordinates(xStartPoint, yStartPoint);
        PointOption endPoint = new PointOption<>().withCoordinates(xEndPoint, yEndPoint);
        TouchAction touchAction = new TouchAction(appiumDriver);
        touchAction.press(startPoint).waitAction(new WaitOptions().withDuration(Duration.ofMillis(500)))
                .moveTo(endPoint).release().perform();
    }

    private void dragP9 () {
        // Calculate touch point
        int xStartPoint = 25 * getScreenWidth() / 100;
        int xEndPoint = 75 * getScreenWidth() / 100;

        int yStartPoint = 85 * getScreenHeight() / 100;
        int yEndPoint = 40 * getScreenHeight() / 100;

        // Convert coordinate
        PointOption startPoint = new PointOption<>().withCoordinates(xStartPoint, yStartPoint);
        PointOption endPoint = new PointOption<>().withCoordinates(xEndPoint, yEndPoint);
        TouchAction touchAction = new TouchAction(appiumDriver);
        touchAction.press(startPoint).waitAction(new WaitOptions().withDuration(Duration.ofMillis(500)))
                .moveTo(endPoint).release().perform();
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
