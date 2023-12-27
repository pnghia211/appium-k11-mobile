package tests.parallel;

import org.testng.annotations.Test;
import test_flows.authen.SwipeFlow;
import tests.BaseTest;

public class SwipeTest extends BaseTest {

    @Test
    public void testWebview() {
        SwipeFlow swipeFlow = new SwipeFlow(getDriver());
        swipeFlow.goToSwipeScreen();
        swipeFlow.swipeAndVerify();
        swipeFlow.swipeRight();
        swipeFlow.swipeDownToEle();
        System.out.println("Session ID : " + getDriver().getSessionId());
    }
}
