package ru.granit.show;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VygruzXML extends BaseTest {
    @Test
    public void openTest() throws InterruptedException {
        //вход
        String login = "saratovsch";
        String password = "SHETKO1990";
        String reestrNumber = "000060-19";
        WebElement elementLog = webDriver.findElement(By.id("loginTxt"));
        elementLog.sendKeys(login);
        WebElement elementPass = webDriver.findElement(By.id("passwordTxt"));
        elementPass.sendKeys(password);
        WebElement elementButtonEnter = webDriver.findElement(By.className("send-data"));
        elementButtonEnter.click();
        Thread.sleep(2000);

        //проверим номер плана закупок
        WebElement elementNumberPlan = webDriver.findElement(By.xpath("//*[@id=\"mainDataPanel\"]/div/form/fieldset/div[6]/div[1]/input"));
        Assert.assertEquals(elementNumberPlan.getAttribute("value"), reestrNumber);
        Thread.sleep(2000);

        //ищем кнопку действие
        WebElement deystvieButton = webDriver.findElement(By.xpath("//*[@id=\"main\"]/div[2]/div/div/div[1]/div[2]/div/button"));
        deystvieButton.click();

        //выбираем выгрузить XML в ЕИС
        WebElement vigruzXMLvEIC = webDriver.findElement(By.xpath("//*[@id=\"main\"]/div[2]/div/div/div[1]/div[2]/div/ul/li[16]/a"));
        vigruzXMLvEIC.click();
        Thread.sleep(3000);
    }
}
