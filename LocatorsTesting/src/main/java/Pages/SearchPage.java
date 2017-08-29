package Pages;

import Helper.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by vsushelski on 2/27/2017.
 */
public class SearchPage extends BasePage {

    @FindBy(css = ".clearfix.banner-card-group")
    WebElement divTopCategories;

    @FindBy(css = ".block-grid-item.listing-card.position-relative.parent-hover-show")
    List<WebElement> divItems;

    public void selectFromTopCategoryByName(String name){
        List<WebElement> itemBlocks = divTopCategories.findElements(By.className("block-grid-item"));
        for (WebElement item:itemBlocks){
           String imageAlt = item.findElement(By.cssSelector("img[class='placeholder placeholder-landscape width-full']")).getAttribute("alt");
            WebElement link = item.findElement(By.tagName("a"));
            if(imageAlt.equals("Shop “Jeans” in "+ name)){
                String linkUrl = link.getAttribute("href");
                //link.click() - not working
                navigateTo(linkUrl);
                break;
            }
        }
    }

    public void selectItemByName(String name){
        for (WebElement item:divItems) {
            String title = item.findElement(By.cssSelector(".card-meta-row-item.card-title.selected-color")).getText();
            if(name.equals(title)){
                WebElement link = item.findElement(By.tagName("a"));
                String url = link.getAttribute("href");
                //link.click();
                navigateTo(url);
                break;
            }
        }
    }




}
