package test_flows.authen;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.components.login.LoginFormComponent;
import models.pages.MainScreen;
import org.apache.commons.validator.routines.EmailValidator;
import test_flows.BaseFlow;

public class LoginFlow extends BaseFlow {

    private String email;
    private String password;

    public LoginFlow(AppiumDriver<MobileElement> appiumDriver, String email, String password) {
        super(appiumDriver);
        this.email = email;
        this.password = password;
    }

    public void login() {
        MainScreen mainScreen = new MainScreen(appiumDriver);
        LoginFormComponent loginFormComp = mainScreen.loginFormComp();

        if (!email.isEmpty()) {
            loginFormComp.inputUserName(email);
        }

        if (!password.isEmpty()) {
            loginFormComp.inputPassword(password);
        }

        loginFormComp.clickLoginBtn();
    }

    public void verifyLogin() {
        LoginFormComponent loginFormComp = new MainScreen(appiumDriver).loginFormComp();
        boolean isEmailValid = EmailValidator.getInstance().isValid(email);
        boolean isPasswordValid = password.length() >= 8;

        if (isEmailValid && isPasswordValid) {
            verifyValidLogin(loginFormComp);
        }

        if (!isEmailValid) {
            verifyInvalidEmail(loginFormComp);
        }

        if (!isPasswordValid) {
            verifyInvalidPassword(loginFormComp);
        }
    }

    private void verifyValidLogin(LoginFormComponent loginFormComp) {
        String expectedLoginDialogString = "OK";
        String actualLoginDialogString = loginFormComp.verifyValidLoginStr();
        if (expectedLoginDialogString.equals(actualLoginDialogString)) {
            System.out.println("Verify login successfully!!!");
        } else System.out.println("Verify login fail");
    }

    private void verifyInvalidEmail(LoginFormComponent loginFormComp) {
        String expectedEmailString = "Please enter a valid email address";
        String actualEmailString = loginFormComp.verifyInvalidEmailStr();
        if (expectedEmailString.equals(actualEmailString)) {
            System.out.println("Verify invalid email successfully!!!");
        } else System.out.println("Verify invalid email fail");
    }

    private void verifyInvalidPassword(LoginFormComponent loginFormComp) {
        String expectedPasswordString = "Please enter at least 8 characters";
        String actualPasswordString = loginFormComp.verifyInvalidPasswordStr();
        if (expectedPasswordString.equals(actualPasswordString)) {
            System.out.println("Verify invalid password successfully!!!");
        } else System.out.println("Verify invalid password fail");

    }
}
