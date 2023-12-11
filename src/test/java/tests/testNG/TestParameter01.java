package tests.testNG;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.GregorianCalendar;

public class TestParameter01 {

    @Test
    @Parameters({"udid", "systemPort"})
    public void testParameter01(String udid, String systemPort) {
        System.out.println(new GregorianCalendar().getTime());
        System.out.printf("Udid : %s | SystemPort : %s\n", udid, systemPort);
    }
}
