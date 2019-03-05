package ru.granit.show.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreatePurchaseObjectPage extends BasePage{

    public CreatePurchaseObjectPage(WebDriver driver) {
        super(driver, "Create purchase object Page");
    }

    @Override
    public boolean isOpened(int timeout) {
        return false;
    }

    public void createPurchaseObjectMethod() throws InterruptedException {

        getLogger().getLogger().info("Create a purchase object");//Создадим объект закупки
        WebElement buttonPurchaseObjCreate = getDriver().findElement(By.xpath("//*[@id=\"accordion8\"]/div/div[2]/button"));
        buttonPurchaseObjCreate.click();
        Thread.sleep(2000);
        WebElement buttonPotrIzReestra = getDriver().findElement(By.xpath("/html/body/div[27]/div/div/div[2]/div[1]/div[2]/core-link/div/div[1]/div/button"));
        buttonPotrIzReestra.click();
        Thread.sleep(2000);
        WebElement objFromRegistry701 = getDriver().findElement(By.xpath("//*[@id=\"tsrNeedsGrid\"]/div[2]/table/tbody/tr[1]/td[2]"));
        objFromRegistry701.click();
        Thread.sleep(2000);
        WebElement buttonChoice = getDriver().findElement(By.xpath("/html/body/div[29]/div/div/div/div[4]/button[2]"));//кнопка выбор
        buttonChoice.click();
        Thread.sleep(2000);
        WebElement typeOrder = getDriver().findElement(By.xpath("/html/body/div[27]/div/div/div[2]/div[3]/div[2]/core-combo/div/div/span/span/span"));//тип заказа
        typeOrder.click();
        Thread.sleep(2000);
        WebElement product = getDriver().findElement(By.xpath("/html/body/div[28]/div/ul/li[1]")); //товар
        product.click();
    }
}
