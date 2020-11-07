import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DsbrdHomeTest extends DsbrdHome{

    @Test
    public void multiSearch(){
        DsbrdHome home = PageFactory.initElements(driver, DsbrdHome.class);
        home.firstSearchBar.click();
        home.firstSearchBar.sendKeys("java");
        home.searchBtn.click();
        home.firstSearchBar.click();
        //home.firstSearchBar.sendKeys(Keys.CONTROL+Keys.CLEAR);
        home.firstSearchBar.sendKeys("python");
        home.searchBtn.click();
    }

    @Test
    public void manySearch(){
        driver.findElement(By.xpath("//*[@id=\"searchform-keyword\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"searchform-keyword\"]")).sendKeys("java"+ Keys.ENTER);
        driver.findElement(By.xpath("//*[@id=\"searchform-keyword\"]")).clear();
        driver.findElement(By.xpath("//*[@id=\"searchform-keyword\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"searchform-keyword\"]")).sendKeys("sql"+ Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
}
