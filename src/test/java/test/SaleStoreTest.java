package test;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import static utils.TakeSnapshot.takeSnapShot;



public class SaleStoreTest extends BaseTest {

    @Feature("Sale of item")
    @Story("Delete product of cart detail table")
    @Owner("Rodrigo Amurrio")
    @Description("THA-1: User can remove a item from cart detail table")
    @Test
    public void userAddAProductToCartAndDeleteIt() {

        homePage.enterProductName("iphone");
        homePage.clickOnSearchButton();
        homePage.clickOnAddToCartOfASpecificProduct("iPhone");
        Assert.assertTrue(homePage.getTextSuccessAlert().contains("You have added iPhone"));
        Allure.step("Success added item message", () -> {
            takeSnapShot(driver);
        });
        homePage.clickOnCartButton();
        homePage.clickOnViewCartButton();
        Assert.assertEquals(cartDetailPage.getRowsCountOfCartDetailTable(), 1);
        Allure.step("Cart detail table", () -> {
            takeSnapShot(driver);
        });
        cartDetailPage.verifyProductNameAndQuantityAreInCartDetailTable("iPhone");
        cartDetailPage.clickOnDeleteASpecificProduct("iPhone");
        cartDetailPage.verifyTheProductNameIsNotExist("iPhone");
        Allure.step("Cart detail empty", () -> {
            takeSnapShot(driver);
        });
        cartDetailPage.verifyTheCartEmptyMessageIsDisplayed();
    }
}
