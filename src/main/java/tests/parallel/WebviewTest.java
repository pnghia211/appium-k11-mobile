package tests.parallel;

import org.testng.annotations.Test;
import test_flows.webview.WebviewFlow;
import tests.BaseTest;

public class WebviewTest extends BaseTest {

    @Test
    public void testWebview() {
        WebviewFlow webviewFlow = new WebviewFlow(getDriver());
        webviewFlow.goToWebviewScreen();
        webviewFlow.switchWebviewCtx();
        webviewFlow.clickSideBar();
        webviewFlow.verifyMenuTexts();
        webviewFlow.switchNativeCtx();
        System.out.println("Session ID : " + getDriver().getSessionId());
    }
}
