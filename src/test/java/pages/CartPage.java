package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import util.BaseMethod;

public class CartPage extends BaseMethod {
    AppiumDriver driver;

    private static final Logger LOG = LogManager.getLogger(CartPage.class);
    By quantitiySelectDropdown = By.id("com.mobisoft.beymen:id/tvProductQuantity");
    By twoPieces = MobileBy.AndroidUIAutomator("new UiSelector().resourceId(\"com.mobisoft.beymen:id/title\").text(\"2\")");

    By initialPrice = MobileBy.AndroidUIAutomator("new UiSelector().resourceId(\"com.mobisoft.beymen:id/tvPrice1\").text(\"3.049,00 TL\")");

    By updatedPrice = MobileBy.AndroidUIAutomator("new UiSelector().resourceId(\"com.mobisoft.beymen:id/tvPrice1\").text(\"6.098,00 TL\")");
    private String initialPriceText;


    public CartPage(AppiumDriver driver) {
        this.driver = driver;
    }
    public String setInitialPrice(){
        initialPriceText = getProductPrice(initialPrice);
        return initialPriceText;
    }


    public void clickQuantityDropdown() {
        setInitialPrice();
        click(quantitiySelectDropdown);
    }

    public void setTwoPieces() {
        click(twoPieces);
        LOG.info(" Ürün sayısı 2 olarak güncellendi. ");
    }

    public void priceIncreaseRate() {
        String updatedPriceText = getProductPrice(updatedPrice);

        if (initialPriceText != null && updatedPriceText != null) {
            double initialPriceValue = Double.parseDouble(initialPriceText.replace(".", "").replace(",", "."));
            double updatedPriceValue = Double.parseDouble(updatedPriceText.replace(".", "").replace(",", "."));

            if (initialPriceValue * 2 == updatedPriceValue) {
                LOG.info(" Ürün adedi arttığında fiyat da aynı oranda artıyor. ");
                LOG.error(" Fiyat iki katına çıktı:  " + updatedPriceText);
            } else {
                LOG.error(" Fiyat aynı oranda artmadı. Güncel Fiyat: " + updatedPriceText);
            }
        } else {
            LOG.error(" Fiyatlar alınamadı! ");
        }
    }
}
