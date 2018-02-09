package extentreports;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Test2 {
    ExtentReports report;
    ExtentTest test;

    @BeforeClass
    public void beforeClass() {
        report = ExtentFactory.getnstance();
        test = report.startTest("Test2 Class -> Verification");

    }

    @Test
    public void testMethod() {
        test.log(LogStatus.INFO, "Test 2 -> testMethod Started...");
        test.log(LogStatus.INFO, "Test 2 -> testMethod Continuing...");
        test.log(LogStatus.INFO, "Test 2 -> testMethod Ended...");

    }

    @AfterClass
    public void afterClass() {
        report.endTest(test);
        report.flush();
    }

}
