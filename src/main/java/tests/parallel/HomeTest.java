package tests.parallel;

import io.appium.java_client.AppiumDriver;
import org.testng.annotations.Test;
import test_flows.authen.HomeFlow;
import tests.BaseTest;

public class HomeTest extends BaseTest {

    @Test
    public void testHome () {
        HomeFlow homeFlow = new HomeFlow(getDriver());
        homeFlow.goToHomeScreen();
        homeFlow.verifyHomeScreen();
        homeFlow.verifySupport();
    }
}
