package ru.granit.show.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ReadinessConfirmationPage extends BasePage {

    public ReadinessConfirmationPage(WebDriver driver) {
        super(driver, "Readiness confirmation Page");
    }

    @Override
    public boolean isOpened(int timeout) {
        return false;
    }

    public void readinessConfirmationMethod() throws InterruptedException {

        getLogger().getLogger().info("Readiness confirmation");//подтверждение готовности
        WebElement buttonReadinessConfirm = getDriver().findElement(By.xpath("//*[@id=\"main\"]/div[2]/div/div/div[1]/div[2]/div/ul/li[2]/a"));
        buttonReadinessConfirm.click();

        WebElement ReadinessConfirmation = getDriver().findElement(By.xpath("/html/body/div[32]/div/div/div[3]/button[2]"));
        ReadinessConfirmation.click();
        Thread.sleep(3000);
    }
}
