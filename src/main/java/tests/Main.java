package tests;

import com.google.common.reflect.ClassPath;
import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;
import platform.Lesson02_Platform;
import support.Lesson02_MobileCapabilityTypeEx;

import java.io.IOException;
import java.security.SecureRandom;
import java.util.*;

public class Main implements Lesson02_MobileCapabilityTypeEx {
    @SuppressWarnings("UnstableApiUsage")
    public static void main(String[] args) throws IOException {
        final ClassLoader loader = Thread.currentThread().getContextClassLoader();
        List<Class<?>> testClasses = new ArrayList<>();

        for (ClassPath.ClassInfo info : ClassPath.from(loader).getTopLevelClasses()) {
            String classInfoName = info.getName();
            Boolean startWithTest = classInfoName.startsWith("tests.");
            Boolean isBaseTestClass = classInfoName.startsWith("tests.BaseTest");
            Boolean isMainClass = classInfoName.startsWith("tests.Main");

            if (startWithTest && !isMainClass && !isBaseTestClass) {
                testClasses.add(info.load());
            }
        }

        // Get platform
        String platformName = System.getProperty("platform");
        if (platformName == null) throw new IllegalArgumentException("[ERR] please provide platform via -Dplatform");

        try {
            Lesson02_Platform.valueOf(platformName);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERR] we dont support platform: " + platformName);
        }

        // Get devices
        List<String> iphoneDeviceList = Arrays.asList("iphone 12", "iphone 13");
        List<String> androidDeviceList = Arrays.asList("emulator-5556", "emulator-5554");
        List<String> deviceList = platformName.equalsIgnoreCase("ios") ? iphoneDeviceList : androidDeviceList;

        // Assign test classes into devices
        final int testNumEachDevice = testClasses.size() / deviceList.size();
        Map<String, List<Class<?>>> dedicatedCaps = new HashMap<>();

        for (int deviceIndex = 0; deviceIndex < deviceList.size(); deviceIndex++) {

            int startIndex = deviceIndex * testNumEachDevice;
            boolean isLastDevice = deviceIndex == deviceList.size() - 1;
            int endIndex = isLastDevice ? testClasses.size() : startIndex + testNumEachDevice;
            List<Class<?>> subList = testClasses.subList(startIndex, endIndex);
            dedicatedCaps.put(deviceList.get(deviceIndex), subList);
        }

        // Build dynamic test suite
        TestNG testNG = new TestNG();
        XmlSuite xmlSuite = new XmlSuite();
        xmlSuite.setName("Regression");

        List<XmlTest> allTests = new ArrayList<>();
        for (String deviceName : dedicatedCaps.keySet()) {
            XmlTest xmlTest = new XmlTest(xmlSuite);
            xmlTest.setName(deviceName);

            // Add test class into Xml class
            List<Class<?>> dedicatedClasses = dedicatedCaps.get(deviceName);
            List<XmlClass> xmlClasses = new ArrayList<>();
            for (Class<?> dedicatedClass : dedicatedClasses) {
                xmlClasses.add(new XmlClass(dedicatedClass));
            }

            // Add Xml classes into Xml test,
            switch (Lesson02_Platform.valueOf(platformName)) {
                case android:
                    xmlTest.setXmlClasses(xmlClasses);
                    xmlTest.addParameter(PLATFORM_NAME, platformName);
                    xmlTest.addParameter(UDID, deviceName);
                    xmlTest.addParameter(SYSTEM_PORT, String.valueOf(new SecureRandom().nextInt(1000) + 8300));
                    allTests.add(xmlTest);
                    break;
                case ios:
                    xmlTest.setXmlClasses(xmlClasses);
                    xmlTest.addParameter(PLATFORM_NAME, platformName);
                    xmlTest.addParameter(PLATFORM_VERSION, "12");
                    allTests.add(xmlTest);
                    break;
            }
        }

        xmlSuite.setTests(allTests);
        xmlSuite.setParallel(XmlSuite.ParallelMode.TESTS);
        xmlSuite.setThreadCount(10);

        System.out.println(xmlSuite.toXml());

            List<XmlSuite> suites = new ArrayList<>();
            suites.add(xmlSuite);

            testNG.setXmlSuites(suites);
            testNG.run();
    }
}
