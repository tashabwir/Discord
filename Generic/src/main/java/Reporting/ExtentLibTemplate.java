package Reporting;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.seleniumhq.jetty9.util.IO;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class ExtentLibTemplate {   //public class ExtentReportTest {}
    @Test
    public void verifySeleniumBlog() {
        String extentReportFile = System.getProperty("user.dir") + "\\extentReportFile.html";
        String extentReportImage = System.getProperty("user.dir") + "\\extentReportImage.png";

        // Create object of extent report and specify the report file path.
        ExtentReports extent = new ExtentReports(extentReportFile, false);
        // Start the test using the ExtentTest class object.
        ExtentTest extentTest = extent.startTest("My First Test", "Verify WebSite Title");


        // Launch the FireFox browser.
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("/");
        String title = driver.getTitle();
        Assert.assertTrue(title.contains("Selenium Webdriver"));


        extentTest.log(LogStatus.INFO, "Browser Launched");
        extentTest.log(LogStatus.INFO, "Navigated to www.techbeamers.com");
        extentTest.log(LogStatus.INFO, "Get the WebSite title");
        extentTest.log(LogStatus.PASS, "Title verified");

        // In case you want to attach screenshot then use below method
        // We used a random image but you've to take screenshot at run-time
        // and specify the error image path.
        extentTest.log(LogStatus.INFO, "Error Snapshot : " + extentTest.addScreenCapture(extentReportImage));

        // Close application.
        driver.quit();
        extentTest.log(LogStatus.INFO, "Browser closed");

        // close report.
        extent.endTest(extentTest);
        // writing everything to document.
        extent.flush();
    }

    public void MAFIsCAPIextent(){}//-----------------------------------------

    //ExtentReport
//    public static ExtentReports extent;
//
//    @BeforeSuite
//    public void extentSetup(ITestContext context) {
//        ExtentManager.setOutputDirectory(context);
//        extent = ExtentManager.getInstance();
//    }
//
//    @BeforeMethod
//    public void startExtent(Method method) {
//        String className = method.getDeclaringClass().getSimpleName();
//        String methodName = method.getName().toLowerCase();
//        ExtentTestManager.startTest(method.getName());
//        ExtentTestManager.getTest().assignCategory(className);
//    }
//
//    protected String getStackTrace(Throwable t) {
//        StringWriter sw = new StringWriter();
//        PrintWriter pw = new PrintWriter(sw);
//        t.printStackTrace(pw);
//        return sw.toString();
//    }
//
//    @AfterMethod
//    public void afterEachTestMethod(ITestResult result) {
//        ExtentTestManager.getTest().getTest().setStartedTime(getTime(result.getStartMillis()));
//        ExtentTestManager.getTest().getTest().setEndedTime(getTime(result.getEndMillis()));
//
//        for (String group : result.getMethod().getGroups()) {
//            ExtentTestManager.getTest().assignCategory(group);
//        }
//
//        if (result.getStatus() == 1) {
//            ExtentTestManager.getTest().log(LogStatus.PASS, "Test Passed");
//        } else if (result.getStatus() == 2) {
//            ExtentTestManager.getTest().log(LogStatus.FAIL, getStackTrace(result.getThrowable()));
//        } else if (result.getStatus() == 3) {
//            ExtentTestManager.getTest().log(LogStatus.SKIP, "Test Skipped");
//        }
//        ExtentTestManager.endTest();
//        extent.flush();
//        if (result.getStatus() == ITestResult.FAILURE) {
//            captureScreenshot(driver, result.getName());
//        }
//        driver.quit();
//    }
//
//    @AfterSuite
//    public void generateReport() {
//        extent.close();
//    }

    public void NaveenExtent(){}//-----------------------------------------

    public static class FreeCRMTest {

        public static IO FileUtils;
        public WebDriver driver;
        public ExtentReports extent;
        public ExtentTest extentTest;


        @BeforeTest
        public void setExtent(){
            extent = new ExtentReports(System.getProperty("user.dir")+"/test-output/ExtentReport.html", true);
            extent.addSystemInfo("Host Name", "Naveen Mac");
            extent.addSystemInfo("User Name", "Naveen Automation Labs");
            extent.addSystemInfo("Environment", "QA");

        }

        @AfterTest
        public void endReport(){
            extent.flush();
            extent.close();
        }

        public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException {
            String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            // after execution, you could see a folder "FailedTestsScreenshots"
            // under src folder
            String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/" + screenshotName + dateName
                    + ".png";
            File finalDestination = new File(destination);
            FileUtils.copyFile(source, finalDestination);
            return destination;
        }




        @BeforeMethod
        public void setup(){

            System.setProperty("webdriver.chrome.driver", "/Users/naveenkhunteta/Downloads/chromedriver");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            driver.get("https://www.freecrm.com/");

        }



        @Test
        public void freeCrmTitleTest(){
            extentTest = extent.startTest("freeCrmTitleTest");
            String title = driver.getTitle();
            System.out.println(title);
            Assert.assertEquals(title,"#1 Free CRM for Any Business: Online Customer Relationship Software123");
        }

        @Test
        public void freemCRMLogoTest(){
            extentTest = extent.startTest("freemCRMLogoTest");
            boolean b = driver.findElement(By.xpath("//img[@class='img-responsive111']")).isDisplayed();
            Assert.assertTrue(b);
        }





        @AfterMethod
        public void tearDown(ITestResult result) throws IOException{

            if(result.getStatus()==ITestResult.FAILURE){
                extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS "+result.getName()); //to add name in extent report
                extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS "+result.getThrowable()); //to add error/exception in extent report

                String screenshotPath = FreeCRMTest.getScreenshot(driver, result.getName());
                extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath)); //to add screenshot in extent report
                //extentTest.log(LogStatus.FAIL, extentTest.addScreencast(screenshotPath)); //to add screencast/video in extent report
            }
            else if(result.getStatus()==ITestResult.SKIP){
                extentTest.log(LogStatus.SKIP, "Test Case SKIPPED IS " + result.getName());
            }
            else if(result.getStatus()==ITestResult.SUCCESS){
                extentTest.log(LogStatus.PASS, "Test Case PASSED IS " + result.getName());

            }


            extent.endTest(extentTest); //ending test and ends the current test and prepare to create html report
            driver.quit();
        }













    }

}
