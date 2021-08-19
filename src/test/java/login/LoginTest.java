package login;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.SignedInIMDB;
import utils.Utils;

public class LoginTest extends BaseTest {

    @Test
    @DisplayName("TC-IMDB_003")
    public void testSuccessfulLogin() throws InterruptedException {
        LoginPage loginPage = homePage.clickSignInPage();
        loginPage.setSingIn();
        loginPage.setEmail(email);
        loginPage.setPassword(password);
        SignedInIMDB signedInIMDB = loginPage.clickLoginButton();
        signedInIMDB.getLoginCheck();
        Assertions.assertTrue(signedInIMDB.getLoginCheck().contains("Mónika"), "You are not logged in!");
    }
}
