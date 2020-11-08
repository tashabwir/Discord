package Reporting;

import home.CommonAPI;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class test extends ExtntRprts{

    @Test
    public void titleTest(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\tasha\\IdeaProjects\\Discord\\Generic\\driver\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://freecrm.com/");

        String title = driver.getTitle();
        Assert.assertEquals(title,"#1 Free CRM customer relationship management software cloud");
    }
}
