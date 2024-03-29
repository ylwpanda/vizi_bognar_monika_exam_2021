package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class LoginPage {

    private final WebDriver driver;
    //private final By SIGN_IN_WITH_IMDB = By.xpath("//*[@id=\"signin-options\"]/div/div[1]/a[1]"); //Sign in with IMDB data
    //private final By IMDB_EMAIL_FIELD = By.id("ap_email"); //Sign in with IMDB data
    //private final By IMDB_PASSWORD_FIELD = By.id("ap_password"); //Sign in with IMDB data
    //private final By IMDB_LOGIN_BUTTON = By.id("signInSubmit"); //Sign in with IMDB data
    private final By SIGN_IN_WITH_GOOGLE = By.xpath("//*[@id='signin-options']//div//a[4]");
    private final By GOOGLE_EMAIL_FIELD = By.xpath("//*[@id='identifierId']");
    private final By GOOGLE_NEXT_BUTTON = By.xpath("//*[@class='VfPpkd-LgbsSe VfPpkd-LgbsSe-OWXEXe-k8QpJ VfPpkd-LgbsSe-OWXEXe-dgl2Hf nCP5yc AjY5Oe DuMIQc qIypjc TrZEUc lw1w4b']");
    private final By GOOGLE_PASSWORD_FIELD = By.xpath("//input[@type='password']");
    private final By GOOGLE_NEXT_NEXT_BUTTON = By.xpath("//*[@class='FliLIb DL0QTb']");

    //constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // click on IMDB sign at sign-in/create new account page
    public void setSingIn(){
        driver.findElement(SIGN_IN_WITH_GOOGLE).click();
    }

    //fill the email field with data and click to the next button
    public void setEmail(String email){
        //WebDriverWait wait = new WebDriverWait(driver, 20);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(GOOGLE_EMAIL_FIELD));
        driver.findElement(GOOGLE_EMAIL_FIELD).sendKeys(email);
        driver.findElement(GOOGLE_NEXT_BUTTON).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }

    //fill the password field with data
    public void setPassword(String password){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(GOOGLE_PASSWORD_FIELD));
        driver.findElement(GOOGLE_PASSWORD_FIELD).sendKeys(password);
    }

    //click on next button at password page
    public SignedInIMDB clickLoginButton(){
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.findElement(GOOGLE_NEXT_NEXT_BUTTON).click();
        return new SignedInIMDB(driver);
    }
}
