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

    By womenCategory = MobileBy.xpath("(//android.widget.ImageView[@resource-id='com.mobisoft.beymen:id/ivCategory'])[1]");
    By allwomen = MobileBy.xpath("(//android.widget.ImageView[@resource-id='com.mobisoft.beymen:id/ivCategory'])[1]");

    By kadinaltsecenekler = By.id("com.mobisoft.beymen:id/recyclerViewCategories");

    public CategoryPage(AppiumDriver driver) {
        this.driver = driver;
    }

    public void clickToWomenCategory() {
        try {
            driver.findElement(womenCategory).isDisplayed();
            LOG.info("Kadın kategorisi görünür.");
        } catch (Exception e) {
            LOG.error("Kadın kategorisi alanı gorunur degil!");
        }
        driver.findElement(womenCategory).click();
        LOG.info("Kadın kategroisine tıklanır.");
    }
    public void clickAllWomen() {
        try {
            driver.findElement(allwomen).isDisplayed();
        } catch (Exception e) {
            LOG.info("Tüm kadın kategorisi alanı gorunur degil!");
        }
        driver.findElement(allwomen).click();
        LOG.info("Tüm kadın seçeneği seçilir.");
    }
    public boolean checkkadinaltsecenek() {
        WebDriverWait wait = new WebDriverWait(driver, 10); // 10 saniyeye kadar bekleyecek
        try {
            WebElement bannerElement = wait.until(ExpectedConditions.visibilityOfElementLocated(kadinaltsecenekler));
            if (bannerElement.isDisplayed()) {
                LOG.info("Kadın alt seçenekler görünür.");
                return true;
            } else {
                LOG.error("Kadın alt seçenkleri görünür değil.");
                return false;
            }
        } catch (org.openqa.selenium.TimeoutException e) {
            LOG.error("Element belirli bir süre içinde görünür hale gelmedi.");
            return false;
        }
    }
}