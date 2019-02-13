package ru.granit.show;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SoglasovPZ {
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
        String famylyaKey = "Максимов";
        String imyaKey = "Максим";
        String doljnostKey = "Ведущий специалист";
        String sum = "75000000";
        WebElement elementLog = webDriver.findElement(By.id("loginTxt"));
        elementLog.sendKeys(login);
        WebElement elementPass = webDriver.findElement(By.id("passwordTxt"));
        elementPass.sendKeys(password);
        WebElement elementButtonEnter = webDriver.findElement(By.className("send-data"));
        elementButtonEnter.click();
        Thread.sleep(6000);

         //закрытие оповещения
        WebElement opoveshenie = webDriver.findElement(By.xpath("/html/body/div[13]/div/div/div[3]/div/div[1]/div"));
        opoveshenie.click();
       Thread.sleep(2000);

        //проверим номер плана закупок
        WebElement elementNumberPlan = webDriver.findElement(By.xpath("//*[@id=\"mainDataPanel\"]/div/form/fieldset/div[6]/div[1]/input"));
        Assert.assertEquals(elementNumberPlan.getAttribute("value"), reestrNumber);
        Thread.sleep(2000);

        //скролим ниже
        JavascriptExecutor jse = (JavascriptExecutor) webDriver;
        jse.executeScript("window.scrollBy(0,900)", "");
        Thread.sleep(2000);

        //ввод ФИО ответственного.
        WebElement buttonrukovod = webDriver.findElement(By.xpath("//*[@id=\"accordion8\"]/div[1]/h2"));
        buttonrukovod.click();
        Thread.sleep(2000);

        WebElement familiya = webDriver.findElement(By.xpath("//*[@id=\"confirmPersonPanel\"]/div/div/div[1]/div/input"));
        familiya.clear();
        familiya.sendKeys(famylyaKey);
        Thread.sleep(2000);

        WebElement imya = webDriver.findElement(By.xpath("//*[@id=\"confirmPersonPanel\"]/div/div/div[2]/div/input"));
        imya.clear();
        imya.sendKeys(imyaKey);
        Thread.sleep(2000);

        WebElement doljnost = webDriver.findElement(By.xpath("//*[@id=\"confirmPersonPanel\"]/div/div/div[4]/div/input"));
        doljnost.clear();
        doljnost.sendKeys(doljnostKey);
        Thread.sleep(2000);

        //Пробуем сохранить
        WebElement buttonSave = webDriver.findElement(By.xpath("//*[@id=\"main\"]/div[2]/div/div/div[1]/div[2]/button"));
        buttonSave.click();
        Thread.sleep(2000);

        //скролим вверх
        jse.executeScript("window.scrollBy(0,-800)", "");
        Thread.sleep(2000);

        //детализация кбк
        WebElement elementDetalKBK = webDriver.findElement(By.xpath("//*[@id=\"accordion7\"]/div[1]/h2"));
        elementDetalKBK.click();
        Thread.sleep(2000);
        WebElement changeKBK = webDriver.findElement(By.xpath("//*[@id=\"accordion7\"]/div[1]/button[1]"));
        changeKBK.click();
        Thread.sleep(2000);
        WebElement pole2019 = webDriver.findElement(By.xpath("//*[@id=\"kbkDetailsGrid\"]/div[2]/table/tbody/tr/td[2]/span/span/input[1]"));
        pole2019.sendKeys(sum);
        Thread.sleep(2000);

        WebElement saveChange = webDriver.findElement(By.xpath("//*[@id=\"accordion7\"]/div[1]/button[1]"));
        saveChange.click();
        Thread.sleep(2000);
        WebElement saveChangePodtverj = webDriver.findElement(By.xpath("/html/body/div[13]/div/div/div[3]/button[2]"));
        saveChangePodtverj.click();
        Thread.sleep(2000);

        //действие, отправка на согласование
        WebElement buttonDo = webDriver.findElement(By.xpath("//*[@id=\"main\"]/div[2]/div/div/div[1]/div[2]/div/button"));
        buttonDo.click();
        Thread.sleep(2000);
        WebElement otpravkaNaSoglasov = webDriver.findElement(By.xpath("//*[@id=\"main\"]/div[2]/div/div/div[1]/div[2]/div/ul/li[13]/a"));
        otpravkaNaSoglasov.click();
        Thread.sleep(2000);





    }
}
