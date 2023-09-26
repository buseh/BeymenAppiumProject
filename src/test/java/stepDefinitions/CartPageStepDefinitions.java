package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.CartPage;
import util.DriverFactory;

public class CartPageStepDefinitions {
    CartPage cartPage = new CartPage(DriverFactory.getDriver());
    
    @And("Urun adedi 1 adet arttirilir.")
    public void increaseQuantityBy1Unit() {
        cartPage.clickQuantityDropdown();
        cartPage.setTwoPieces();

    }

    @Then("Fiyat bilgisinin aynı oranda arttigi dogrulanir.")
    public void verifyProporionalPriceIncrease() {
        cartPage.priceIncreaseRate();
    }
}

