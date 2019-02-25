package ru.granit.show.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    private final By loginTxtLocator = By.id("loginTxt");
    private final By passwordTxtLocator = By.id("passwordTxt");
    private final By loginBtnLocator = By.cssSelector("button[type='submit']");

    public LoginPage(WebDriver driver) {
        super(driver, "Login Page");
    }

    @Override
    public boolean isOpened(int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), timeout);
            return wait.until(ExpectedConditions.visibilityOfElementLocated(loginTxtLocator)) != null;
        }catch (TimeoutException e){
            getLogger().getLogger().debug(e);
            return false;
        }
    }

    public MainPage login(String login, String password){
        getLogger().getLogger().info("Sign in as '" + login + "' with password '" + password + "'");

        getDriver().findElement(loginTxtLocator).sendKeys(login);
        getDriver().findElement(passwordTxtLocator).sendKeys(password);
        getDriver().findElement(loginBtnLocator).click();

        return new MainPage(getDriver());
    }

}
