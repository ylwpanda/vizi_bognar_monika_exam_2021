package login;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SignedInIMDB;
import utils.Utils;

import static org.testng.Assert.*;

public class LoginTest extends BaseTest {

    @Test
    public void testSuccessfulLogin(){
        LoginPage loginPage = homePage.clickSignInPage();
        loginPage.setSingIn();
        loginPage.setEmail("monica.bognar@gmail.com");
        loginPage.setPassword("CodeCool2021");
        SignedInIMDB signedInIMDB = loginPage.clickLoginButton();
        Utils.scrollDown(getDriver());
        signedInIMDB.getloginCheck();
        assertTrue(signedInIMDB.getloginCheck().contains("Browse popular movies"), "You are not logged in!");
    }
}
