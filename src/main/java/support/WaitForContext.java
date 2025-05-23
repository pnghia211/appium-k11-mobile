package support;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class WaitForContext implements ExpectedCondition<Boolean> {

    private final AppiumDriver<MobileElement> appiumDriver;

    public WaitForContext(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    @NullableDecl
    @Override
    public Boolean apply(@NullableDecl WebDriver webDriver) {
        return appiumDriver.getContextHandles().size()>1;
    }
}
