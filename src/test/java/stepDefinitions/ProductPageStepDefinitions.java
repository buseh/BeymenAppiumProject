package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ProductPage;
import util.BaseMethod;
import util.DriverFactory;

public class ProductPageStepDefinitions extends BaseMethod {

    ProductPage productPage = new ProductPage(DriverFactory.getDriver());


    @Then("Sepete eklenebilecek urunlerin siralandigi gorulur.")
    public void productsCanBeAddedToCartVisible() {
        productPage.itemsEligableForCart();
    }
    @When("Herhangi bir urun secilir")
    public void chooseproduct() {
        productPage.chooseProduct();
    }
    @And("Beden secimi yapilarak sepete eklenir." )
    public void addProdcutToBasket() {
        productPage.clickAddToBasket();
        productPage.chooseProductSize();
    }

    @When("Sepete Git secenegi secilir.")
    public void goToBasket() {
        productPage.chooseGoToCart();
    }



}