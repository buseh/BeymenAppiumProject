package util;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class BaseMethod extends DriverFactory {
    public WebDriverWait wait;
    private static final Logger LOG = LogManager.getLogger(BaseMethod.class);



    public BaseMethod() {
        wait = new WebDriverWait(driver, 5);
    }

    public void wait(int time) throws InterruptedException {
        TimeUnit.SECONDS.sleep(time);
    }
    public void click(By key){
        getDriver().findElement(key).click();
    }
    public String getProductPrice(By element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 3);
            WebElement priceElement = wait.until(ExpectedConditions.visibilityOfElementLocated(element));

            String priceText = priceElement.getText();
            String cleanedPrice = priceText.replaceAll("[^0-9.]", "");
            LOG.info("Güncel sepet fiyatı: " + cleanedPrice);
            return cleanedPrice;
        } catch (Exception e) {
            LOG.error("Sepet fiyatı alınamadı: " + e.getMessage());
            return null;
        }
    }


}