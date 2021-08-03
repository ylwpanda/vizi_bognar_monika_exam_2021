package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class ProfileMenu {

    private final WebDriver driver;
    private final By profileButton = By.xpath("//*[@id=\"imdbHeader\"]/div[2]/div[5]/div/label[2]/div/svg");

    public ProfileMenu(WebDriver driver){
        this.driver = driver;
    }

    public void selectFromProfileMenu(String menuitem){
        findProfileMenuOption().selectByVisibleText(menuitem);
    }

    public List<String> getSelectedOptions() {
        List<WebElement> selectedOptions = findProfileMenuOption().getAllSelectedOptions();
        return selectedOptions.stream().map(e->e.getText()).collect(Collectors.toList());
    }

    private Select findProfileMenuOption(){
        return new Select(driver.findElement(profileButton));
    }
}
