package ru.granit.show;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VygruzPechFormPZ {
    WebDriver webDriver;

    public void predTest() {                 //не могу сослаться на BaseTest и он не импортируется
        BaseTest baseTest = new BaseTest();
    }
/*    @BeforeClass
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
*/
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

        //Выбираем- Печатная форма 552ПП Pdf
        WebElement forma552ppPDF = webDriver.findElement(By.xpath("//*[@id=\"main\"]/div[2]/div/div/div[1]/div[2]/div/ul/li[5]/a"));
        forma552ppPDF.click();

        deystvieButton.click();
        //Выбираем- Печатная форма 552ПП Excel
        WebElement forma552ppExcel = webDriver.findElement(By.xpath("//*[@id=\"main\"]/div[2]/div/div/div[1]/div[2]/div/ul/li[6]/a"));
        forma552ppExcel.click();

        deystvieButton.click();
        //Выбираем- Печатная форма 552ПП (КОСГУ) Pdf
        WebElement forma552ppKOSGUPDF = webDriver.findElement(By.xpath("//*[@id=\"main\"]/div[2]/div/div/div[1]/div[2]/div/ul/li[7]/a"));
        forma552ppKOSGUPDF.click();

        deystvieButton.click();
        //Выбираем- Печатная форма 552ПП (КОСГУ) Excel
        WebElement forma552ppKOSGUExcel = webDriver.findElement(By.xpath("//*[@id=\"main\"]/div[2]/div/div/div[1]/div[2]/div/ul/li[8]/a"));
        forma552ppKOSGUExcel.click();

        deystvieButton.click();
        //Выбираем- Сформировать обоснование по 555 ПП Pdf
        WebElement formirObocnov555ppPDF = webDriver.findElement(By.xpath("//*[@id=\"main\"]/div[2]/div/div/div[1]/div[2]/div/ul/li[9]/a"));
        formirObocnov555ppPDF.click();

        deystvieButton.click();
        //Выбираем- Сформировать обоснование по 555 ПП Excel
        WebElement formirObocnov555ppExcel = webDriver.findElement(By.xpath("//*[@id=\"main\"]/div[2]/div/div/div[1]/div[2]/div/ul/li[10]/a"));
        formirObocnov555ppExcel.click();

        //далее остается в ручную подтвердить скачивание и все. документы загрузятся в ту папку для загрузок,
        // которую выбрали ранее(либо в папку по умолчанию GoogleGhrome).

    }
}
