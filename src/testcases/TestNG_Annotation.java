package testcases;

import appcode.SomeClassToTest;
import org.testng.annotations.Test;


public class TestNG_Annotation {

    @Test
    public void testMethod1() {
        SomeClassToTest obj = new SomeClassToTest();
        int result = obj.sumNumbers(1,2);
        System.out.println("Running test -> testMethod1");
    }

    @Test
    public void testMethod2() {
        System.out.println("Running test -> testMethod2");
    }

    @Test
    public void testMethod3() {
        System.out.println("Running test -> testMethod3");
    }
}
