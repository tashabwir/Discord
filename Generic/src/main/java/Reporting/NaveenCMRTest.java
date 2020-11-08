package Reporting;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.seleniumhq.jetty9.util.IO;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NaveenCMRTest {

    public WebDriver driver1;
    public ExtentReports extent;
    public ExtentTest ExtentTestlogger;
    private IO FileUtils;

    @BeforeTest
    public void setExtent(){
        extent = new ExtentReports(System.getProperty("user.dir")+"\\Extent-Reports\\ExtentReportResults.html", true);
        extent.addSystemInfo("Tester", "NEL");
    }
    @AfterTest
    public void endReport(){
        extent.flush();
        //extent.close();
    }

    public String screenshot(WebDriver drvr, String ScreenshotName) throws IOException {
        String df = new SimpleDateFormat("(MM.dd.yyyy-HH:mma)").format(new Date());
        File source = ((TakesScreenshot) drvr).getScreenshotAs(OutputType.FILE); //shorteer version for above two lines
        String destination = System.getProperty("user.dir") + "/screenshots/" + df + ".png";
        FileUtils.copyFile(source, new File(destination));
        return destination;
    }

// driver
    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\tasha\\IdeaProjects\\Discord\\Generic\\driver\\chromedriver.exe");
        driver1 = new ChromeDriver();
        driver1.get("https://freecrm.com/");//https://disboard.org/
        driver1.manage().window().maximize();
        //System.out.println("test message" + driver.getCurrentUrl());
    }

    @Test
    public void titleTest(){
        ExtentTestlogger = extent.startTest("test");
        String title = driver1.getTitle();
        System.out.println(title);
        Assert.assertEquals(title,"#1 Free CRM customer relationship management software cloud");
    }

    @AfterMethod
    public void closeUp(ITestResult result) throws IOException {

        //if (ITestResult.FAILURE == result.getStatus()) {
            //ExtentTestlogger.log(LogStatus.FAIL, result.getMethod().getMethodName()+"has failed");
            //ExtentTestlogger.log(LogStatus.FAIL, result.getThrowable());
            ExtentTestlogger.log(LogStatus.PASS, result.getMethod().getMethodName()+"has passed");
            String screenshotpath = screenshot(driver1,result.getName());
            //screenshot(driver1, result.getMethod().getMethodName());
            ExtentTestlogger.log(LogStatus.FAIL, ExtentTestlogger.addScreenCapture(screenshotpath));//to add screenshot in extent report
        //}
        extent.endTest(ExtentTestlogger);
        driver1.close();
    }

}
