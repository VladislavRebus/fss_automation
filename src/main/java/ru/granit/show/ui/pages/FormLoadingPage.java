package ru.granit.show.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FormLoadingPage extends BasePage {

    public FormLoadingPage(WebDriver driver) {
        super(driver, "Form loading Page");
    }

    @Override
    public boolean isOpened(int timeout) {
        return false;
    }

    public void openFormByNumber(int number) {

        getLogger().getLogger().info("Select form by number " + number);
        WebElement form = getDriver().findElement(By.xpath("//*[@id=\"main\"]/div[2]/div/div/div[1]/div[2]/div/ul/li[" + number + "]/a"));
        form.click();
    }
}
