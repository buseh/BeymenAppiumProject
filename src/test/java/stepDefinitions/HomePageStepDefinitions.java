package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import util.BaseMethod;
import util.DriverFactory;

public class HomePageStepDefinitions extends BaseMethod {
    HomePage homePage = new HomePage(DriverFactory.getDriver());

    @When("Konum etkinlestirilir.")
    public void activateLocation(){
        homePage.locationActive();
    }
    @When("Kategorilerin gorunur oldugu dogrulanir ve tıklanır.")
    public void clickToCategoriesButton() {
        homePage.clickCategoryButton();
    }

    @Then("Ana sayfada bulunan banner alaninin gorunur oldugu dogrulanır.")
    public void verifyBannerIsVisible() {
       homePage.isBannerVisible();

    }

}