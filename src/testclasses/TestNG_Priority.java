package testclasses;


import org.testng.annotations.*;

public class TestNG_Priority {

    @BeforeClass
    public void setUp(){
        System.out.println("TestNG_TestClass1 -> before class");
    }

    @AfterClass
    public void cleanUp(){
        System.out.println("TestNG_TestClass1 -> after class");
    }


    @Test(priority = 2)
    public void testMethod1(){
        System.out.println("Running Test -> TestNG_TestClass1 -> testMethod1");
    }

    @Test(priority = 1)
    public void testMethod2(){
        System.out.println("Running Test -> TestNG_TestClass1 -> testMethod2");
    }

    @Test(priority = 0)
    public void testMethod3(){
        System.out.println("Running Test -> TestNG_TestClass1 -> testMethod3");
    }
}
