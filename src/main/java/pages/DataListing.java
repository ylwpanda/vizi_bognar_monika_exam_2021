package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DataListing {

    private WebDriver driver;
    private final By SEARCH_FIELD = By.xpath("/html/body/div[2]/nav/div[2]/div[1]/form/div[2]/div/input");
    private final By SEARCH_BUTTON = By.xpath("/html/body/div[2]/nav/div[2]/div[1]/form/button");
    //private final String URL = "https://www.imdb.com/?ref_=login";

    //constructor
    public DataListing(WebDriver driver){
        this.driver = driver;
    }

    //fill the search field at homepage
    public void setSearchField(String dataSearch){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(SEARCH_FIELD));
        driver.findElement(SEARCH_FIELD).sendKeys(dataSearch);
    }

    //click on the magnifying glass icon at homepage
    public SearchPage clickSearchButton(){
        driver.findElement(SEARCH_BUTTON).click();
        return new SearchPage(driver);
    }


}
