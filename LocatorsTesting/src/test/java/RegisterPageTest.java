import Helper.Driver;
import Helper.RandomDataGenerator;
import Pages.HomePage;
import Pages.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


/**
 * Created by dvelinovska on 3/1/2017.
 */
public class RegisterPageTest {

    HomePage homePage = new HomePage();
    RegisterPage fillRegistrationForm = new RegisterPage();
    RandomDataGenerator randomDataGenerator = new RandomDataGenerator();

    @BeforeMethod
    public void logIn() throws InterruptedException {
        homePage = new HomePage();
        homePage.navigateTo("https://www.etsy.com/");
        homePage.clicRegister();

    }
// how not to do it:)
    @Test public void registerWithHardCodedData(){
        fillRegistrationForm.waitForRegisterWindow();
        fillRegistrationForm.withFirstName("Daniela")
                .withLastName("Velinovska")
                .withEmail("d.velinovska@gmail.com")
                .withPassword("PassWord!2#$")
                .withUsername("NekojUserNAme").
                andSubscribeForNewsLetter();
        fillRegistrationForm.clickRegisterBtn();
        Assert.assertTrue(fillRegistrationForm.confirmBoxIsDisplayed());

    }

    @Test public void registerWithRandomDataHidden(){
        fillRegistrationForm.waitForRegisterWindow();
        fillRegistrationForm.withRandomFirstName()
                .withRandomLastName()
                .withRandomEmail()
                .withRandomPassword()
                .withRandomUsername()
                .andSubscribeForNewsLetter();
        fillRegistrationForm.clickRegisterBtn();
        Assert.assertTrue(fillRegistrationForm.confirmBoxIsDisplayed());

    }

    @Test public void registerWithRandomData(){
        fillRegistrationForm.waitForRegisterWindow();
        fillRegistrationForm.withFirstName(randomDataGenerator.generateRandomString(5))
                .withLastName(randomDataGenerator.generateRandomString(5))
                .withEmail(randomDataGenerator.randomEmail())
                .withPassword(randomDataGenerator.generateRandomString(10))
                .withUsername(randomDataGenerator.generateRandomString(10))
                .andSubscribeForNewsLetter();
        fillRegistrationForm.clickRegisterBtn();
        Assert.assertTrue(fillRegistrationForm.confirmBoxIsDisplayed());

    }



    @AfterClass

    public void tearDown(){
        Driver.closeDriver();
    }


}
