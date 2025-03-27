package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Driver;

import java.util.List;

public class CartDetailPage extends BasePage{

    @FindBy(css = "#checkout-cart")
    private WebElement cartCheckoutContainer;

    @FindBy(xpath = "//form//table[@class='table table-bordered']/tbody/tr")
    private List<WebElement> tableRows;

    @FindBy(xpath = "//table[@class='table table-bordered']/tbody/tr/td//input[@value='1']")
    private WebElement quantityOfProduct;

    @FindBy(xpath = "//div[@id='content']//p[text()='Your shopping cart is empty!']")
    private WebElement cartEmptyMessage;

    String productNameInTableDetail = "//table[@class='table table-bordered']/tbody/tr/td/a[contains(text(),'%s')]";

    String removeButtonOfASpecificProduct = "//table[@class='table table-bordered']/tbody/tr/td/a[contains(text(),'%s')]/../..//button[@class='btn btn-danger']";

    public CartDetailPage(Driver pageDriver) {
        super(pageDriver);
    }

    public int getRowsCountOfCartDetailTable(){
        verifyIfAElementIsDisplayed(cartCheckoutContainer);
        return tableRows.size();
    }

    public void verifyProductNameAndQuantityAreInCartDetailTable(String productName){
        By productNameOnCartDetail = By.xpath(String.format(productNameInTableDetail, productName));
        verifyIfAElementIsDisplayed(productNameOnCartDetail);
        verifyIfAElementIsDisplayed(quantityOfProduct);
    }

    public void clickOnDeleteASpecificProduct(String productName){
        By deleteOptionSpecifProduct = By.xpath(String.format(removeButtonOfASpecificProduct, productName));
        clickElement(deleteOptionSpecifProduct);
    }

    public void verifyTheProductNameIsNotExist(String productName){
        By productNameOnCartDetail = By.xpath(String.format(productNameInTableDetail, productName));
        verifyIfAElementNotDisplayed(productNameOnCartDetail);
    }

    public void verifyTheCartEmptyMessageIsDisplayed(){
        verifyIfAElementIsDisplayed(cartEmptyMessage);
    }



}
