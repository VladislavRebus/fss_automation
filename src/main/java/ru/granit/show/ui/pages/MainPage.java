package ru.granit.show.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends BasePage {

    private final By pageLocator = By.className("user-name-box");

    public MainPage(WebDriver driver) {
        super(driver, "Main Page");
    }

    @Override
    public boolean isOpened(int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), timeout);
            return wait.until(ExpectedConditions.visibilityOfElementLocated(pageLocator)) != null;
        }catch (TimeoutException e){
            getLogger().getLogger().debug(e);
            return false;
        }
    }
}
