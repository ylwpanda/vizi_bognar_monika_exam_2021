package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
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
    protected String password = "CodeCool2021";
    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }



    @BeforeEach
    public void setUp() { //setup chorme, incognito mode
        WebDriverManager.chromedriver().setup();
        //String chromeProfilePath = "/Users/YLWPanda/Library/Application Support/Google/Chrome/Profile 3/"; //Chrome Profile 3 settings
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--headless");
        //ChromeOptions chromeProfile = new ChromeOptions(); //Chrome Profile 3 settings
        //chromeProfile.addArguments("chrome.switches", "--disable-extensions"); //Chrome Profile 3 settings
        //chromeProfile.addArguments("user-data-dir=" + chromeProfilePath); //Chrome Profile 3 settings
        //options.addArguments("--disable-notifications"); //Chrome Profile 3 settings
        options.addArguments("--incognito");
        //driver = new ChromeDriver(chromeProfile); //Chrome Profile 3 settings
        driver = new ChromeDriver(options);
        driver.get("https://www.imdb.com/");
        driver.manage().window().maximize();
        //driver.manage().window().setSize(new Dimension(375, 812)); //iPhone X size screen
        //List<WebElement> links = driver.findElements(By.tagName("a"));
        //System.out.println(links.size()); //List elemements of webpage like "a" element.
        homePage = new HomePage(driver);
        System.out.println(driver.getTitle());

    }


    @AfterEach // closes all the browser windows opened by web driver
    public void tearDown() {
        driver.quit();
    }
}
