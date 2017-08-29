import Helper.Driver;
import Pages.HomePage;
import Pages.ItemPage;
import Pages.LoginPage;
import Pages.SearchPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

/**
 * Created by vsushelski on 2/27/2017.
 */

@SuppressWarnings("Duplicates")
public class LoginTest {

    public HomePage homePage;
    //public SearchPage searchPage;
    //public ItemPage itemPage;
    public LoginPage loginPage;


    @BeforeTest
    public void logIn() throws InterruptedException {
        homePage = new HomePage();
        homePage.navigateTo("http://www.phptravels.net/login");
        Thread.sleep(1000);
        loginPage = new LoginPage();
        loginPage.logIn("user@phptravels.com","demouser");
        Thread.sleep(2000);
    }

    @Test
    public void logMeOut() throws Exception{

        homePage.logMeout();
        Assert.assertTrue(1==1);

    }

    @AfterClass

    public void tearDown(){
        Driver.closeDriver();
    }

}