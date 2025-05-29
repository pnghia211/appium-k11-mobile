package tests.testNG;

import org.testng.annotations.*;

public class TestNGHook01 extends BaseTestNG {



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
        System.out.println("\t\t\t\t" + this.getClass().getSimpleName() + " || Test method 01");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("\t\t\t" + this.getClass().getSimpleName() + " || After Method");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("\t\t" + this.getClass().getSimpleName() + " || After Class");
    }




}
