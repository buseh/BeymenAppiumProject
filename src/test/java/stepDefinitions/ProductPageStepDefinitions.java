package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ProductPage;
import util.BaseMethod;
import util.DriverFactory;

public class ProductPageStepDefinitions extends BaseMethod {

    ProductPage productPage = new ProductPage(DriverFactory.getDriver());


    @Then("Sepete eklenebilecek urunlerin siralandigi gorulur.")
    public void sepeteEklenebilecekUrunlerinSiralandigiGorulur() {
        productPage.itemsEligableForCart();
    }
    @When("Herhangi bir urun secilir")
    public void herhangiBirUrunSecilir() {
        productPage.chooseProduct();
    }
    @When("Beden secimi yapilarak sepete eklenir." )
    public void urunSepeteEklenir() {
        productPage.clickAddToBasket();
        productPage.chooseProductSize();
    }
    @Then("“Urun sepetinize eklendi” bilgisinin gorunur oldugu dogrulanır.")
    public void urunSepetinizeEklendiBilgisininGorunurOlduguDogrulanır() {
    }

    @When("Sepete Git secenegi secilir.")
    public void sepetSayfasinaGidilir() {
        productPage.chooseGoToCart();
    }



}