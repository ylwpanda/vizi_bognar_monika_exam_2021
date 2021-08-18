package privacypolicy;

import base.BaseTest;
import base.TestData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pages.PrivacyPolicyPage;
import utils.FileUtils;

import static base.TestData.URL;

public class PrivacyPolicyTest extends BaseTest {

    protected PrivacyPolicyPage privacyPolicyPage;
    FileUtils fileutils = new FileUtils();

    @Test
    @DisplayName("TC-IMDB_007")
    public void saveToFileTest(){
        privacyPolicyPage = new PrivacyPolicyPage(super.getDriver());
        getDriver().get(URL);
        homePage.privacyPolicyLink();

        fileutils.saveToFile("Privacypolicy.txt", privacyPolicyPage.getPolicyTxt());
        Assertions.assertEquals(TestData.PRIVACY_POLICY_TEXT, getDriver().findElement(By.xpath("//*[@id=\"whataboutadvertising\"]/h2")).getText());
    }
}
