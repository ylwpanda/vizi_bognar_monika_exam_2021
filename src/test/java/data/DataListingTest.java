package data;

import base.BaseTest;
import login.LoginTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.DataListing;
import pages.HomePage;
import pages.LoginPage;
import pages.SignedInIMDB;

public class DataListingTest extends BaseTest {

  protected String dataSearch = "Wes Anderson";

  @Test
  public void testDataListing(){
    LoginPage loginPage = homePage.clickSignInPage();
    loginPage.setSingIn();
    loginPage.setEmail(email);
    loginPage.setPassword(password);
    SignedInIMDB signedInIMDB = loginPage.clickLoginButton();
    DataListing dataListing = homePage.clickDataListing();
    dataListing.setSearchField(dataSearch);
    dataListing.clickSearchButton();
  }


}
