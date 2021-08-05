package login;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.LoginPage;
import pages.SignedInIMDB;
import utils.Utils;

import java.util.concurrent.TimeUnit;



public class LoginTest extends BaseTest {

    @Test
    public void testSuccessfulLogin() throws InterruptedException {
        LoginPage loginPage = homePage.clickSignInPage();
        loginPage.setSingIn();
        Utils.waitForXMillis(200);
        loginPage.setEmail(email);
        Utils.waitForXMillis(200);
        loginPage.setPassword(password);
        Utils.waitForXMillis(20);
        SignedInIMDB signedInIMDB = loginPage.clickLoginButton();
        Utils.scrollDown(getDriver());
        signedInIMDB.getloginCheck();
        Assertions.assertTrue(signedInIMDB.getloginCheck().contains("Mónika"), "You are not logged in!");
    }
}
