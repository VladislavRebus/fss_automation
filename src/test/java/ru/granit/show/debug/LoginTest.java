package ru.granit.show.debug;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import ru.granit.show.BaseTest;

public class LoginTest extends BaseTest {
    @Test
    public void loginTest() throws InterruptedException {

        String login = "saratovsch";
        String password = "SHETKO1990";

        getLogger().info("Sign in '" + login + "'");
        WebElement elementLog = webDriver.findElement(By.id("loginTxt"));
        elementLog.sendKeys(login);
        WebElement elementPass = webDriver.findElement(By.id("passwordTxt"));
        elementPass.sendKeys(password);
        WebElement elementButtonEnter = webDriver.findElement(By.className("send-data"));
        elementButtonEnter.click();
        Thread.sleep(2000);
    }
}
