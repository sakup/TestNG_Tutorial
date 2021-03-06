package extentreports;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class Login {

    WebDriver driver;
    String baseUrl;
    ExtentReports report;
    ExtentTest test;
    HomePage hp;

    @BeforeClass
    public void beforeClass() {
        report = ExtentFactory.getnstance();
        test = report.startTest("Verify Welcome Text");
        driver = new FirefoxDriver();
        hp = new HomePage(driver, test);

        baseUrl = "https://letskodeit.com/";
        test.log(LogStatus.INFO, "Browser Started");
        driver.manage().window().maximize();
        test.log(LogStatus.INFO, "Browser Maximized");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseUrl);
        test.log(LogStatus.INFO, "Web application open");
    }

    @Test
    public void test1_validLoginTest() throws Exception {
        hp.clickSigUpLink();
        hp.clickLoginLink();
        hp.enterEmail("test@mail.com");
        hp.enterPassword("abcabc");
        hp.ckickGoButton();

        Thread.sleep(3000);

        boolean result = hp.isWelcomeTextPresent();

        Assert.assertTrue(result);
        test.log(LogStatus.PASS, "Verified Welcome Text");

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
        report.endTest(test);
        report.flush();
    }
}
