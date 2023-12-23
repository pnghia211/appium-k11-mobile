package api_learning.tests_explore.testNG;

import org.testng.annotations.*;
import support.Verify;

public class TestNGHook02 {

    @BeforeSuite
    public void beforeSuite() {
        System.out.println(this.getClass().getSimpleName() + " || Before Suite");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("\t" + this.getClass().getSimpleName() + " || Before Test");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("\t\t" + this.getClass().getSimpleName() + " || Before Class");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("\t\t\t" + this.getClass().getSimpleName() + " || Before Method");
    }

    @Test
    public void testSth01() {
        System.out.println("\t\t\t\t" + this.getClass().getSimpleName() + " || Test method 02");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("\t\t\t" + this.getClass().getSimpleName() + " || After Method");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("\t\t" + this.getClass().getSimpleName() + " || After Class");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("\t" + this.getClass().getSimpleName() + " || After Test");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println(this.getClass().getSimpleName() + " || After Suite");
    }
}
