package Reporting;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.seleniumhq.jetty9.util.IO;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.io.Serializable;

public class ExtntRprts extends ExtentReportListener{

    public static ExtentReports extent;
    public static ExtentTest ExtentTestlogger;
    private IO FileUtils;

    public static ExtentReports ExtentReportGenerator(){
        extent = new ExtentReports(System.getProperty("user.dir")+"\\Extent-Reports\\ExtentReportResults.html", true);
        extent.addSystemInfo("Tester", "NEL");
        return extent;

    }

}
