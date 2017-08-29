import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by vsushelski on 2/22/2017.
 */
public class LocatorTest {

    @Test
    public void logInToEtsy(){

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.etsy.com/");
        WebElement btnSignIn = driver.findElement(By.id("sign-in"));
        btnSignIn.click();

        WebElement email = driver.findElement(By.id("username-existing"));
        WebElement pass = driver.findElement(By.id("password-existing"));
        email.sendKeys("seleniumwithdotnet");
        pass.sendKeys("Password2016");
        WebElement btnSubmit = driver.findElement(By.id("signin-button"));
        btnSubmit.click();

        WebElement searchBar = driver.findElement(By.id("search-query"));
        searchBar.sendKeys("Jeans");
        searchBar.sendKeys(Keys.ENTER);
        WebElement searchLabel = driver.findElement(By.cssSelector(".pb-xs-1-5.text-gray-darker.h3"));
        String actualText = searchLabel.getText();
        String expectedText = "Top categories for “Jeans”";

        Assert.assertEquals(expectedText,actualText);
    }



}
