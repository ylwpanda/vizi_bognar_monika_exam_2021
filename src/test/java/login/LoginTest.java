package login;

import base.BaseTest;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.LoginPage;
import pages.SignedInIMDB;
import utils.Utils;

import java.io.ByteArrayInputStream;

public class LoginTest extends BaseTest {

    @Test
    @DisplayName("TC-IMDB_003")
    public void testSuccessfulLogin() throws InterruptedException {
        TakeScreenshot();
        LoginPage loginPage = homePage.clickSignInPage();
        TakeScreenshot();
        loginPage.setSingIn();
        TakeScreenshot();
        loginPage.setEmail(email);
        TakeScreenshot();
        loginPage.setPassword(password);
        TakeScreenshot();
        SignedInIMDB signedInIMDB = loginPage.clickLoginButton();
        TakeScreenshot();
        signedInIMDB.getLoginCheck();
        TakeScreenshot();
        Assertions.assertTrue(signedInIMDB.getLoginCheck().contains("Mónika"), "You are not logged in!");
        TakeScreenshot();
    }

    @Step("TakeScreenshot")
    public void TakeScreenshot(){
        Allure.addAttachment("Screenshot", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        System.out.println(driver.getCurrentUrl());
    }
}
