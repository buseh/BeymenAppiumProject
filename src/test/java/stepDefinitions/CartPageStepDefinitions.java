package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CartPage;
import util.DriverFactory;

public class CartPageStepDefinitions {
    CartPage cartPage = new CartPage(DriverFactory.getDriver());
    
    @When("Urun adedi 1 adet arttirilir.")
    public void increaseQuantityBy1Unit() {
        cartPage.clickQuantityDropdown();
        cartPage.setTwoPieces();

    }

    @Then("Fiyat bilgisinin aynı oranda arttigi dogrulanir.")
    public void verifyProporionalPriceIncrease() {
        cartPage.priceIncreaseRate();
    }
}

