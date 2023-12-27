package models.components;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import platform.Contexts;
import support.WaitContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class WebviewComponent {

    private final AppiumDriver<MobileElement> appiumDriver;

    public WebviewComponent(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public void switchWebviewContext() {
        WebDriverWait wait = new WebDriverWait(appiumDriver, 2);
        wait.until(new WaitContext(appiumDriver));
        appiumDriver.context(Contexts.WEB_VIEW);
    }

    public void clickNavBarBtn() {
        MobileElement navToggleEle = appiumDriver.findElementByCssSelector(".navbar__toggle");
        MobileElement sideBarsEle = appiumDriver.findElementByCssSelector(".navbar-sidebar");
        navToggleEle.click();
        WebDriverWait wait = new WebDriverWait(appiumDriver, 3);
        wait.until(ExpectedConditions.visibilityOf(sideBarsEle));
    }

    public List<menuItemsData> getMenuInfo() {
        List<MobileElement> menuItemsEle = appiumDriver.findElementsByCssSelector(".menu__list li a");
        List<menuItemsData> menuItemsData = new ArrayList<>();

        for (MobileElement menuItem : menuItemsEle) {
            String itemText = menuItem.getText();
            String itemHref = menuItem.getAttribute("href");

            if (itemText.equals("languages")) {
                menuItemsData.add(new menuItemsData(itemText, null));
            }
            if (itemText.isEmpty()) {
                if (itemHref.contains("github")) {
                    menuItemsData.add(new menuItemsData("github", itemHref));
                }
                if (itemHref.contains("twitter")) {
                    menuItemsData.add(new menuItemsData("twitter", itemHref));
                }
                if (itemHref.contains("youtube")) {
                    menuItemsData.add(new menuItemsData("youtube", itemHref));
                }
                if (itemHref.contains("discord")) {
                    menuItemsData.add(new menuItemsData("discord", itemHref));
                }
            } else menuItemsData.add(new menuItemsData(itemText, itemHref));
        }
        return menuItemsData;
    }

    public void switchNativeContext() {
        WebDriverWait wait = new WebDriverWait(appiumDriver, 2);
        wait.until(new WaitContext(appiumDriver));
        appiumDriver.context(Contexts.NATIVE_APP);
    }

    public class menuItemsData {

        private String text;
        private String href;

        public menuItemsData(String text, String href) {
            this.text = text;
            this.href = href;
        }

        public String getText() {
            return text;
        }

        public String getHref() {
            return href;
        }

        @Override
        public String toString() {
            return "menuItemsData{" +
                    "text='" + text + '\'' +
                    ", href='" + href + '\'' +
                    '}';
        }
    }
}
