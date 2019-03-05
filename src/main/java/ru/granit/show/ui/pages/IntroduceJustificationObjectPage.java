package ru.granit.show.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IntroduceJustificationObjectPage extends BasePage{

    private String justification = "Прямая необходимость";

    public IntroduceJustificationObjectPage(WebDriver driver) {
        super(driver, "Introduce justification" +
                " object Page");
    }

    @Override
    public boolean isOpened(int timeout) {
        return false;
    }

    public void introduceJustificationObjectMethod() throws InterruptedException {

        getLogger().getLogger().info("Introduce the justification of the object");//Вводим обоснование соответствия объекта (12)
        WebElement justificObj = getDriver().findElement(By.xpath("//*[@id=\"to-purchase\"]"));
        justificObj.sendKeys(justification);
        Thread.sleep(2000);
    }
}
