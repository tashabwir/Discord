package Reporting;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class ExtntRprts {

    static ExtentTest test;
    static ExtentReports report;

    @BeforeClass
    public static void startTest() {
        report = new ExtentReports(System.getProperty("user.dir")+"\\ExtentReportResults.html");
        test = report.startTest("ExtentDemo");
    }

//    test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "Test Failed");
//    public static String capture(WebDriver driver) throws IOException {
//        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//        File Dest = new File("src/../ErrImages/" + System.currentTimeMillis()
//                + ".png");
//        String errflpath = Dest.getAbsolutePath();
//        FileUtils.copyFile(scrFile, Dest);
//        return errflpath;
//    }

    @AfterClass
    public static void endTest() {

        report.endTest(test);
        report.flush();
    }


    public void ExtentReportGenerator(){

    }

}
