package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogoutPage {

    private WebDriver driver;
    private final By profileButton = By.xpath("//*[@id=\"imdbHeader\"]/div[2]/div[5]/div/label[2]/div/svg");
    private final By logoutButton = By.xpath("//*[@id=\"navUserMenu-contents\"]/ul/a[7]/span");

    //constructor
    public LogoutPage(WebDriver driver){
        this.driver = driver;
    }

    //click on profile menu at homepage
    public void clickProfileButton() {
        driver.findElement(profileButton).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(profileButton));
    }

    //click on sign-out in profile menu
    public void clickLogoutButton() {
        driver.findElement(logoutButton).click();
    }
}

