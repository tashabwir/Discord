import home.CommonAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DsbrdHome extends CommonAPI{

    @FindBy(id="searchform-keyword")
    public WebElement firstSearchBar;

    @FindBy(xpath ="//*[@id=\"w0\"]/button")
    public WebElement searchBtn;

    By searchbar = By.id("searchform-keyword");



}
