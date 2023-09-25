package util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class BaseMethod extends DriverFactory {
    public WebDriverWait wait;


    public BaseMethod() {
        wait = new WebDriverWait(driver, 5);
    }

    public void wait(int time) throws InterruptedException {
        TimeUnit.SECONDS.sleep(time);
    }
    public void click(By key){
        getDriver().findElement(key).click();  // click --- tıklamayı sağlar.
    }
    public String getProductPrice(By element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10); // 10 saniyeye kadar bekle
            WebElement priceElement = wait.until(ExpectedConditions.visibilityOfElementLocated(element));

            String priceText = priceElement.getText();
            String cleanedPrice = priceText.replaceAll("[^0-9.]", "");
            System.out.println("Sepet fiyatı: " + cleanedPrice);
            return cleanedPrice;
        } catch (Exception e) {
            System.err.println("Sepet fiyatı alınamadı: " + e.getMessage());
            return null;
        }
    }


}