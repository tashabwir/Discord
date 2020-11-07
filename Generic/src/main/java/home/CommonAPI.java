package home;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.seleniumhq.jetty9.util.IO;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.internal.TestResult;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class CommonAPI {

    public static WebDriver driver;
    IO FileUtils;

    TestResult currentTst = new TestResult();
    String tstname = currentTst.getMethod().getMethodName();
    int tstStatus = currentTst.getStatus();

    @Parameters({"url"})
    @BeforeMethod
    public void setUp(String url) {
        System.setProperty("webdriver.chrome.driver", "D:\\IdeaProjects\\PracticeSelenium20\\Generic\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(url);//https://disboard.org/
        driver.manage().window().maximize();
        //System.out.println("test message" + driver.getCurrentUrl());
    }

    @AfterMethod
    public void closeUp(ITestResult result) {
        //IF test fails then take screenshot
        if (ITestResult.FAILURE == tstStatus) {
            captureScreenshot(driver, tstname);
        }
        driver.close();
    }

    public static String getDateAndTime(){
    //  getting current date and time info
        DateFormat df = new SimpleDateFormat("(MM.dd.yyyy-HH:mma)");
        Date date = new Date();
        return df.format(date);
    }

    // MAFI Screenshot
    public void captureScreenshot(WebDriver driver, String screenshotName) {
        String destination = System.getProperty("user.dir") + "/screenshots/" + screenshotName + " " + getDateAndTime() + ".png";

    //  getting current date and time info
        DateFormat df = new SimpleDateFormat("(MM.dd.yyyy-HH:mma)");
        Date date = new Date();
        df.format(date);

    //  TakesScreenshot source = ((TakesScreenshot) driver); -----------> Convert web driver object to TakeScreenshot
    //  source.getScreenshotAs(OutputType.FILE); -----------> Call getScreenshotAs method to create image file
        File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE); //shorteer version for above two lines

        try {   //Move image file to new destination
            FileUtils.copyFile(source, new File(destination));
            System.out.println("Screenshot captured");
        } catch (Exception e) {
            System.out.println("Exception while taking screenshot " + e.getMessage());
        }
    }

    public void ExtentRep(){
        String path = System.getProperty("user.dir") + "/ExtentReports/"+ getDateAndTime();

        ExtentReports reports = new ExtentReports(path,false);
        ExtentTest test = reports.startTest(tstname + " report");

    //  log (close report)

    //  Flush method is used to erase any previous data on the report and create a new report
        reports.flush();
    }

}

