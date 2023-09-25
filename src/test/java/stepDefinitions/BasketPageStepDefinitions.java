package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BasketPage;
import util.DriverFactory;

public class BasketPageStepDefinitions {
    BasketPage basketPage = new BasketPage(DriverFactory.getDriver());
    
    @When("Urun adedi 1 adet arttirilir.")
    public void urunAdediArttirilir() {
        basketPage.acsayiDropdown();
        basketPage.sayisiArttir();

    }

    @Then("Fiyat bilgisinin aynı oranda arttigi dogrulanir.")
    public void fiyatBilgisininAynıOrandaArttigiDogrulanir() {
        basketPage.fiyatkarsilastir();
    }
}

