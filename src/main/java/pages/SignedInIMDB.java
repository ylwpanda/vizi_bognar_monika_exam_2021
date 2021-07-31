package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class SignedInIMDB {

    private WebDriver driver;
    private By loggedInChecker = By.xpath("//*[@id=\"__next\"]/main/div[2]/div[3]/div[3]/section[2]/div/div/div/section/a/div");

    public SignedInIMDB(WebDriver driver) {
        this.driver = driver;
    }

    public String getloginCheck() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return driver.findElement(loggedInChecker).getText();
    }
}