package data;

import base.BaseTest;
import base.TestData;
import org.junit.jupiter.api.Test;
import pages.DataListing;
import pages.LoginPage;
import pages.SignedInIMDB;
import static base.TestData.dataSearch;

public class DataListingTest extends BaseTest {

  @Test
  public void testDataListing(){
    getDriver().get(TestData.URL);
    LoginPage loginPage = homePage.clickSignInPage();
    loginPage.setSingIn();
    loginPage.setEmail(email);
    loginPage.setPassword(password);
    SignedInIMDB signedInIMDB = loginPage.clickLoginButton();
    DataListing dataListing = homePage.clickDataListing();
    dataListing.setSearchField(dataSearch);
    dataListing.clickSearchButton();
  }

  @Test
  public void testWatchListing(){
    LoginPage loginPage = homePage.clickSignInPage();
    loginPage.setSingIn();
    loginPage.setEmail(email);
    loginPage.setPassword(password);
    SignedInIMDB signedInIMDB = loginPage.clickLoginButton();
    DataListing dataListing = homePage.clickDataListing();
    dataListing.setSearchField(dataSearch);
    dataListing.clickSearchButton();
    dataListing.clickFirstResult();
    dataListing.listWatchList();
  }



}
