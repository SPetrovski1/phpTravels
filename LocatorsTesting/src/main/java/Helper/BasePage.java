package Helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by vsushelski on 2/20/2017.
 */
public class BasePage {

    public WebDriver driver = Driver.getDriver();

    public BasePage() {
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver,30);
        PageFactory.initElements(factory,this);
    }

    public void navigateTo(String URL)
    {
        driver.get(URL);
    }

    public void implicityWait(int seconds)
    {
        driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }

    public void clearAndSendKeys(WebElement element, String text){
        element.clear();
        element.sendKeys(text);
    }

    public static void waitelementToBeVisiable(WebDriverWait wait, WebDriver driver, WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }

}
