package testclasses;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class TestNG_ITestResultDemo {

    @Test
    public void testMethod1() {
        System.out.println("Running -> testMethod1");
        Assert.assertTrue(false);
    }

    @Test
    public void testMethod2() {
        System.out.println("Running -> testMethod2");
        Assert.assertTrue(true);
    }

    @AfterMethod
    public void afterMethod(ITestResult testRusult) {
        if (testRusult.getStatus() == ITestResult.FAILURE) {
            System.out.println("Failed: " + testRusult.getMethod().getMethodName());
        }
        if (testRusult.getStatus() == ITestResult.SUCCESS) {
            System.out.println("Successful: " + testRusult.getMethod().getMethodName());
        }
    }
}
