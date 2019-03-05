package ru.granit.show.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IntroduceNameObjectPurchasePage extends BasePage {

    private String nameObjectPurch = "Партия кожаных дипломатов MAKEY";

    public IntroduceNameObjectPurchasePage(WebDriver driver) {
        super(driver, "Introduce the name of the object or objects of purchase Page");
    }

    @Override
    public boolean isOpened(int timeout) {
        return false;
    }

    public void introduceNameObjectPurchaseMethod() throws InterruptedException {

        getLogger().getLogger().info("Introduce the name of the object of purchase");//Введем наименование объекта или объектов закупки ()
        WebElement nameObjectPurchElement = getDriver().findElement(By.xpath("//*[@id=\"mainDataPanel\"]/div/form/fieldset/div[11]/div/div/input"));
        nameObjectPurchElement.sendKeys(nameObjectPurch);
        Thread.sleep(2000);
    }
}
