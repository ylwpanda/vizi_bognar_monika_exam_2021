package search;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import pages.SearchPage;

import static base.TestData.URL;

public class searchTest extends BaseTest {

    protected SearchPage searchPage;


    @Test
    public void morePagesListsTest() {
        getDriver().get(URL);
        searchPage = new SearchPage(super.getDriver());
        searchPage.findDramaLink();
        searchPage.listAllTheResults();
        //searchResultPage.clickOnFirst500Button();
        //searchResultPage.clickOnNext500Button();
        //searchResultPage.morePagesLists();
    }

}
