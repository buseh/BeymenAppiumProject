package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.BaseMethod;

public class HomePage extends BaseMethod {
    AppiumDriver driver;
    private static final Logger LOG = LogManager.getLogger(HomePage.class);

    By locationActivation = MobileBy.xpath("//android.widget.Button[@index=1]");

    By homePageBtn = MobileBy.xpath("//android.widget.FrameLayout[@resource-id='com.mobisoft.beymen:id/navigation_mainpage']");

    By categoryBtn = MobileBy.xpath("//android.widget.FrameLayout[@index=1 and @resource-id='com.mobisoft.beymen:id/navigation_category']");

    By banner = MobileBy.xpath("(//android.widget.ImageView[@resource-id='com.mobisoft.beymen:id/bannerImage'])[1]");

    public HomePage(AppiumDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void locationActive() {
        try {
            driver.findElement(locationActivation).isDisplayed();
        }
        catch (Exception e) {
            LOG.info("Konum ayarları bildirimi gorunur degil!");
        }
        click(locationActivation);
        LOG.info("Konum aktifleştirildi.");

    }
    public void clickToCategoryBtn()
    {
        try {
            driver.findElement(categoryBtn).isDisplayed();
        }
        catch (Exception e) {
            LOG.info("Kategoriler butonu gorunur degil!");
        }
        driver.findElement(categoryBtn).click();
        LOG.info("Kategoriler butonuna tıklandı.");

    }


//...

    public boolean isBannerVisible() {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        try {
            WebElement bannerElement = wait.until(ExpectedConditions.visibilityOfElementLocated(banner));
            if (bannerElement.isDisplayed()) {
                LOG.info("Banner görünür");
                return true;
            } else {
                LOG.error("Banner görünür değil");
                return false;
            }
        } catch (org.openqa.selenium.TimeoutException e) {
            LOG.error("Element belirli bir süre içinde görünür hale gelmedi.");
            return false;
        }
    }


}