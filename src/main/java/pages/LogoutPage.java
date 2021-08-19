package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogoutPage {

    private final WebDriver driver;
    private final By PROFILE_BUTTON = By.xpath("//*[@class='_3x17Igk9XRXcaKrcG3_MXQ navbar__user UserMenu-sc-1poz515-0 lkfvZn']");
    private final By LOGOUT_BUTTON = By.xpath("//*[@id='navUserMenu-contents']//a[7]");
    //private final By LOGOUT_CHECK_LINK = By.xpath("//*[@id=\"imdbHeader\"]/div[2]/div[5]/div/label[2]/div/span");

    //constructor
    public LogoutPage(WebDriver driver){
        this.driver = driver;
    }

    //click on profile menu at homepage
    public void clickProfileButton() {
        driver.findElement(PROFILE_BUTTON).click();
        //WebDriverWait wait = new WebDriverWait(driver, 10);
        //wait.until(ExpectedConditions.presenceOfElementLocated(PROFILE_BUTTON));
    }

    //click on sign-out in profile menu
    public void clickLogoutButton() {
        //WebDriverWait wait = new WebDriverWait(driver, 10);
        //wait.until(ExpectedConditions.elementToBeClickable(LOGOUT_BUTTON));
        driver.findElement(LOGOUT_BUTTON).click();
    }
}