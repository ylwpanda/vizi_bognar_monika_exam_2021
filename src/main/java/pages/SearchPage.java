package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class SearchPage {

    private WebDriver driver;
    private final String TOP_RATED_MOVIES_URL = "https://www.imdb.com/chart/top/?ref_=nv_mv_250";
    //private final By TOP_RATED_LINK = By.xpath("//*[@id=\"imdbHeader\"]/div[2]/aside/div/div[2]/div/div[1]/span/div/div/ul/a[4]");
    private final By DRAMA_LINK = By.xpath("//*[contains(text(),'Drama')]");
    private final By NEXT_LIST_BUTTON = By.xpath("//*[@id=\"main\"]/div/div[4]/a");
    private final By SEC_NEXT_LIST_BUTTON = By.xpath("//*[@id=\"main\"]/div/div[1]/div[2]/a[2]");
    private final By FIRST_MOVIE_TITLE = By.xpath("//*[@id=\"main\"]/div/div[3]/div/div[1]/div[3]/h3/a");

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void findDramaLink() {
        driver.get(TOP_RATED_MOVIES_URL);
        //HomePage homePage = new HomePage(driver);
        //homePage.clickMenuButton();
        //driver.findElement(TOP_RATED_LINK).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(DRAMA_LINK));
        driver.findElement(DRAMA_LINK).click();
    }

    //click on ell the page that exist
    public void listAllTheResults() throws IOException {
        FileWriter file = new FileWriter("top_rated_movies.txt", true);
        driver.findElement(NEXT_LIST_BUTTON).click();
        int lap = 1;
        while (driver.findElement(SEC_NEXT_LIST_BUTTON).isDisplayed() && lap<=56) {
            lap++;
            List<WebElement> dramaMovies = driver.findElements(FIRST_MOVIE_TITLE);
            for (WebElement dramaMovie : dramaMovies) {
                System.out.println(dramaMovie.getText());
                String movieTitle = dramaMovie.getText();
                file.write(movieTitle + "\n");
            }
            driver.findElement(SEC_NEXT_LIST_BUTTON).click();
        }
        file.close();
    }
}