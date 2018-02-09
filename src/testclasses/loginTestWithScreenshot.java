package testclasses;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utilities.Screenshots;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class loginTestWithScreenshot {

    WebDriver driver;
    String baseUrl;
    ExtentReports report;
    ExtentTest test;

    @BeforeClass
    public void beforeClass() {
        report = new ExtentReports("./reports/loginTest.html");
        test = report.startTest("Verify Welcome Text");
        driver = new FirefoxDriver();
        baseUrl = "https://letskodeit.com/";
        test.log(LogStatus.INFO, "Browser Started...");

        driver.manage().window().maximize();
        test.log(LogStatus.INFO, "Browser Maximized...");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseUrl);
        test.log(LogStatus.INFO, "Web application open");
    }

    @Test
    public void test1_validLoginTest() throws Exception {
        WebElement singupLink = driver.findElement(By.id("comp-iiqg1vggactionTitle"));
        singupLink.click();
        test.log(LogStatus.INFO, "Clicked on sigup link...");

        WebElement loginLink = driver.findElement(By.id("signUpDialogswitchDialogLink"));
        loginLink.click();
        test.log(LogStatus.INFO, "Clicked on login link...");

        WebElement emailField = driver.findElement(By.id("memberLoginDialogemailInputinput"));
        emailField.sendKeys("tes4t@mail.com");
        test.log(LogStatus.INFO, "Entered email...");

        WebElement passwordField = driver.findElement(By.id("memberLoginDialogpasswordInputinput"));
        passwordField.sendKeys("abcabc");
        test.log(LogStatus.INFO, "Entered password...");

        WebElement goButton = driver.findElement(By.id("memberLoginDialogokButton"));
        goButton.click();
        test.log(LogStatus.INFO, "Clicked GO Button...");

        Thread.sleep(3000);


        WebElement welcomeText = null;

        try {
            welcomeText = driver.findElement(By.xpath("//div[text()='Hello test@email.com']"));
        }
        catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
        Assert.assertTrue(welcomeText != null);
        test.log(LogStatus.PASS, "Verified Welcome Text");
    }

    @AfterMethod
        public void tearDown(ITestResult testResult) throws IOException {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            String path = Screenshots.tekeScreenshot(driver,testResult.getName());
            String imagePath = test.addScreenCapture(path);
            test.log(LogStatus.FAIL, "Verify Welcome text Failed", imagePath);
        }

        driver.quit();
        report.endTest(test);
        report.flush();
    }
}
