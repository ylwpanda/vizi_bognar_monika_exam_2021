package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ModifyData {

    private WebDriver driver;
    private final By ACCOUNT_SETTINGS_LINK = By.xpath("//*[@id=\"navUserMenu-contents\"]/ul/a[6]");
    private final By EDIT_PROFILE_LINK = By.xpath("//*[@id=\"main\"]/div/div[1]/ul/li[1]/a");
    private final By EDIT_USER_ID_BUTTON = By.xpath("//*[@id=\"main\"]/div/div[1]/div[2]/a");
    private final By WRITE_TO_USER_ID_FIELD = By.xpath("//*[@id=\"main\"]/div/form/div/input[2]");
    private final By SAVE_MODIFIED_USER_ID_BUTTON = By.xpath("//*[@id=\"main\"]/div/form/p[2]/input");
    //private final By BACK_TO_ACCOUNT_SETTINGS = By.xpath("//*[@id=\"sidebar\"]/div[1]/p[4]/a");
    private final By WRITE_TO_BIO = By.xpath("//*[@id=\"main\"]/div/div[2]/div[2]/textarea");
    private final By SAVE_DESCRIPTION_BUTTON = By.xpath("//*[@id=\"main\"]/div/div[2]/div[2]/div/div[1]");

    public ModifyData(WebDriver driver) {
        this.driver = driver;
    }

    //change userID
    public void editProfileUserID(String newUserID){
        HomePage homePage = new HomePage(driver);
        homePage.clickProfileButton();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(ACCOUNT_SETTINGS_LINK));
        driver.findElement(ACCOUNT_SETTINGS_LINK).click();
        wait.until(ExpectedConditions.elementToBeClickable(EDIT_PROFILE_LINK));
        driver.findElement(EDIT_PROFILE_LINK).click();
        wait.until(ExpectedConditions.elementToBeClickable(EDIT_USER_ID_BUTTON));
        driver.findElement(EDIT_USER_ID_BUTTON).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(WRITE_TO_USER_ID_FIELD));
        driver.findElement(WRITE_TO_USER_ID_FIELD).clear();
        driver.findElement(WRITE_TO_USER_ID_FIELD).sendKeys(newUserID);
        driver.findElement(SAVE_MODIFIED_USER_ID_BUTTON).click(); //You have successfully changed your User ID assert
    }

    //Write on BIO
    public void editBio(String bioText){
        HomePage homePage = new HomePage(driver);
        homePage.clickProfileButton();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(ACCOUNT_SETTINGS_LINK));
        driver.findElement(ACCOUNT_SETTINGS_LINK).click();
        wait.until(ExpectedConditions.elementToBeClickable(EDIT_PROFILE_LINK));
        driver.findElement(EDIT_PROFILE_LINK).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(WRITE_TO_BIO));
        driver.findElement(WRITE_TO_BIO).sendKeys(bioText);
        driver.findElement(SAVE_DESCRIPTION_BUTTON).click();
    }

    //delete data from BIO
    public void deleteBio() {
        HomePage homePage = new HomePage(driver);
        homePage.clickProfileButton();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(ACCOUNT_SETTINGS_LINK));
        driver.findElement(ACCOUNT_SETTINGS_LINK).click();
        wait.until(ExpectedConditions.elementToBeClickable(EDIT_PROFILE_LINK));
        driver.findElement(EDIT_PROFILE_LINK).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(WRITE_TO_BIO));
        driver.findElement(WRITE_TO_BIO).clear();
        driver.findElement(SAVE_DESCRIPTION_BUTTON).click();
    }
}
