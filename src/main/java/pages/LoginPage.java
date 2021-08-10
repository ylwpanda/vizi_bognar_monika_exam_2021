package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;

public class LoginPage {

    private final WebDriver driver;
    //private final By SIGN_IN_WITH_IMDB = By.xpath("//*[@id=\"signin-options\"]/div/div[1]/a[1]"); //Sign in with IMDB data
    //private final By EMAIL_FIELD = By.id("ap_email"); //Sign in with IMDB data
    //private final By PASSWORD_FIELD = By.id("ap_password"); //Sign in with IMDB data
    //private final By LOGIN_BUTTON = By.id("signInSubmit"); //Sign in with IMDB data
    private final By SIGN_IN_WITH_GOOGLE = By.xpath("//*[@id=\"signin-options\"]/div/div[1]/a[4]/span[2]");
    private final By GOOGLE_EMAIL_FIELD = By.id("identifierId");
    private final By GOOGLE_NEXT_BUTTON = By.xpath("//*[@id=\"identifierNext\"]/div/button/span");
    private final By GOOGLE_PASSWORD_FIELD = By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input");
    private final By GOOGLE_NEXT_NEXT_BUTTON = By.xpath("//*[@id=\"passwordNext\"]/div/button/span");

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
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(GOOGLE_EMAIL_FIELD).sendKeys(email);
        driver.findElement(GOOGLE_NEXT_BUTTON).click();
    }

    //fill the password field with data
    public void setPassword(String password){
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.findElement(GOOGLE_PASSWORD_FIELD).sendKeys(password);
    }

    //click on next button at password page
    public SignedInIMDB clickLoginButton(){
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.findElement(GOOGLE_NEXT_NEXT_BUTTON).click();
        return new SignedInIMDB(driver);
    }
}
