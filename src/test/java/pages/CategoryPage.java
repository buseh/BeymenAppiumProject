package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.BaseMethod;


public class CategoryPage extends BaseMethod {
    AppiumDriver driver;
    private static final Logger LOG = LogManager.getLogger(CategoryPage.class);

    By woman = MobileBy.xpath("(//android.widget.ImageView[@resource-id='com.mobisoft.beymen:id/ivCategory'])[1]");
    By allWomen = MobileBy.xpath("(//android.widget.ImageView[@resource-id='com.mobisoft.beymen:id/ivCategory'])[1]");

    By subcategoriesOfWomen = By.id("com.mobisoft.beymen:id/recyclerViewCategories");

    public CategoryPage(AppiumDriver driver) {
        this.driver = driver;
    }

    public void clickWomanCategory() {
        try {
            driver.findElement(woman).isDisplayed();
        } catch (Exception e) {
            LOG.error(" Kadın kategorisi görünür degil! ");
        }
        driver.findElement(woman).click();
        LOG.info(" Kadın kategroisine tıklandı. ");
    }
    public void clickAllWomen() {
        try {
            driver.findElement(allWomen).isDisplayed();
        } catch (Exception e) {
            LOG.info(" Tüm kadın kategorisi alanı gorunur degil! ");
        }
        driver.findElement(allWomen).click();
        LOG.info(" Tüm kadın seçeneği seçildi. ");
    }
    public boolean checkSubcategoriesVisible() {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        try {
            WebElement bannerElement = wait.until(ExpectedConditions.visibilityOfElementLocated(subcategoriesOfWomen));
            if (bannerElement.isDisplayed()) {
                LOG.info(" Kadın kategorisinin alt seçenekleri görünür durumda. ");
                return true;
            } else {
                LOG.error(" Kadın kategorisinin alt seçenekleri görünmüyor! ");
                return false;
            }
        } catch (org.openqa.selenium.TimeoutException e) {
            LOG.error(" Element belirli bir süre içinde görünür hale gelmedi. ");
            return false;
        }
    }
}