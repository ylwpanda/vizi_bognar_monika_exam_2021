package logout;

import base.BaseTest;
import base.TestData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pages.LoginPage;
import pages.LogoutPage;
import pages.SignedInIMDB;

public class LogoutTest extends BaseTest {

    @Test
    @DisplayName("TC-IMDB_006")
    public void testSuccessfulLogout(){
        LoginPage loginPage = homePage.clickSignInPage();
        loginPage.setSingIn();
        loginPage.setEmail(email);
        loginPage.setPassword(password);
        SignedInIMDB signedInIMDB = loginPage.clickLoginButton();
        LogoutPage logoutPage = new LogoutPage(super.getDriver());
        logoutPage.clickProfileButton();
        logoutPage.clickLogoutButton();
        Assertions.assertEquals(TestData.LOGOUT_CHECK, getDriver().findElement(By.xpath("//*[@id=\"imdbHeader\"]/div[2]/div[5]/a/div")).getText());
    }
}
