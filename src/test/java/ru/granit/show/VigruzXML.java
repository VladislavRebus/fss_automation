package ru.granit.show;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VigruzXML {
    WebDriver webDriver;

    @BeforeClass
    public void initializationDriver() {
        System.out.println("Тестируем в Google Chrome");
        System.setProperty("webdriver.chrome.driver", "D:\\WorkAutomation\\FondSocStrahovaniya\\src\\main\\resources\\chromedriver.exe");
        webDriver = new ChromeDriver();
    }

    @BeforeMethod
    public void openAdress() {
        webDriver.manage().window().maximize();
        webDriver.get("http://show.granit.ru/test/fss/#/PlanPurchase?id=1118414");
    }

    @Test
    public void openPPZ() throws InterruptedException {

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

        //далее остается в ручную подтвердить скачивание и все. документ загрузится в ту папку для загрузок,
        // которую выбрали ранее(либо в папку по умолчанию GoogleGhrome).

    }
}
