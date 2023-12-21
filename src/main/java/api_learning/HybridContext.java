package api_learning;

import driver.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import platform.Contexts;
import platform.Platform;
import support.WaitContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HybridContext implements Contexts {
    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platform.android);

        try {
            MobileElement navWebViewBtn = appiumDriver.findElement(MobileBy.AccessibilityId("Webview"));
            navWebViewBtn.click();

            // Create custom explicit wait for context
            WebDriverWait wait = new WebDriverWait(appiumDriver, 1);
            wait.until(new WaitContext(appiumDriver));

            appiumDriver.context(Contexts.WEB_VIEW);

            // Click Toggle button and wait Side Bar show up
            MobileElement navToggleBtn = appiumDriver.findElementByCssSelector(".navbar__toggle");
            MobileElement navSideBar = appiumDriver.findElementByCssSelector(".navbar-sidebar");
            navToggleBtn.click();
            wait.until(ExpectedConditions.visibilityOf(navSideBar));

            // List multiple matching
            List<MobileElement> menuItemList = appiumDriver.findElementsByCssSelector(".menu__list li a");
            HashMap<String, String> menuItemData = new HashMap<>();
            List<itemMenuData> itemsMenuData = new ArrayList<>();

            //Handle List empty
            if (menuItemList.isEmpty()) {
                throw new RuntimeException("[ERR] List is empty!!!");
            }

            for (MobileElement menuItem : menuItemList) {
                String itemHref = menuItem.getAttribute("href");
                String itemText = menuItem.getText();
                if (itemText.isEmpty()) {
                    if (itemHref.contains("github")) {
                        itemsMenuData.add(new itemMenuData("github", itemHref));
                    } else if (itemHref.contains("twitter")) {
                        itemsMenuData.add(new itemMenuData("twitter", itemHref));
                    } else if (itemHref.contains("youtube")) {
                        itemsMenuData.add(new itemMenuData("youtube", itemHref));
                    } else if (itemHref.contains("discord")) {
                        itemsMenuData.add(new itemMenuData("discord", itemHref));
                    }
//                menuItemData.put(text, href);
                }
                 else itemsMenuData.add(new itemMenuData(itemText, itemHref));
            }

            // Verification vie Map
//            for (String itemData : menuItemData.keySet()) {
//                System.out.println("Menu item : " + itemData);
//                System.out.println("Href item : " + menuItemData.get(itemData));
//            }

            // Verify via Inner Class
            for (itemMenuData itemMenu : itemsMenuData) {
                System.out.println(itemMenu);
            }

        } catch (
                Exception e) {
            e.printStackTrace();
        }

        appiumDriver.quit();
    }

    public static class itemMenuData {
        String text;
        String href;

        public itemMenuData(String Text, String Href) {
            this.text = Text;
            this.href = Href;
        }

        public String getText() {
            return text;
        }

        public String getHref() {
            return href;
        }

        @Override
        public String toString() {
            return "itemMenuData{" +
                    "text='" + text + '\'' +
                    ", href='" + href + '\'' +
                    '}';
        }
    }
}
