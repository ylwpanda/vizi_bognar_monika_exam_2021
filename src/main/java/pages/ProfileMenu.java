package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class ProfileMenu {

    private WebDriver driver;
    private final By PROFILE_BUTTON = By.id("navUserMenu-contents");

    public ProfileMenu(WebDriver driver){
        this.driver = driver;
    }

    public void selectFromProfileMenu(String menuitem) {
        findMenuItem().selectByVisibleText(menuitem);
    }

    public void setSelectedItem(String menuitem){
        Select select= new Select(driver.findElement(PROFILE_BUTTON));
        select.selectByVisibleText(menuitem);
    }

    //Select select= new Select(driver.findElement(STATE));
    //        select.selectByValue(String.valueOf(st));

    private Select findMenuItem(){
        return new Select(driver.findElement(PROFILE_BUTTON));
    }
}