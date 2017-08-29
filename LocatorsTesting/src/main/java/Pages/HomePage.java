package Pages;

import Helper.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by vsushelski on 2/27/2017.
 */

public class HomePage extends BasePage {

    @FindBy(id = "search-query")
    WebElement searchBar;

    @FindBy(id = "sign-in")
    WebElement btnSignIn;

    @FindBy(css = ".user-nav.has-sub-nav")
    WebElement btnUser;

    @FindBy(id = "sub-nav-user-navigation")
    WebElement userInfo;

    @FindBy(id = "register")
    WebElement registerBtn;

    @FindBy(className = "btn")
    WebElement btnLogIn;

    @FindBy(className = "pull-right")
    WebElement profile;

    @FindBy(xpath = "//a[@href='http://www.phptravels.net/account/logout/']")
    WebElement btnLogout;

    public void clickSignIn(){
        btnSignIn.click();
    }

    public void clickLogIn(){btnLogIn.click();}

    public void logOut(){
        btnUser.click();
        WebElement btnLogOut = userInfo.findElement(By.cssSelector(".subnav-text-link.sign-out"));
        btnLogOut.click();
    }

    public void searchItems(String text){
        clearAndSendKeys(searchBar,text);
        searchBar.sendKeys(Keys.ENTER);
    }

    public void logMeout() throws Exception{

        profile.click();
        Thread.sleep(1000);
        btnLogout.click();
        Thread.sleep(1000);
    }

    public void clicRegister(){
        registerBtn.click();
    }

}
