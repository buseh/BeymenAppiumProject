package stepDefinitions;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CategoryPage;
import util.BaseMethod;
import util.DriverFactory;

public class CategoryPageStepDefinitions extends BaseMethod {

    CategoryPage categoryPage = new CategoryPage(DriverFactory.getDriver());

    @When("Kadin kategorisi secilir.")
    public void clickToWomanCategory() {
        categoryPage.clickWomanCategory();
    }

    @Then("Kadin kategorisinin alt kategorilerinin gorunur oldugu dogrulanır.")
    public void verifySubcategoriesOfWomenVisible() {
        categoryPage.checkSubcategoriesVisible();
    }

    @When("Tum Kadin secenegi secilir.")
    public void clickToAllWomen() {
        categoryPage.clickAllWomen();
    }
}
