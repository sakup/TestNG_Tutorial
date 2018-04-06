package datadriven;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.ExcelUtility;
import utilities.Constants;

import java.util.concurrent.TimeUnit;

public class UsingExcel {
    private WebDriver driver;

    @BeforeClass
    public void setUp() throws Exception {
        driver = new FirefoxDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(Constants.URL);
        driver.findElement(By.xpath("//span[text()='Learn Now']")).click();
        ExcelUtility.setExcelFile(Constants.File_Path + Constants.File_Name, "login_test");
    }

    @DataProvider(name = "loginData")
    public Object[][] dataProvider() {
        Object[][] testData = ExcelUtility.getTestData("Invalid_Data");
        return testData;
    }

    @Test(dataProvider = "loginData")
    public void testUsingExcel(String username, String password) throws Exception {
        //Click login button
        driver.findElement(By.xpath(".//div[@id='navbar']//a[contains(text(), 'Login')]")).click();

        Thread.sleep(2000);
        //Enter username
        driver.findElement(By.id("user_email")).sendKeys(username);
        //Enter password
        driver.findElement(By.id("user_password")).sendKeys(password);
        //Click login button
        driver.findElement(By.name("commit")).click();
        Thread.sleep(2000);

        //Find if error meassages
        boolean result = driver.findElements(By.xpath("//div[contains(text(),'Invalid email or password')]")).size() != 0;
        Assert.assertTrue(result);
    }

    @AfterClass
    public void tearDown() throws Exception {
//        driver.quit();
    }

}
