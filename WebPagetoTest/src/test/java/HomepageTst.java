import homepage.Homepage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;


public class HomepageTst extends Homepage {

    @Test
    public void loginPageURLCheck(){
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id=\"app-mount\"]/div/div/div[1]/div[1]/header[2]/nav/div[2]/a")).click();
        String exptdURL="https://discord.com/login";
        String foundURL=driver.getCurrentUrl();
        Assert.assertEquals(exptdURL,foundURL);

    }
}
