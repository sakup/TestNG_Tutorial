package testclasses;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNG_Parameters {

    @BeforeClass
    @Parameters({"browser", "platform"})
    public void setUp(String browser, String platform) {
        System.out.println("TestNG_TestParameters -> Setup");
        System.out.println("1. Parameter value from xml file: " + browser);
        System.out.println("2. Parameter value from xml file: " + platform);
    }

    @Test
    @Parameters({"response"})
    public void testMethod1(String response) throws InterruptedException {
        String[] stringAray = response.split(",");
        System.out.println("TestNG_TestParameters -> testMethod1");
        System.out.println("Response from xml file: " + response);
        System.out.println("stringArray[0] from xml file: " + stringAray[0]);
        System.out.println("stringArray[1] from xml file: " + stringAray[1]);
    }
}
