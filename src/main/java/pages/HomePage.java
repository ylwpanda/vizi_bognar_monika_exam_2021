package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


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

    public PrivacyPolicyPage privacyPolicyLink(){
        clickLink("driver.findElement(//*[@id=\"imdbHeader-navDrawerOpen--desktop\"]/div");
        return new PrivacyPolicyPage(driver);
    }

    public ProfileMenu clickProfileButton() {
        clickLink("//*[@id=\"imdbHeader\"]/div[2]/div[5]/div/label[2]/div/span");
        return new ProfileMenu(driver);
    }

    public SearchPage clickMenuButton(){
        clickLink("//*[@id=\"imdbHeader-navDrawerOpen--desktop\"]");
        return new SearchPage(driver);
    }

        //clickLink method
    private void clickLink(String linkText){
        driver.findElement(By.xpath(linkText)).click();
    }
}
