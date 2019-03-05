package ru.granit.show.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SaveButtonPage extends BasePage {

    public SaveButtonPage(WebDriver driver) {
        super(driver, "Save button Page");
    }

    @Override
    public boolean isOpened(int timeout) {
        return false;
    }

    public void saveButtonMethod() throws InterruptedException {

        getLogger().getLogger().info("Save Button ");
        WebElement saveButton = getDriver().findElement(By.xpath("//button[@ng-click='save()']"));
        saveButton.click();
        Thread.sleep(2000);
    }
}
