package login;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.SignedInIMDB;
import utils.Utils;

public class LoginTest extends BaseTest {

    @Test
    public void testSuccessfulLogin() throws InterruptedException {
        LoginPage loginPage = homePage.clickSignInPage();
        loginPage.setSingIn();
        Utils.waitForXMillis(20);
        loginPage.setEmail(email);
        Utils.waitForXMillis(20);
        loginPage.setPassword(password);
        Utils.waitForXMillis(20);
        SignedInIMDB signedInIMDB = loginPage.clickLoginButton();
        Utils.scrollDown(getDriver());
        signedInIMDB.getLoginCheck();
        Assertions.assertTrue(signedInIMDB.getLoginCheck().contains("Mónika"), "You are not logged in!");
    }
}
