package ru.granit.show.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SendingForApprovalPage extends BasePage {

    public SendingForApprovalPage(WebDriver driver) {super(driver, "Sending for approval Page");}

    @Override
    public boolean isOpened(int timeout) {
        return false;
    }

    public void sendingForApprovalMethod() throws InterruptedException {

        getLogger().getLogger().info("Sending for approval");
        WebElement sendApprovButton = getDriver().findElement(By.xpath("//*[@id=\"main\"]/div[2]/div/div/div[1]/div[2]/div/ul/li[13]/a"));
        sendApprovButton.click();
        Thread.sleep(3000);
    }
}
