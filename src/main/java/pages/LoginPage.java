package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class LoginPage {

    private final WebDriver driver;
    private final By SIGN_IN_WITH_IMDB = By.xpath("//*[@id=\"signin-options\"]/div/div[1]/a[1]");
    private final By EMAIL_FIELD = By.id("ap_email");
    private final By PASSWORD_FIELD = By.id("ap_password");
    private final By LOGIN_BUTTON = By.id("signInSubmit");

    //constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // click on IMDB sign at sign-in/create new account page
    public void setSingIn(){
        driver.findElement(SIGN_IN_WITH_IMDB).click();
    }

    //fill the email field with data at sign-in page
    public void setEmail(String email){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(EMAIL_FIELD).sendKeys(email);
    }

    //fill the password field with data at sign-in page
    public void setPassword(String password){
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.findElement(PASSWORD_FIELD).sendKeys(password);
    }

    //click on login button at sing-in page
    public SignedInIMDB clickLoginButton(){
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.findElement(LOGIN_BUTTON).click();
        return new SignedInIMDB(driver);
    }
}
