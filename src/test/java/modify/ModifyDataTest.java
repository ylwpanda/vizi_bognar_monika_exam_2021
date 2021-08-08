package modify;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.ModifyData;
import pages.SignedInIMDB;

public class ModifyDataTest extends BaseTest {

    protected ModifyData modifyData;
    protected String newUserID = "BestTesterEver";
    protected String bioText = "This is an automatic text!";
    protected String oldUserID = "Vizi-Bognar Monika Tester";

    @Test
    public void editProfileUserIDTest() {
        LoginPage loginPage = homePage.clickSignInPage();
        loginPage.setSingIn();
        loginPage.setEmail(email);
        loginPage.setPassword(password);
        SignedInIMDB signedInIMDB = loginPage.clickLoginButton();
        modifyData = new ModifyData(super.getDriver());
        modifyData.editProfileUserID(newUserID);
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
    }
}
