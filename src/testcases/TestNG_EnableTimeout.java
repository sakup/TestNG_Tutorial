package testcases;

import appcode.SomeClassToTest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNG_EnableTimeout {

    @BeforeClass
    public void setUp(){
        System.out.println("before class");
    }

    @AfterClass
    public void cleanUp(){
        System.out.println(" after class");
    }


    @Test(enabled = false)
    public void testMethod1(){
        System.out.println("testMethod1");
    }

    @Test(timeOut = 100)
    public void testMethod2()throws InterruptedException{
        System.out.println("testMethod2");
        Thread.sleep(200);
    }

    @Test
    public void testMethod3(){
        System.out.println("testMethod3");
    }
}
