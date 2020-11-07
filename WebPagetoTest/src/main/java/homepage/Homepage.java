package homepage;

import home.CommonAPI;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Homepage extends CommonAPI {

    String myusername = "sharshir20@gmail.com";
    String mypassword = "testdiscpass";

    @Test
    public void loginPageURLCheck(){
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id=\"app-mount\"]/div/div/div[1]/div[1]/header[2]/nav/div[2]/a")).click();
        String exptdURL="https://discord.com/loginn";
        String foundURL=driver.getCurrentUrl();
        Assert.assertEquals(exptdURL,foundURL);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test(enabled = false)
    public void discordOnBrowserButton(){
        driver.findElement(By.xpath("//*[@id=\"app-mount\"]/div/div/div[1]/div[2]/div/div[2]/button")).click();
        driver.findElement(By.xpath("//*[@id=\"app-mount\"]/div/div/div[1]/div[2]/div/div[2]/form/input")).click();
        driver.findElement(By.xpath("//*[@id=\"app-mount\"]/div/div/div[1]/div[2]/div/div[2]/form/input")).sendKeys("webpagedisctest");
        //driver.findElement(By.xpath("//*[@id=\"app-mount\"]/div/div/div[1]/div[2]/div/div[2]/form/button")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test(enabled = false)
    public void loginPageLogin(){
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id=\"app-mount\"]/div/div/div[1]/div[1]/header[2]/nav/div[2]/a")).click();
        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).sendKeys(myusername);
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).sendKeys(mypassword);
        driver.findElement(By.xpath("//*[@id=\"app-mount\"]/div[2]/div/div[2]/div/div/form/div/div/div[1]/div[3]/button[2]")).click();
    }
}
