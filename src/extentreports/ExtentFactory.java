package extentreports;


import com.relevantcodes.extentreports.ExtentReports;

public class ExtentFactory {
    public static ExtentReports getnstance() {
        ExtentReports extent;
        String Path = "./reports/report-demo.html";
        extent = new ExtentReports(Path, false);
        extent
                .addSystemInfo("Selenium version", "3.53")
                .addSystemInfo("Platform", "Win10");

        return extent;
    }
}
