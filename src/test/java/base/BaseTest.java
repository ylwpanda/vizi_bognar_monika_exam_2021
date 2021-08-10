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
    public void setUp() { //setup chormedriver
        WebDriverManager.chromedriver().setup();
        System.out.println("Test is Starting...");
        //String chromeProfilePath = "/Users/YLWPanda/Library/Application Support/Google/Chrome/Profile 3/"; //Chrome Profile 3 settings
        ChromeOptions options = new ChromeOptions();
        //ChromeOptions chromeProfile = new ChromeOptions(); //Chrome Profile 3 settings
        //chromeProfile.addArguments("chrome.switches", "--disable-extensions"); //Chrome Profile 3 settings
        //chromeProfile.addArguments("user-data-dir=" + chromeProfilePath); //Chrome Profile 3 settings
        //options.addArguments("--disable-notifications"); //Chrome Profile 3 settings
        //driver = new ChromeDriver(chromeProfile); //Chrome Profile 3 settings
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-extensions");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--window-size=1580,1280");
        options.addArguments("--incognito");
        //options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.get(TestData.URL);
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        System.out.println(driver.getTitle());

    }


    /*@AfterEach // closes all the browser windows opened by web driver
    public void tearDown() {
        System.out.println("Test is Ending...");
        driver.manage().deleteAllCookies();
        driver.quit();
    }*/
}
