package data;

import base.BaseTest;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.Test;
import pages.DataListing;
import pages.LoginPage;
import pages.SignedInIMDB;
import utils.FileUtils;

public class DataListingTest extends BaseTest {

  protected String dataSearch = "Wes Anderson";

  @Test
  public void testDataListing(){
    getDriver().get("https://www.imdb.com/");
    //LoginPage loginPage = homePage.clickSignInPage();
    //loginPage.setSingIn();
    //loginPage.setEmail(email);
    //loginPage.setPassword(password);
    //SignedInIMDB signedInIMDB = loginPage.clickLoginButton();
    DataListing dataListing = homePage.clickDataListing();
    dataListing.setSearchField(dataSearch);
    dataListing.clickSearchButton();
  }


}
