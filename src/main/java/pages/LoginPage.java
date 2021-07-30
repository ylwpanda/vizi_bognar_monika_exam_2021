package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;
    private By signInWithIMDB = By.xpath("//*[@id=\"signin-options\"]/div/div[1]/a[1]");
    private By emailField = By.id("ap_email");
    private By passwordField = By.id("ap_password");
    private By loginButton = By.id("signInSubmit");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    public void setSingIn(){
        driver.findElement(signInWithIMDB).click();
    }
    public void setEmail(String email){
        driver.findElement(emailField).sendKeys(email);
    }

    public void setPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }

    public SignedInIMDB clickLoginButton(){
        driver.findElement(loginButton).click();
        return new SignedInIMDB(driver);
    }
}
