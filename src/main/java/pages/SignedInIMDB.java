package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class SignedInIMDB {

    private final WebDriver driver;
    private final By LOGGED_IN_CHECKER = By.xpath("//*[@id=\"imdbHeader\"]/div[2]/div[5]/div/label[2]/div");

    public SignedInIMDB(WebDriver driver) {
        this.driver = driver;
    }

    //logged in check method
    public String getLoginCheck() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return driver.findElement(LOGGED_IN_CHECKER).getText();
    }
}
