package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.junit.jupiter.api.BeforeEach;
import pages.HomePage;
import utils.FileUtils;

public class BaseTest {

    FileUtils utils = new FileUtils();
    public String[] userData = utils.readUserDatas();
    protected HomePage homePage;
    protected String email = userData[0];
    protected String password = userData[1];
    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }



    @BeforeEach
    public void setUp() { //setup chorme, incognito mode
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        //options.addArguments("--incognito");
        driver = new ChromeDriver(options);
        driver.get("https://www.imdb.com/");
        driver.manage().window().maximize();


        //driver.manage().window().setSize(new Dimension(375, 812)); //iPhone X size screen
        //List<WebElement> links = driver.findElements(By.tagName("a"));
        //System.out.println(links.size()); //List elemements of webpage like "a" element.

        homePage = new HomePage(driver);
        //options.addArguments("start-maximized");
        //options.addArguments("disable-infobars");
        //options.addArguments("--disable-extensions");
        //driver.get("https://rsps100.com/vote/760");
        //new WebDriverWait(driver, 10).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[starts-with(@name, 'a-') and starts-with(@src, 'https://www.google.com/recaptcha')]")));
        //new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.recaptcha-checkbox-checkmark"))).click();

        System.out.println(driver.getTitle());

    }


    /*@AfterClass // closes all the browser windows opened by web driver
    public void tearDown() {
        driver.quit();
    }*/
}
