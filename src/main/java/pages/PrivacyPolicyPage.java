package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class PrivacyPolicyPage {

    private WebDriver driver;
    private final By privacyPolicyLink = By.xpath("/html/body/div[2]/footer/div[2]/div[1]/div[3]/ul/li[5]/a");
    private final By privacyPolicyData = By.id("main");
    private String policyTxt;

    //constructor
    public PrivacyPolicyPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPolicyTxt() {
        policyTxt = driver.findElement(privacyPolicyData).getText();
        return policyTxt;
    }

    public void setPrivacyPolicyPage() {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(privacyPolicyLink).click();
    }


}
