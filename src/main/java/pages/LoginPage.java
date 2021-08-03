package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class LoginPage {

    private final WebDriver driver;
    private final By signInWithIMDB = By.xpath("//*[@id=\"signin-options\"]/div/div[1]/a[1]");
    private final By emailField = By.id("ap_email");
    private final By passwordField = By.id("ap_password");
    private final By loginButton = By.id("signInSubmit");

    //constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // click on IMDB sign at sign-in/create new account page
    public void setSingIn(){
        driver.findElement(signInWithIMDB).click();
    }

    //fill the email field with data at sign-in page
    public void setEmail(String email){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(emailField).sendKeys(email);
    }

    //fill the password field with data at sign-in page
    public void setPassword(String password){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(passwordField).sendKeys(password);
    }

    //click on login button at sing-in page
    public SignedInIMDB clickLoginButton(){
        driver.findElement(loginButton).click();
        return new SignedInIMDB(driver);
    }
}
