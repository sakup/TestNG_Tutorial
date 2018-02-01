package testclasses;


import appcode.SomeClassToTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNG_Asserts {

    @Test
    public void testSum() {
        System.out.println("Running Test -> testSum");
        SomeClassToTest obj = new SomeClassToTest();
        int result = obj.sumNumbers(1,2);
        Assert.assertEquals(result, 3);
    }

    @Test
    public void testString() {
        System.out.println("Running Test -> testString");
        String expectedString = "Hello World";
        SomeClassToTest obj = new SomeClassToTest();
        String result = obj.addString("Hello", "World");
        Assert.assertEquals(result, expectedString);
    }

    @Test
    public void testArrays() {
        System.out.println("Running Test -> testArrays");
        int[] expectedArray = {1, 2, 3, 4};
        SomeClassToTest obj = new SomeClassToTest();
        int[] result = obj.getArray();
        Assert.assertEquals(result, expectedArray);
        System.out.println("\n End test testArray");
    }
}
