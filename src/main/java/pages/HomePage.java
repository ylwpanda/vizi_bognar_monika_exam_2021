package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class HomePage {

    private WebDriver driver;

    //constructor
    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    //click on sing-in icon at homepage
    public LoginPage clickSignInPage() {
        clickLink("//*[@id=\"imdbHeader\"]/div[2]/div[5]/a/div");
        return new LoginPage(driver);
    }

    //click on the magnifying glass icon at homepage
    public DataListing clickDataListing(){
        clickLink("/html/body/div[2]/nav/div[2]/div[1]/form/button");
        return new DataListing(driver);
    }

    //clickLink method
    private void clickLink(String linkText){
        driver.findElement(By.xpath(linkText)).click();
    }
}
