package ru.granit.show.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreateFormPurchaseObjectPage extends BasePage {

    public CreateFormPurchaseObjectPage(WebDriver driver) {
        super(driver, "Create form purchase object Page");
    }

    @Override
    public boolean isOpened(int timeout) {
        return false;
    }

    public void createFormPurchaseObjectMethod() throws InterruptedException {

        getLogger().getLogger().info("Create form purchase object (2)");
        WebElement createObjectPurch = getDriver().findElement(By.xpath("//*[@id=\"specificationsPanel\"]/div/div[1]/div[2]/button[1]"));
        createObjectPurch.click();
        Thread.sleep(2000);
    }
}
