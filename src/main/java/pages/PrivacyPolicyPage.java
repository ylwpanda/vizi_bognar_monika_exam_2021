package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PrivacyPolicyPage {

    private WebDriver driver;
    private final By PRIVACY_POLICY_DATA = By.id("pagecontent");
    private String policyTxt;

    //constructor
    public PrivacyPolicyPage(WebDriver driver) {
        this.driver = driver;
    }

    //get text from the page and save to PrivacyPolicy.txt
    public String getPolicyTxt() {
        policyTxt = driver.findElement(PRIVACY_POLICY_DATA).getText();
        return policyTxt;
    }
}
