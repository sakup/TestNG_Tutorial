package testclasses;


import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners(CustomListener2.class)
public class TestNG_ListenersTest2 {
    @BeforeClass
    public void setUp() {
        System.out.println("before class");
    }

    @AfterClass
    public void cleanUp() {
        System.out.println("after class");
    }

    @Test
    public void testMethod1() {
        System.out.println("testMethod1");
        Assert.assertTrue(true);
    }

    @Test
    public void testMethod2() {
        System.out.println("testMethod2");
        Assert.assertTrue(false);
    }
}
