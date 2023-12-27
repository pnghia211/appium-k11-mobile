package test_flows.webview;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.components.WebviewComponent;
import models.pages.MainScreen;
import org.testng.Assert;
import test_flows.BaseFlow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WebviewFlow extends BaseFlow {

    public WebviewFlow(AppiumDriver<MobileElement> appiumDriver) {
        super(appiumDriver);
    }

    public void switchWebviewCtx() {
        MainScreen mainScreen = new MainScreen(appiumDriver);
        WebviewComponent webviewComp = mainScreen.webviewComp();
        webviewComp.switchWebviewContext();
    }

    public void clickSideBar() {
        MainScreen mainScreen = new MainScreen(appiumDriver);
        WebviewComponent webviewComp = mainScreen.webviewComp();
        webviewComp.clickNavBarBtn();
    }

    public void verifyMenuTexts() {
        MainScreen mainScreen = new MainScreen(appiumDriver);
        WebviewComponent webviewComp = mainScreen.webviewComp();

        List<String> actualTexts = new ArrayList<>();
        List<String> actualHrefs = new ArrayList<>();

        for (WebviewComponent.menuItemsData menuItemsData : webviewComp.getMenuInfo()) {
            actualTexts.add(menuItemsData.getText());
            actualHrefs.add(menuItemsData.getHref());
        }

        List<String> expectedTexts = Arrays.asList("Docs", "API", "Blog", "Contribute", "Community", "Sponsor",
                "v8", "Languages", "github", "twitter", "youtube", "discord");
        List<String> expectedHrefs = Arrays.asList("/docs/gettingstarted", "/docs/api", "/blog", "/docs/contribute", "/community/support", "/docs/sponsor",
                "/versions", null, "https://github.com/webdriverio/webdriverio", "https://twitter.com/webdriverio",
                "https://youtube.com/@webdriverio", "https://discord.webdriver.io/");

        if (actualTexts.isEmpty() || actualHrefs.isEmpty()) {
            Assert.fail("[ERR] Text list or Href list is empty!!!");
        }

        Assert.assertEquals(actualTexts, expectedTexts);
        Assert.assertEquals(actualHrefs, expectedHrefs);
    }

    public void switchNativeCtx() {
        MainScreen mainScreen = new MainScreen(appiumDriver);
        WebviewComponent webviewComp = mainScreen.webviewComp();
        webviewComp.switchNativeContext();
    }
}
