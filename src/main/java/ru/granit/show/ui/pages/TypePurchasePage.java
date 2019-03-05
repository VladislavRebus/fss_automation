package ru.granit.show.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TypePurchasePage extends BasePage{

    public TypePurchasePage(WebDriver driver) {
        super(driver, "Type of purchase Page");
    }

    @Override
    public boolean isOpened(int timeout) {
        return false;
    }

    public void typePurchaseMethod() throws InterruptedException {

        getLogger().getLogger().info("Choose the type of purchase"); //Выбираем тип закупки (8)
        WebElement tipZak = getDriver().findElement(By.xpath("//*[@id=\"mainDataPanel\"]/div/form/fieldset/div[8]/div/div/core-combo/div/div/span/span/span"));
        Thread.sleep(2000);
        tipZak.click();
        WebElement vybor2 = getDriver().findElement(By.xpath("/html/body/div[30]/div/ul/li[5]"));
        vybor2.click();
        Thread.sleep(1000);
    }
}
