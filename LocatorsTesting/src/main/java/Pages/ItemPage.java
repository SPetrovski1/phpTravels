package Pages;

import Helper.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by vsushelski on 2/27/2017.
 */
public class ItemPage extends BasePage {

    @FindBy(id = "listing-price")
    WebElement labelPrice;

    public String getPrice(){
        return labelPrice.getText();
    }

}
