package api_learning;

import driver.Lesson02_DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import platform.Lesson02_Platform;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lesson03_NarrowDown {
    public static void main(String[] args) throws InterruptedException {
        AppiumDriver<MobileElement> appiumDriver = Lesson02_DriverFactory.getDriver(Lesson02_Platform.android);
        Thread.sleep(2000);

        Dimension screenSize = appiumDriver.manage().window().getSize();
        int screenWidth = screenSize.getWidth();
        int screenHeight = screenSize.getHeight();

        // Calculate touch point
        int xStartPoint = 50 * screenWidth / 100;
        int xEndPoint = 50 * screenWidth / 100;

        int yStartPoint = 0 * screenHeight / 100;
        int yEndPoint = 10 * screenHeight / 100;

        PointOption startPoint = new PointOption().withCoordinates(xStartPoint, yStartPoint);
        PointOption endPoint = new PointOption().withCoordinates(xEndPoint, yEndPoint);

        TouchAction touchAction = new TouchAction(appiumDriver);
        touchAction
                .press(startPoint)
                .waitAction(new WaitOptions().withDuration(Duration.ofSeconds(3)))
                .moveTo(endPoint)
                .release()
                .perform();

        try {
            Thread.sleep(3000);
            List<MobileElement> notRowList = appiumDriver.findElements(MobileBy.id("android:id/notification_headerless_view_column"));

            // Check list is not empty || False negative
            if (notRowList.isEmpty()) {
                throw new RuntimeException("[ERR] List is empty!!!");
            }

            Map<String, String> notificationContents = new HashMap<>();
            for (MobileElement notRowEle : notRowList) {
                String titleEle = notRowEle.findElement(MobileBy.id("android:id/title")).getText();
                String contentEle = notRowEle.findElement(MobileBy.id("android:id/text")).getText();
                notificationContents.put(titleEle, contentEle);
            }

            // Verification
            for (String title : notificationContents.keySet()) {
                System.out.println("Title: " + title);
                System.out.println("Content: " + notificationContents.get(title));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        appiumDriver.quit();
    }
}
 
