package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CategoryPage;
import util.DriverFactory;

public class CategoryPageStepDefinitions {

    CategoryPage categoryPage = new CategoryPage(DriverFactory.getDriver());

    @When("Kadin kategorisi secilir.")
    public void kadınAlaninaTiklanir() {
        categoryPage.clickToWomenCategory();
    }

    @Then("Kadin kategorisinin alt kategorilerinin gorunur oldugu dogrulanır.")
    public void kadinKategorisininAltKategorilerininGorunurOlduguDogrulanır() {
        categoryPage.checkkadinaltsecenek();
    }

    @When("Tum Kadin secenegi secilir.")
    public void tumKadinSecenegiSecilir() {
        categoryPage.clickAllWomen();
    }
}
