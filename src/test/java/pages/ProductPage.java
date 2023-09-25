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

public class ProductPage extends BaseMethod {
    AppiumDriver driver;

    private static final Logger LOG = LogManager.getLogger(ProductPage.class);

    By product = MobileBy.xpath("(//android.widget.ImageView[@resource-id='com.mobisoft.beymen:id/ivProductImage'])[1]");
    By addToBasket = MobileBy.xpath("//android.widget.TextView[@resource-id='com.mobisoft.beymen:id/tvDisplayName']");
    By productSize = MobileBy.AndroidUIAutomator("new UiSelector().resourceId(\"com.mobisoft.beymen:id/tvSizeName\").text(\"37\")");
    By sepeteEklenebilecekUrunler = MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.mobisoft.beymen:id/searchResult_recycler\")).scrollIntoView(new UiSelector().index(1))");

    By goToBasket = By.id("android:id/button1");


    public ProductPage(AppiumDriver driver)  {
        this.driver = driver;
    }
    public boolean eklenebilecekUrunler() {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        try {
            WebElement bannerElement = wait.until(ExpectedConditions.visibilityOfElementLocated(sepeteEklenebilecekUrunler));
            if (bannerElement.isDisplayed()) {
                LOG.info("Eklenebilecek ürünler görünür.");
                return true;
            } else {
                LOG.error("Ürünler görünür değil.");
                return false;
            }
        } catch (org.openqa.selenium.TimeoutException e) {
            LOG.error("Ürünler belirli bir süre içinde görünür hale gelmedi.");
            return false;
        }
    }
    public void chooseProduct(){
        click(product);
        LOG.info("Ürün seçildi");
    }

    public void addToBasket() {
        try {
            driver.findElement(addToBasket).isDisplayed();
        }
        catch (Exception e) {
            LOG.info("Sepete eklerken hata olustu");
        }
        driver.findElement(addToBasket).click();
        LOG.info("Sepete ekle seçildi");
    }

    public void chooseProductSize() {
        try {
            driver.findElement(productSize).isDisplayed();
        }
        catch (Exception e) {
            LOG.info("Urun boyutu secerken hata olustu");
        }
        driver.findElement(productSize).click();
        LOG.info("Beden seçimi yapıldı");
    }

    public void goToBasket() {
        try {
            driver.findElement(goToBasket).isDisplayed();
        }
        catch (Exception e) {
            LOG.info("Sepete giderken hata olustu");
        }
        driver.findElement(goToBasket).click();
        LOG.info("Sepete gidildi.");
    }


}