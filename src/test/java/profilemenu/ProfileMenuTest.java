package profilemenu;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.SignedInIMDB;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProfileMenuTest extends BaseTest {

    @Test
    public void testSelectMenuItem() {
        LoginPage loginPage = homePage.clickSignInPage();
        loginPage.setSingIn();
        loginPage.setEmail(email);
        loginPage.setPassword(password);
        SignedInIMDB signedInIMDB = loginPage.clickLoginButton();
        var ProfileMenu = homePage.clickProfileButton();

        String itemName = "Account settings";
        ProfileMenu.setSelectedItem(itemName);
        //assertEquals(selectedItems.size(), 5, "Incorrect number of selections!");
        //assertTrue(selectedItems.contains(itemName), "Option not selected!");
    }

}
