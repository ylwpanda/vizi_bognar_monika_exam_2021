package data;

import base.BaseTest;
import base.TestData;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import pages.DataListing;
import pages.LoginPage;
import pages.SignedInIMDB;
import utils.Utils;

import java.io.ByteArrayInputStream;

import static base.TestData.dataSearch;

public class DataListingTest extends BaseTest {

  private WebDriver driver;

  @Test
  @DisplayName("TC-IMDB_008")
  @Order(1)
  public void testDataListing() {
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
  @DisplayName("TC-IMDB_014")
  @Order(2)
  public void testWatchListing() {
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
    dataListing.getWatchlistNumberCheck();
    Assertions.assertTrue(dataListing.getWatchlistNumberCheck().contains("4 Titles"), TestData.LISTING_WORNG_TEXT);
  }

  @Test
  @DisplayName("TC-IMDB_015")
  @Order(3)
  public void testRemoveFromWatchListing() {
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
    dataListing.getWatchlistNumberCheck();
    Utils.refresh(getDriver());
    Assertions.assertTrue(dataListing.getWatchlistNumberCheck().contains("0 Titles"), TestData.LISTING_WORNG_TEXT);
  }

  @Step("TakeScreenshot")
  public void TakeScreenshot(){
    Allure.addAttachment("Screenshot", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    System.out.println(driver.getCurrentUrl());
  }
}
