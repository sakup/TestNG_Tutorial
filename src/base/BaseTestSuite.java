package base;


import org.testng.annotations.*;

public class BaseTestSuite {

    @BeforeClass
    public void beforeClass(){
        System.out.println("BaseTestSuite ->  before class");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("BaseTestSuite ->  after class");
    }

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("BaseTestSuite ->  before suite");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("BaseTestSuite ->  after suite");
    }
}
