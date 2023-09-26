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

    By locationActivation = By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button");
    By categories = MobileBy.xpath("//android.widget.FrameLayout[@index=1 and @resource-id='com.mobisoft.beymen:id/navigation_category']");

    By banner = MobileBy.xpath("(//android.widget.ImageView[@resource-id='com.mobisoft.beymen:id/bannerImage'])[1]");

    public HomePage(AppiumDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void locationActive() {
        try {
            driver.findElement(locationActivation).isDisplayed();
            LOG.info(" Kullanırken konumu aktif olsun seçeneği görüldü. ");
        }
        catch (Exception e) {
            LOG.error(" Kullanırken konumu aktif olsun seçeneği görülemedi!  ");
        }
        click(locationActivation);
        LOG.info(" Konum aktifleştirildi. ");

    }
    public void clickCategoryButton()
    {
        try {
            driver.findElement(categories).isDisplayed();
            LOG.info(" Kategoriler butonu görüldü. ");
        }
        catch (Exception e) {
            LOG.error(" Kategoriler butonu görünür degil! ");
        }
        driver.findElement(categories).click();
        LOG.info(" Kategoriler butonuna tıklandı. ");

    }

    public boolean isBannerVisible() {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        try {
            WebElement bannerElement = wait.until(ExpectedConditions.visibilityOfElementLocated(banner));
            if (bannerElement.isDisplayed()) {
                LOG.info(" Anasayfadaki banner alanı görünür durumda. ");
                return true;
            } else {
                LOG.error(" Banner görünür değil! ");
                return false;
            }
        } catch (org.openqa.selenium.TimeoutException e) {
            LOG.error(" Element belirli bir süre içinde görünür hale gelmedi. ");
            return false;
        }
    }


}