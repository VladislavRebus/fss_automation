package ru.granit.show.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class EnterSequenceNumberIkzPage extends BasePage {

    private String numIKZ = "3301";

    public EnterSequenceNumberIkzPage(WebDriver driver) {
        super(driver, "Enter the sequence number for IKZ");
    }

    @Override
    public boolean isOpened(int timeout) {
        return false;
    }

    public void enterSequenceNumberIkzMethod() throws InterruptedException {

        getLogger().getLogger().info("Enter the sequence number for IKZ (4)");
        WebElement numberIKZ = getDriver().findElement(By.xpath("//*[@id=\"mainDataPanel\"]/div/form/fieldset/div[5]/div/input"));
        System.out.println("Вводим" + numIKZ);
        numberIKZ.sendKeys(numIKZ);
    }
}
