package api_learning;

import driver.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import platform.Platform;
import support.SwipeEx;

import java.util.List;

public class NarrowDown {
    public static void main(String[] args) throws InterruptedException {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platform.android);
        Thread.sleep(2000);

        try {

            SwipeEx swipeEx = new SwipeEx(appiumDriver);
            swipeEx.swipeDown();

            List<MobileElement> notRowList = appiumDriver.findElements(MobileBy.id("android:id/notification_headerless_view_column"));

            if (notRowList.isEmpty()) {
                throw new RuntimeException("[ERR] List is empty!!!");
            }

            for (MobileElement notRowEle : notRowList) {
                String topNotStr = notRowEle.findElement(MobileBy.id("android:id/title")).getText();
                String mainNotStr = notRowEle.findElement(MobileBy.id("android:id/text")).getText();

                System.out.println(topNotStr);
                System.out.println(mainNotStr);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        appiumDriver.quit();
    }
}
 
