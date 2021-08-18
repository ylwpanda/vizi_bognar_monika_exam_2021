package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DataListing {

    private WebDriver driver;
    private final By SEARCH_FIELD = By.xpath("/html/body/div[2]/nav/div[2]/div[1]/form/div[2]/div/input");
    private final By SEARCH_BUTTON = By.xpath("/html/body/div[2]/nav/div[2]/div[1]/form/button");
    private final By FIRST_RESULT = By.xpath("//*[@id=\"main\"]/div/div[2]/table/tbody/tr[1]/td[2]/a");
    private final By WATCHLIST_BUTTON1 = By.xpath("//*[@id=\"knownfor\"]/div[1]/div[1]/div");
    private final By WATCHLIST_BUTTON2 = By.xpath("//*[@id=\"knownfor\"]/div[2]/div[1]/div");
    private final By WATCHLIST_BUTTON3 = By.xpath("//*[@id=\"knownfor\"]/div[3]/div[1]/div");
    private final By WATCHLIST_BUTTON4 = By.xpath("//*[@id=\"knownfor\"]/div[4]/div[1]/div");
    private final By WATCHLIST_LIST = By.xpath("//*[@id=\"imdbHeader\"]/div[2]/div[4]/a/div");
    private final By NUMBER_OF_WATCHLIST = By.xpath("//*[@id=\"center-1-react\"]/div/div[2]/div[1]/div[2]/div");

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
    //List/unlist movies to watchlist
    public void listWatchList(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(WATCHLIST_BUTTON1));
        driver.findElement(WATCHLIST_BUTTON1).click();
        driver.findElement(WATCHLIST_BUTTON2).click();
        driver.findElement(WATCHLIST_BUTTON3).click();
        driver.findElement(WATCHLIST_BUTTON4).click();
        driver.findElement(WATCHLIST_LIST).click();
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
    public String getWatchlistNumberCheck() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return driver.findElement(NUMBER_OF_WATCHLIST).getText();
    }

}
