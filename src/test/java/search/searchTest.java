package search;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import pages.SearchPage;

import java.io.IOException;

import static base.TestData.URL;

public class searchTest extends BaseTest {

    protected SearchPage searchPage;


    @Test
    public void morePagesListsTest() throws IOException {
        getDriver().get(URL);
        searchPage = new SearchPage(super.getDriver());
        searchPage.findDramaLink();
        searchPage.listAllTheResults();
    }

}
