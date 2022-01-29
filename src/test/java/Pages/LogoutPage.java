package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogoutPage {

    public WebDriver driver;
    WebElement reactBurgerMenuButton;
    WebElement logoutSidebarLink;



    public LogoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getReactBurgerMenuButton() {
        return driver.findElement(By.id("react-burger-menu-btn"));
    }

    public WebElement getLogoutSidebarLink() {
        return driver.findElement(By.id("logout_sidebar_link"));
    }

    //-----------------------------------------------------

    public void clickOnReactBurgerMenuButton(){
        getReactBurgerMenuButton().click();
    }

    public void clickOnLogoutSidebarLink(){
        getLogoutSidebarLink().click();
    }
}
