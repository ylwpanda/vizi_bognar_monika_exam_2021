package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;



public class Utils {

    public static void scrollDown(WebDriver driver){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 15000)");
    }

    public static void refresh(WebDriver driver){
        driver.navigate().refresh();
    }

    public static void waitForXMillis(int time) throws InterruptedException {
        Thread.sleep(time);
    }

    /*public class SeleniumTakeScreenshot {
        public static void main(String args[]) throws IOException {
            WebDriver driver = new getDriver();
            driver.get("http://www.example.com");
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("./image.png"));
            driver.quit();
        }
    }*/
}
