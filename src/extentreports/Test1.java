package extentreports;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import extentreports.ExtentFactory;
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

public class Test1 {

    WebDriver driver;
    String baseUrl;
    ExtentReports report;
    ExtentTest test;

    @BeforeClass
    public void beforeClass() {
        report = ExtentFactory.getnstance();
        test = report.startTest("Verify Welcome Text");
        driver = new FirefoxDriver();
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
        WebElement singupLink = driver.findElement(By.id("comp-iiqg1vggactionTitle"));
        singupLink.click();
        test.log(LogStatus.INFO, "Clicked on sigup link.");

        WebElement loginLink = driver.findElement(By.id("signUpDialogswitchDialogLink"));
        loginLink.click();
        test.log(LogStatus.INFO, "Clicked on login link");

        WebElement emailField = driver.findElement(By.id("memberLoginDialogemailInputinput"));
        emailField.sendKeys("test@mail.com");
        test.log(LogStatus.INFO, "Entered email");

        WebElement passwordField = driver.findElement(By.id("memberLoginDialogpasswordInputinput"));
        passwordField.sendKeys("abcabc");
        test.log(LogStatus.INFO, "Entered password");

        WebElement goButton = driver.findElement(By.id("memberLoginDialogokButton"));
        goButton.click();
        test.log(LogStatus.INFO, "Clicked GO Button");

        Thread.sleep(3000);


        WebElement welcomeText = null;

        try {
            welcomeText = driver.findElement(By.id("comp-iiqg1vggmemberTitle"));
        }
        catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
        Assert.assertTrue(welcomeText != null);
        test.log(LogStatus.PASS, "Verified Welcome Text");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
        report.endTest(test);
        report.flush();
    }
}
