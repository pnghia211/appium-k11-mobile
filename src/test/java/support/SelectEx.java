package support;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelectEx extends Select {
    public SelectEx(WebElement element) {
        super(element);
    }

    private final String OPTION_1 = "webdriver.io is awesome";
    private final String OPTION_2 = "Appium is awesome";
    private final String OPTION_3 = "This app is awesome";

    public void selectOption1() {
        selectByVisibleText(OPTION_1);
    }

    public void selectOption2() {
        selectByVisibleText(OPTION_2);
    }

    public void selectOption3() {
        selectByVisibleText(OPTION_3);
    }
}
