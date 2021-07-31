package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import pages.HomePage;

import java.util.List;


import static org.openqa.selenium.By.tagName;

public class BaseTest {

    private WebDriver driver;
    protected HomePage homePage;
    protected String email = "monica.bognar@gmail.com";
    protected String password = "CodeCool2021";

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeClass
    public void setUp() { //setup chorme, incognito mode
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
        driver.get("https://www.imdb.com/");
        driver.manage().window().maximize();

        //driver.manage().window().setSize(new Dimension(375, 812)); //iPhone X size screen
        //List<WebElement> links = driver.findElements(By.tagName("a"));
        //System.out.println(links.size()); //List elemements of webpage like "a" element.

        homePage = new HomePage(driver);

        System.out.println(driver.getTitle());

    }

    /*@AfterClass // closes all the browser windows opened by web driver
    public void tearDown() {
        driver.quit();
    }*/
}
