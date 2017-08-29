import Helper.Driver;
import Pages.HomePage;
import Pages.ItemPage;
import Pages.LoginPage;
import Pages.SearchPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by vsushelski on 2/27/2017.
 */
public class PomTest {

    public HomePage homePage;
    public SearchPage searchPage;
    public ItemPage itemPage;
    public LoginPage loginPage;


    @BeforeTest
    public void logIn() throws InterruptedException {
        homePage = new HomePage();
        homePage.navigateTo("https://www.etsy.com/");
        homePage.clickSignIn();
        Thread.sleep(1000);
        loginPage = new LoginPage();
        loginPage.signIn("seleniumwithdotnet","Password2016");
    }

    @Test
    public void checkItemPrice(){
        homePage.searchItems("Jeans");
        searchPage = new SearchPage();
        searchPage.selectFromTopCategoryByName("Women's Clothing");
        searchPage.selectItemByName("High waisted Denim Shorts Destroyed Ripped Jeans Vintage Cut Off Retro Grunge MADE TO ORDER");
        itemPage = new ItemPage();
        String actualPrice = itemPage.getPrice();
        String expectedPrice = "USD 33.00";

        Assert.assertEquals(expectedPrice,actualPrice);

    }

    @AfterClass

    public void tearDown(){
        Driver.closeDriver();
    }

}
