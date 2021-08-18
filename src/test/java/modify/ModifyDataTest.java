package modify;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pages.LoginPage;
import pages.ModifyData;
import pages.SignedInIMDB;

import static base.TestData.*;

public class ModifyDataTest extends BaseTest {

    protected ModifyData modifyData;


    @Test
    @DisplayName("TC-IMDB_010")
    @Order(1)
    public void editProfileUserIDTest() {
        LoginPage loginPage = homePage.clickSignInPage();
        loginPage.setSingIn();
        loginPage.setEmail(email);
        loginPage.setPassword(password);
        SignedInIMDB signedInIMDB = loginPage.clickLoginButton();
        modifyData = new ModifyData(super.getDriver());
        modifyData.editProfileUserID(newUserID);
        Assertions.assertEquals(MODIFIED_ID, getDriver().findElement(By.xpath("//*[@id=\"main\"]/div/div/div/h2")).getText());
    }

    @Test
    @DisplayName("TC-IMDB_011")
    @Order(2)
    public void writeBackNameTest() {
        LoginPage loginPage = homePage.clickSignInPage();
        loginPage.setSingIn();
        loginPage.setEmail(email);
        loginPage.setPassword(password);
        SignedInIMDB signedInIMDB = loginPage.clickLoginButton();
        modifyData = new ModifyData(super.getDriver());
        modifyData.editProfileUserID(oldUserID);
        Assertions.assertEquals(EXIST_ID, getDriver().findElement(By.xpath("//*[@id=\"main\"]/div/div/div/h2")).getText());
    }

    @Test
    @DisplayName("TC-IMDB_012")
    @Order(3)
    public void editBioTest() {
        LoginPage loginPage = homePage.clickSignInPage();
        loginPage.setSingIn();
        loginPage.setEmail(email);
        loginPage.setPassword(password);
        SignedInIMDB signedInIMDB = loginPage.clickLoginButton();
        modifyData = new ModifyData(super.getDriver());
        modifyData.editBio(bioText);
    }

    @Test
    @DisplayName("TC-IMDB_013")
    @Order(4)
    public void deleteBioTest() {
        LoginPage loginPage = homePage.clickSignInPage();
        loginPage.setSingIn();
        loginPage.setEmail(email);
        loginPage.setPassword(password);
        SignedInIMDB signedInIMDB = loginPage.clickLoginButton();
        modifyData = new ModifyData(super.getDriver());
        modifyData.deleteBio();
    }
}
