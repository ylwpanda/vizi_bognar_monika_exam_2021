package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage {

    private WebDriver driver;
    private final By WatchListButtonOne = By.xpath("//*[@id=\"knownfor\"]/div[1]/div[1]/div/div");
    private final By WatchListButtonTwo = By.xpath("//*[@id=\"knownfor\"]/div[2]/div[1]/div/div");
    private final By WatchListButtonThree = By.xpath("//*[@id=\"knownfor\"]/div[3]/div[1]/div/div");
    private final By WatchListButtonFour = By.xpath("//*[@id=\"knownfor\"]/div[4]/div[1]/div/div");

    public SearchPage(WebDriver driver){
        this.driver = driver;
    }

    //click on plus icon (add watchlist) at searchpage
    public void setWatchListButton() {
        driver.findElement(WatchListButtonOne).click();
        driver.findElement(WatchListButtonTwo).click();
        driver.findElement(WatchListButtonThree).click();
        driver.findElement(WatchListButtonFour).click();
    }
}
