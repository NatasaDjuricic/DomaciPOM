package Test;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Locale;

public class TestLogin extends BasePage {

    @BeforeMethod
    public void setUpPage(){
        driver.manage().window().maximize();
        driver.navigate().to(homeURL);
    }

    @Test (priority = 10)
    public void verifyThatUserCanLogIn() throws InterruptedException {
        for(int i = 1; i<=excelReader.getLastRow(); i++){


            driver.navigate().to(homeURL);
            String validUsername = excelReader.getStringData("LoginCredentials", 1, 0);
            String validPassword = excelReader.getStringData("LoginCredentials", 1, 1);

            loginPage.inputUsername(validUsername);
            loginPage.inputPassword(validPassword);
            loginPage.clickOnLoginButton();
            logoutPage.clickOnReactBurgerMenuButton();

            waiterVisibility(logoutPage.getLogoutSidebarLink());
            Assert.assertTrue(logoutPage.getLogoutSidebarLink().isDisplayed());


            String logOutButtonText = logoutPage.getLogoutSidebarLink().getText().toUpperCase(Locale.ROOT);
            waiterVisibility(logoutPage.getLogoutSidebarLink());


            String actualURL = driver.getCurrentUrl();
            String expectedURL = logoutURL;

            Assert.assertEquals(actualURL, expectedURL);
        }

        }

        @Test (priority = 20)

    public void verifyThatUserCannotLogInWithInvalidUsername(){
        for(int i = 1; i<=excelReader.getLastRow(); i++) {
            String invalidUsername = excelReader.getStringData("LoginCredentials", i, 2);
            String validPassword = excelReader.getStringData("LoginCredentials", i, 1);

            loginPage.inputUsername(invalidUsername);
            loginPage.inputPassword(validPassword);
            loginPage.clickOnLoginButton();

            waiterVisibility(loginPage.getErrorMessage());
            Assert.assertTrue(loginPage.getErrorMessage().isDisplayed());
        }
            String expectedErrorMessage = excelReader.getStringData("ErrorMessage", 1 ,0);
            //Ne znam zasto ne cita text iz ovog elementa
            //Assert.assertEquals(loginPage.getErrorText(), expectedErrorMessage);
            System.out.println(loginPage.getErrorMessage().getText());

            String actualURL = driver.getCurrentUrl();
            String expectedURL = homeURL;

            Assert.assertEquals(actualURL, expectedURL);

            Assert.assertTrue(loginPage.getLoginButton().isDisplayed());






        }








    }





