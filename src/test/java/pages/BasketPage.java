package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import util.BaseMethod;

public class BasketPage extends BaseMethod {
    AppiumDriver driver;

    private static final Logger LOG = LogManager.getLogger(BasketPage.class);
    By sayiDropdown = By.id("com.mobisoft.beymen:id/tvProductQuantity");
    By adetArttir = MobileBy.AndroidUIAutomator("new UiSelector().resourceId(\"com.mobisoft.beymen:id/title\").text(\"2\")");

    By initialPrice = MobileBy.AndroidUIAutomator("new UiSelector().resourceId(\"com.mobisoft.beymen:id/tvPrice1\").text(\"3.049,00 TL\")");

    By updatedPrice = MobileBy.AndroidUIAutomator("new UiSelector().resourceId(\"com.mobisoft.beymen:id/tvPrice1\").text(\"6.098,00 TL\")");
    private String initialPriceText;

    public String baslangic(){
        initialPriceText = getProductPrice(initialPrice);
        System.out.println("Başlangıç Fiyatı: " + initialPriceText);
        return initialPriceText;
    }

    public BasketPage(AppiumDriver driver) {
        this.driver = driver;
    }

    public void acsayiDropdown() {
        baslangic();
        click(sayiDropdown);
    }

    public void sayisiArttir() {
        click(adetArttir);
        LOG.info("2 adet ürün seçildi");
    }

    public void fiyatkarsilastir() {
        String updatedPriceText = getProductPrice(updatedPrice);

        System.out.println("Güncel Fiyat: " + updatedPriceText);

        if (initialPriceText != null && updatedPriceText != null) {
            double initialPriceValue = Double.parseDouble(initialPriceText.replace(" TL", "").replace(".", "").replace(",", "."));
            double updatedPriceValue = Double.parseDouble(updatedPriceText.replace(" TL", "").replace(".", "").replace(",", "."));

            if (initialPriceValue * 2 == updatedPriceValue) {
                LOG.info("Ürün adedi arttığında fiyat da aynı oranda artıyor.");
                System.out.println("Fiyat iki katına çıktı: " + updatedPriceText);
            } else {
                LOG.error("Hata: Fiyatlar beklenen şekilde artmıyor.");
                System.out.println("Fiyatlar iki katına çıkmadı. Güncel Fiyat: " + updatedPriceText);
            }
        } else {
            LOG.error("Hata: Fiyatlar alınamadı.");
            System.out.println("Fiyatlar alınamadı.");
        }
    }
}
