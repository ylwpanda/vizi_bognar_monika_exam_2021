package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DataListing {

    private WebDriver driver;
    private final By SEARCH_FIELD = By.xpath("/html/body/div[2]/nav/div[2]/div[1]/form/div[2]/div/input");
    private final By SEARCH_BUTTON = By.xpath("/html/body/div[2]/nav/div[2]/div[1]/form/button");
    private final By FIRST_RESULT = By.xpath("//*[@id=\"main\"]/div/div[2]/table/tbody/tr[1]/td[2]/a");
    private final By WATCHLIST_BUTTONS = By.className("uc-add-wl-pending-container");

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

    public String listWatchList(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        String watchListElements = driver.findElement(WATCHLIST_BUTTONS).getText();
        System.out.println(watchListElements);
        return watchListElements;
    }

    //click on the magnifying glass icon at homepage
    public SearchPage clickSearchButton(){
        driver.findElement(SEARCH_BUTTON).click();
        return new SearchPage(driver);
    }
    public SearchPage clickFirstResult() {
        driver.findElement(FIRST_RESULT).click();
        return new SearchPage(driver);
    }

}
