package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Driver;

public class HomePage extends BasePage{

    @FindBy(name = "search")
    private WebElement searchBar;

    @FindBy(css = ".btn-default")
    private WebElement searchButton;

    @FindBy(xpath = "//span[@id='cart-total']/parent::button")
    private WebElement cartButton;

    String specificProduct = "//div/h4/a[contains(text(),'%s')]/../../following-sibling::div//button/i[@class='fa fa-shopping-cart']";

    String successAlert = "//div[@class='alert alert-success alert-dismissible']";

    String viewCartOption = "//ul[@class='dropdown-menu pull-right']//a[contains(@href,'checkout/cart')]";

    public HomePage(Driver pageDriver) {
        super(pageDriver);
    }

    public void enterProductName(String productName){
        clearElement(searchBar);
        setTextAs(searchBar, productName);
    }

    public void clickOnSearchButton(){
        clickElement(searchButton);
    }

    public void clickOnAddToCartOfASpecificProduct(String productName){
        By cartButtonOfASpecificItem = By.xpath(String.format(specificProduct, productName));
        clickElement(cartButtonOfASpecificItem);
    }

    public String getTextSuccessAlert(){
        return getText(By.xpath(successAlert));
    }

    public void clickOnViewCartButton(){
        clickElement(By.xpath(viewCartOption));
    }

    public void clickOnCartButton(){
        clickElement(cartButton);
    }
}
