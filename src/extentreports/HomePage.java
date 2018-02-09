package extentreports;


import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.NoSuchElementException;

public class HomePage {

    ExtentTest test;
    WebDriver driver = null;

    public HomePage(WebDriver driver, ExtentTest test) {
        this.driver = driver;
        this.test = test;
    }

    public void clickSigUpLink() {
        WebElement singupLink = driver.findElement(By.id("comp-iiqg1vggactionTitle"));
        singupLink.click();
        test.log(LogStatus.INFO, "Clicked on sigup link.");
    }

    public void clickLoginLink() {
        WebElement loginLink = driver.findElement(By.id("signUpDialogswitchDialogLink"));
        loginLink.click();
        test.log(LogStatus.INFO, "Clicked on login link");
    }

    public void enterEmail(String email) {
        WebElement emailField = driver.findElement(By.id("memberLoginDialogemailInputinput"));
        emailField.sendKeys(email);
        test.log(LogStatus.INFO, "Entered email");
    }

    public void enterPassword(String password) {
        WebElement passwordField = driver.findElement(By.id("memberLoginDialogpasswordInputinput"));
        passwordField.sendKeys(password);
        test.log(LogStatus.INFO, "Entered password");
    }
    public void ckickGoButton() {
        WebElement goButton = driver.findElement(By.id("memberLoginDialogokButton"));
        goButton.click();
        test.log(LogStatus.INFO, "Clicked GO Button");
    }

    public boolean isWelcomeTextPresent(){
        WebElement welcomeText = null;

        try {
            welcomeText = driver.findElement(By.xpath("//div[text()='Hello test@mail.com']"));
            if (welcomeText !=null) {
                return true;
            }
        }
        catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return false;
    }

}
