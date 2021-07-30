package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class HomePage {

    private WebDriver driver;
    private By signInPage = By.xpath("//*[@id=\"imdbHeader\"]/div[2]/div[5]/a/div");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public LoginPage clickSignInPage() {
        driver.findElement(signInPage).click();
        return new LoginPage(driver);
    }
}
