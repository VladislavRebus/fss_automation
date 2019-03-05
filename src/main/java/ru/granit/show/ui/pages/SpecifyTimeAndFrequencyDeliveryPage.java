package ru.granit.show.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SpecifyTimeAndFrequencyDeliveryPage extends BasePage{

    private String time2 = "Эти буквы должны быть здесь";

    public SpecifyTimeAndFrequencyDeliveryPage(WebDriver driver) {super(driver, "Specify the time and " +
            "frequency of delivery");}

    @Override
    public boolean isOpened(int timeout) {
        return false;
    }

    public void specifyTimeAndFrequencyDeliveryMethod() throws InterruptedException {

        getLogger().getLogger().info("Specify the time and frequency of delivery");//Укажем срок и периодичность поставки (14)
        WebElement checkBoxTime = getDriver().findElement(By.xpath("//*[@id=\"deliveryTerm\"]/div/div/div[1]/label/input"));
        checkBoxTime.click();
        Thread.sleep(2000);
        //поле иное
        WebElement otherwise = getDriver().findElement(By.xpath("//*[@id=\"deliveryTerm\"]/div/div/div[3]/textarea[2]"));
        otherwise.sendKeys(time2);
        Thread.sleep(2000);
    }
}
