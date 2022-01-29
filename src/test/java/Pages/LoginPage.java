package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    public WebDriver driver;
    WebElement  username;
    WebElement password;
    WebElement LoginButton;
    WebElement errorMessage;




    public LoginPage(WebDriver driver) {
        this.driver = driver;

    }

    public WebElement getUsername() {
        return driver.findElement(By.id("user-name"));
    }

    public WebElement getPassword() {
        return driver.findElement(By.id("password"));
    }

    public WebElement getLoginButton() {
        return driver.findElement(By.id("login-button"));
    }

    public WebElement getErrorMessage() {
        return driver.findElement(By.className("error-button"));
    }



    //----------------------------------------------------------------

    public void inputUsername(String username) {
        this.getUsername().clear();
        this.getUsername().sendKeys(username);
    }

    public void inputPassword(String password) {
        this.getPassword().clear();
        this.getPassword().sendKeys(password);
    }

    public void clickOnLoginButton(){
        this.getLoginButton().click();
    }

    public String getLoginButtonText () {
        return this.getLoginButton().getText();

    }

    public String getErrorText(){
        return this.getErrorMessage().getText();

    }



}
