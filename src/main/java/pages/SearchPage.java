package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchPage {

    private WebDriver driver;
    private final By TOP_RATED_LINK = By.xpath("//*[@id=\"imdbHeader\"]/div[2]/aside/div/div[2]/div/div[1]/span/div/div/ul/a[3]");
    private final By DRAMA_LINK = By.xpath("//*[@id=\"sidebar\"]/div[7]/span/ul/li[7]/a");
    private final By NEXT_LIST_BUTTON = By.xpath("//*[@id=\"main\"]/div/div[4]/a");
    private final By SEC_NEXT_LIST_BUTTON = By.xpath("//*[@id=\"main\"]/div/div[4]/a[2]");
    private final By PAGE_LISTS = By.xpath("//*[@id=\"main\"]");
    private final By PAGE_LISTS_LINK = By.xpath("//*[@id=\"main\"]/div/div[3]/div/div");

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

        public void findDramaLink() {
            HomePage homePage = new HomePage(driver);
            homePage.clickMenuButton();
            driver.findElement(TOP_RATED_LINK).click();
            driver.findElement(DRAMA_LINK).click();
            driver.findElement(NEXT_LIST_BUTTON).click();
        }

        //click on ell the page that exist
        public void listAllTheResults() {
            List<WebElement> links;
            WebDriverWait wait = new WebDriverWait(driver, 5);
            int list = 0;
            while (driver.findElement(SEC_NEXT_LIST_BUTTON).isDisplayed() && list <= 99) {
                list++;
                links = driver.findElements(PAGE_LISTS);
                for (int allList = 0; allList < links.size(); allList++) {

                    WebElement link = links.get(allList).findElement(PAGE_LISTS_LINK);
                    System.out.println(link.getText());
                }
                try {

                    wait.until(ExpectedConditions.visibilityOfElementLocated(SEC_NEXT_LIST_BUTTON));

                    driver.findElement(SEC_NEXT_LIST_BUTTON).click();
                } catch (StaleElementReferenceException e) {
                    e.printStackTrace();

                }

            }
        }
    }