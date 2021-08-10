package modify;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pages.LoginPage;
import pages.ModifyData;
import pages.SignedInIMDB;

import static base.TestData.*;

public class ModifyDataTest extends BaseTest {

    protected ModifyData modifyData;


    @Test
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
    public void deleteBioTest() {
        LoginPage loginPage = homePage.clickSignInPage();
        loginPage.setSingIn();
        loginPage.setEmail(email);
        loginPage.setPassword(password);
        SignedInIMDB signedInIMDB = loginPage.clickLoginButton();
        modifyData = new ModifyData(super.getDriver());
        modifyData.deleteBio();
    }

    @Test
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
}
