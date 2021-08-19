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
        var ChromeOptions = new ChromeOptions();
        //var ChromeOptions = new ChromeOptions(); //Chrome Profile 3 settings
        //ChromeOptions.addArguments("chrome.switches", "--disable-extensions"); //Chrome Profile 3 settings
        //ChromeOptions.addArguments("user-data-dir=" + chromeProfilePath); //Chrome Profile 3 settings
        //ChromeOptions.addArguments("--disable-notifications"); //Chrome Profile 3 settings
        //driver = new ChromeDriver(ChromeOptions); //Chrome Profile 3 settings
        ChromeOptions.addArguments("--headless");
        ChromeOptions.addArguments("--disable-gpu");
        ChromeOptions.addArguments("--disable-extensions");
        ChromeOptions.addArguments("--no-sandbox");
        ChromeOptions.addArguments("--disable-dev-shm-usage");
        ChromeOptions.addArguments("--allow-insecure-localhost");
        ChromeOptions.addArguments("--user-agent=Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/92.0.4515.159 Safari/537.36");
        ChromeOptions.addArguments("--window-size=2560,1600"); //mac(2560,1600)1920,1080
        ChromeOptions.addArguments("--incognito");
        driver = new ChromeDriver(ChromeOptions);
        driver.get(TestData.URL);
        //driver.manage().window().maximize();
        homePage = new HomePage(driver);
        System.out.println(driver.getTitle());

    }


    @AfterEach // closes all the browser windows opened by webdriver
    public void tearDown() {
        System.out.println("Test is Ending...");
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
