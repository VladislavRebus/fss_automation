package ru.granit.show;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ApprovalOfThePZ extends BaseTest {
    @Test
    public void openPPZ() throws InterruptedException {

        //вход
        String login = "saratovsch";
        String password = "SHETKO1990";
        String registryNumber = "000060-19";
        String surnameKey = "Максимов";
        String nameKey = "Максим";
        String positionKey = "Ведущий специалист";
        String sumKey = "75000000";
        WebElement elementLog = webDriver.findElement(By.id("loginTxt"));
        elementLog.sendKeys(login);
        WebElement elementPass = webDriver.findElement(By.id("passwordTxt"));
        elementPass.sendKeys(password);
        WebElement elementButtonEnter = webDriver.findElement(By.className("send-data"));
        elementButtonEnter.click();
        Thread.sleep(6000);

        getLogger().info("Close message button");
        WebElement closeMessageButton = webDriver.findElement(By.xpath("/html/body/div[13]/div/div/div[3]/div/div[1]/div"));
        closeMessageButton.click();
        Thread.sleep(2000);

        getLogger().info("Check the purchase plan number");
        WebElement elementNumberPlan = webDriver.findElement(By.xpath("//*[@id=\"mainDataPanel\"]/div/form/fieldset/div[6]/div[1]/input"));
        Assert.assertEquals(elementNumberPlan.getAttribute("value"), registryNumber);
        Thread.sleep(2000);

        getLogger().info("Scroll down");
        JavascriptExecutor jse = (JavascriptExecutor) webDriver;
        jse.executeScript("window.scrollBy(0,900)", "");
        Thread.sleep(2000);

        getLogger().info("Enter the surname, name, position");
        WebElement buttonHead = webDriver.findElement(By.xpath("//*[@id=\"accordion8\"]/div[1]/h2"));
        buttonHead.click();
        Thread.sleep(2000);

        getLogger().info("Surname");
        WebElement surname = webDriver.findElement(By.xpath("//*[@id=\"confirmPersonPanel\"]/div/div/div[1]/div/input"));
        surname.clear();
        surname.sendKeys(surnameKey);
        Thread.sleep(2000);

        getLogger().info("Name");
        WebElement name = webDriver.findElement(By.xpath("//*[@id=\"confirmPersonPanel\"]/div/div/div[2]/div/input"));
        name.clear();
        name.sendKeys(nameKey);
        Thread.sleep(2000);

        getLogger().info("Position");
        WebElement position = webDriver.findElement(By.xpath("//*[@id=\"confirmPersonPanel\"]/div/div/div[4]/div/input"));
        position.clear();
        position.sendKeys(positionKey);
        Thread.sleep(2000);

        getLogger().info("Click Save");
        WebElement buttonSave = webDriver.findElement(By.xpath("//*[@id=\"main\"]/div[2]/div/div/div[1]/div[2]/button"));
        buttonSave.click();
        Thread.sleep(2000);

        getLogger().info("Scroll up");
        jse.executeScript("window.scrollBy(0,-800)", "");
        Thread.sleep(2000);

        getLogger().info("KBK detail");
        WebElement elementDetailKBK = webDriver.findElement(By.xpath("//*[@id=\"accordion7\"]/div[1]/h2"));
        elementDetailKBK.click();
        Thread.sleep(2000);
        WebElement changeKBK = webDriver.findElement(By.xpath("//*[@id=\"accordion7\"]/div[1]/button[1]"));
        changeKBK.click();
        Thread.sleep(2000);
        WebElement field2019 = webDriver.findElement(By.xpath("//*[@id=\"kbkDetailsGrid\"]/div[2]/table/tbody/tr/td[2]/span/span/input[1]"));
        field2019.sendKeys(sumKey);
        Thread.sleep(2000);

        getLogger().info("Save change");
        WebElement saveChange = webDriver.findElement(By.xpath("//*[@id=\"accordion7\"]/div[1]/button[1]"));
        saveChange.click();
        Thread.sleep(2000);
        WebElement saveChangeConfirmation = webDriver.findElement(By.xpath("/html/body/div[13]/div/div/div[3]/button[2]"));
        saveChangeConfirmation.click();
        Thread.sleep(2000);

        getLogger().info("Sending for approval");
        getLogger().info("Looking for action button");
        WebElement actionButton = webDriver.findElement(By.xpath("//*[@id=\"main\"]/div[2]/div/div/div[1]/div[2]/div/button"));
        actionButton.click();
        WebElement sendApprovButton = webDriver.findElement(By.xpath("//*[@id=\"main\"]/div[2]/div/div/div[1]/div[2]/div/ul/li[13]/a"));
        sendApprovButton.click();
        Thread.sleep(3000);
    }
}
