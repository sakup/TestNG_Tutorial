package testclasses;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestNG_SeleniumParallelTest {

    WebDriver driver;
    String baseUrl;

    @BeforeClass
    @Parameters({"browser"})
    public void setUp(String browser) {
        baseUrl = "https://letskodeit.teachable.com/";
        if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        }
//        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }

    @Test
    public void testLogin() throws InterruptedException {
        WebElement loginLing = driver.findElement(By.xpath("a//[contains(@href, '/sign_in"));
        loginLing.click();
        WebElement emailField = driver.findElement(By.id("user_email"));
        emailField.sendKeys("test@email.com");
        WebElement passwordField = driver.findElement(By.id("user_password"));
        passwordField.sendKeys("123123123");
        WebElement loginButton = driver.findElement(By.name("commit"));
        loginButton.click();
    }

    @AfterClass
    public void cleanUp() {
        driver.quit();
    }
}
