package logout;

import base.BaseTest;
import login.LoginTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.LogoutPage;
import pages.SignedInIMDB;
import utils.Utils;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class LogoutTest extends LoginTest {

    protected LogoutPage logoutPage;

    @Test
    public void testSuccessfulLogout() throws InterruptedException {
        LoginPage loginPage = homePage.clickSignInPage();
        loginPage.setSingIn();
        loginPage.setEmail(email);
        loginPage.setPassword(password);
        SignedInIMDB signedInIMDB = loginPage.clickLoginButton();
        Utils.waitForXMillis(30);

        logoutPage.clickProfileButton();
        logoutPage.clickLogoutButton();

        //Utils.scrollDown(getDriver());
        //signedInIMDB.getloginCheck();
        //assertTrue(signedInIMDB.getloginCheck().contains("Browse popular movies"), "You are not logged in!");
    }


}
