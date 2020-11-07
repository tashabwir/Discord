package home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CommonAPI_Template {

    public static void main(String[] args) {

        // declaration and instantiation of objects/variables
        System.setProperty("webdriver.chrome.driver", "D:\\IdeaProjects\\PracticeSelenium20\\Generic\\driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //data
        String baseUrl = "https://www.seleniumeasy.com/test/basic-first-form-demo.html";
        String expectedTitle = "Selenium Easy Demo - Simple Form to Automate using Selenium";

        // get the actual value of the title
        String actualTitle = driver.findElement(By.xpath("/html/head/title")).getText();

        // launch browser and direct it to the Base URL
        driver.get(baseUrl);

        //compare the actual title of the page with the expected one and print the result as "Passed" or "Failed"
        if (driver.findElement(By.xpath("/html/head/title")).getText().matches(expectedTitle)) {
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed");
        }

        //compare with assert
        Assert.assertEquals(expectedTitle, driver.findElement(By.xpath("/html/head/title")).getText().matches(expectedTitle));

        driver.close();

    }

}


