package Pages;

/**
 * Created by dvelinovska on 3/1/2017.
 */

import Helper.BasePage;
import Helper.Driver;
import Helper.RandomDataGenerator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage extends BasePage{

    RandomDataGenerator randomDataGenerator = new RandomDataGenerator();

    @FindBy(id="first-name")
    WebElement firstName;

    @FindBy(id = "last-name")
    WebElement lastName;

    @FindBy(id = "email")
    WebElement email;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(id = "password-repeat")
    WebElement passwordRepeat;

    @FindBy(id = "username")
    WebElement username;

    @FindBy(id = "etsy_finds")
    WebElement regcheckBox;

    @FindBy(id = "register_button")
    WebElement regBtn;

    @FindBy(className = "confirm-email-notice")
    WebElement confirmEmail;

    public RegisterPage withRandomFirstName(){
        clearAndSendKeys(firstName, randomDataGenerator.generateRandomString(7));
        return this;
    }

    public RegisterPage withRandomLastName(){
        clearAndSendKeys(lastName, randomDataGenerator.generateRandomString(7));
        return this;
    }

    public RegisterPage withRandomEmail(){
        clearAndSendKeys(email, randomDataGenerator.randomEmail());
        return this;
    }

    public RegisterPage withRandomPassword(){
        String randomPass = randomDataGenerator.generateRandomString(8);
        clearAndSendKeys(password, randomPass);
        clearAndSendKeys(passwordRepeat, randomPass);
        return this;
    }

    public RegisterPage withRandomUsername(){
        clearAndSendKeys(username, randomDataGenerator.generateRandomString(8));
        return this;
    }

    public RegisterPage withFirstName(String name){
        clearAndSendKeys(firstName, name);
        return this;
    }

    public RegisterPage withLastName(String lastname){
        clearAndSendKeys(lastName, lastname);
        return this;
    }

    public RegisterPage withEmail(String emailString){
        clearAndSendKeys(email, emailString);
        return this;
    }

    public RegisterPage withPassword(String passwordString){
        clearAndSendKeys(password, passwordString);
        clearAndSendKeys(passwordRepeat, passwordString);
        return this;
    }

    public RegisterPage withUsername(String userName){
        clearAndSendKeys(username, userName);
        return this;
    }

    public RegisterPage  andSubscribeForNewsLetter(){
        regcheckBox.click();
        return this;
    }

    public void waitForRegisterWindow(){
        waitelementToBeVisiable(new WebDriverWait(driver, 10), driver, regBtn);
    }

    public void clickRegisterBtn(){
        regBtn.click();
    }

    public boolean confirmBoxIsDisplayed(){

        if(confirmEmail.isDisplayed()){
        }
        return true;
    }

}
