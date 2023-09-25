package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import util.BaseMethod;
import util.DriverFactory;

public class HomePageStepDefinitions extends BaseMethod {
    HomePage homePage = new HomePage(DriverFactory.getDriver());

    @When("Konum etkinlestirilir.")
    public void konumEtkinlestirilir() throws InterruptedException {
        homePage.locationActive();
        wait(5);
    }
    @When("Kategorilerin gorunur oldugu dogrulanir ve tıklanır.")
    public void kategorilerButonunaTiklanir() {
        homePage.clickToCategoryBtn();
    }

    @Then("Ana sayfada bulunan banner alaninin gorunur oldugu ve Ana sayfa tabinin secili oldugu dogrulanır.")
    public void anaSayfadaBulunanBannerAlanininGorunurOlduguVeAnaSayfaTabininSeciliOlduguDogrulanır() {
       homePage.isBannerVisible();

    }

}