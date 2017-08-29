package Pages;

import Helper.BasePage;
import Helper.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by vsushelski on 2/27/2017.
 */
public class LoginPage extends BasePage {

    @FindBy(id="username-existing")
    WebElement inputEmail;

    @FindBy(id = "password-existing")
    WebElement inputPassword;

    @FindBy(id = "signin-button")
    WebElement btnSubmit;

    @FindBy(name = "username")
    WebElement inputUsername;

    @FindBy(name = "password")
    WebElement inputPass;

    @FindBy(className = "btn")
    WebElement btnLogIn;


    public void signIn(String email, String password){
        clearAndSendKeys(inputEmail,email);
        clearAndSendKeys(inputPass,password);
        if(checkRobot()){
            WebElement robot = Driver.getDriver().findElement(By.className("recaptcha-checkbox-checkmark"));
            robot.click();
        }
        btnSubmit.click();
    }

        //TO DO
    public void logIn(String username, String password){
        clearAndSendKeys(inputUsername,username);
        clearAndSendKeys(inputPass,password);
        if(checkRobot()){
            WebElement robot = Driver.getDriver().findElement(By.className("recaptcha-checkbox-checkmark"));
            robot.click();
        }
        btnLogIn.click();
    }

    public boolean checkRobot(){
        Boolean flag;
        try {
            WebElement robot = Driver.getDriver().findElement(By.className("recaptcha-checkbox-checkmark"));
            flag = true;
        }catch (Exception e){
            flag = false;
        }
        return flag;
    }


//    WebElement btnSignIn = driver.findElement(By.id("sign-in"));
//        btnSignIn.click();
//
//    WebElement email = driver.findElement(By.id("username-existing"));
//    WebElement pass = driver.findElement(By.id("password-existing"));
//        email.sendKeys("seleniumwithdotnet");
//        pass.sendKeys("Password2016");
//    WebElement btnSubmit = driver.findElement(By.id("signin-button"));
//        btnSubmit.click();

}
