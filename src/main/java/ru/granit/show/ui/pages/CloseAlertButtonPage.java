package ru.granit.show.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CloseAlertButtonPage extends BasePage {

    public CloseAlertButtonPage(WebDriver driver) {
        super(driver, "Close alert button Page");
    }

    @Override
    public boolean isOpened(int timeout) {
        return false;
    }

    public void closeAlertButtonMethod() throws InterruptedException {

        getLogger().getLogger().info("Close alert ");
        WebElement closeButton = getDriver().findElement(By.xpath("/html/body/div[21]/div/div/div[3]/button"));
        closeButton.click();
        Thread.sleep(2000);
    }
}
