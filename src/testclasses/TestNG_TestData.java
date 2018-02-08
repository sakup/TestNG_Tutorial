package testclasses;

import org.testng.annotations.DataProvider;


public class TestNG_TestData {

    @DataProvider(name = "inputs")
    public Object[] [] getData() {
        return new Object[][] {
                {"bmw", "m3"},
                {"audi","a6"},
                {"benz", "g63"},
        };
    }
}
