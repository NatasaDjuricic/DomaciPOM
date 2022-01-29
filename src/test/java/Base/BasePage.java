package Base;

import Pages.LoginPage;
import Pages.LogoutPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.time.Duration;

public class BasePage {

    public WebDriver driver;
    public WebDriverWait wdwait;
    public LoginPage loginPage;
    public LogoutPage logoutPage;
    public ExcelReader excelReader;
    public String homeURL;
    public String logoutURL;



    @BeforeClass
    public void setUp() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(15));
        excelReader = new ExcelReader("C:\\Users\\natad\\IdeaProjects\\DomaciPOM\\TextBook.xlsx");
        homeURL = excelReader.getStringData("URL", 1, 0);
        logoutURL = excelReader.getStringData("URL", 1, 1);

        loginPage = new LoginPage(driver);
        logoutPage = new LogoutPage(driver);

    }


    public void waiterVisibility(WebElement element){
        wdwait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waiterClickability(WebElement element){
        wdwait.until(ExpectedConditions.elementToBeClickable(element));
    }


    public void scroll(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

   /* @AfterClass
    public void tearDown(){
        driver.manage().deleteAllCookies();
        driver.close();
        driver.quit();
    }*/


}
