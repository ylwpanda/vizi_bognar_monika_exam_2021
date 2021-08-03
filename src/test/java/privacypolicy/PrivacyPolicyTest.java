package privacypolicy;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pages.PrivacyPolicyPage;
import utils.FileUtils;

public class PrivacyPolicyTest extends BaseTest {

    protected PrivacyPolicyPage privacyPolicyPage;
    FileUtils fileutils = new FileUtils();



    @Test
    public void saveToFileTest(){
        privacyPolicyPage = new PrivacyPolicyPage(super.getDriver());
        getDriver().get("https://www.imdb.com/");
        privacyPolicyPage.setPrivacyPolicyPage();

        fileutils.saveToFile("Privacypolicy.txt", privacyPolicyPage.getPolicyTxt());
        Assertions.assertEquals("What About Advertising?", getDriver().findElement(By.xpath("//*[@id=\"whataboutadvertising\"]/h2")).getText());

    }
    }
