package ru.granit.show.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CloseMessageButtonPage extends BasePage {

    public CloseMessageButtonPage(WebDriver driver) {super(driver, "Close message button Page");}

    @Override
    public boolean isOpened(int timeout) {
        return false;
    }

    public void closeMessageButton() throws InterruptedException {

        getLogger().getLogger().info("Close message");
        WebElement button = getDriver().findElement(By.xpath("/html/body/div[13]/div/div/div[3]/div/div[1]/div"));
        button.click();
        Thread.sleep(2000);
    }
}
