package ru.granit.show.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ActionButtonPage extends BasePage {

    public ActionButtonPage(WebDriver driver) {super(driver, "Action Button Page");}

    @Override
    public boolean isOpened(int timeout) {
        return false;
    }

    public void clickActionButton() {

        getLogger().getLogger().info("Click action button");
        WebElement button = getDriver().findElement(By.xpath("//*[@id=\"main\"]/div[2]/div/div/div[1]/div[2]/div/button"));
        button.click();
    }
}
