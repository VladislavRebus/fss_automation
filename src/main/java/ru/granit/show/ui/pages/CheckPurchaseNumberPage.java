package ru.granit.show.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class CheckPurchaseNumberPage extends BasePage {

    private final String registryNumber = "000060-19";

    public CheckPurchaseNumberPage(WebDriver driver) {
        super(driver, "Check purchase number Page");
    }

    @Override
    public boolean isOpened(int timeout) {
        return false;
    }

    public void purchasePlanNumber() throws InterruptedException {

        getLogger().getLogger().info("Check purchase plan number");
        WebElement elementNumberPlan = getDriver().findElement(By.xpath("//*[@id=\"mainDataPanel\"]/div/form/fieldset/div[6]/div[1]/input"));
        Assert.assertEquals(elementNumberPlan.getAttribute("value"), registryNumber);
        Thread.sleep(2000);
    }
}
