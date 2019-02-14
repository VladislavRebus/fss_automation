package ru.granit.show;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    WebDriver webDriver;

    @BeforeSuite
    public void initializationDriver() {
        System.out.println("Тестируем в Google Chrome");
        System.setProperty("webdriver.chrome.driver", "D:\\WorkAutomation\\FondSocStrahovaniya\\src\\main\\resources\\chromedriver.exe");
        webDriver = new ChromeDriver();
    }

    @BeforeSuite
    public void openAdress() {
        webDriver.manage().window().maximize();
        webDriver.get("http://show.granit.ru/test/fss/#/PlanPurchase?id=1118414");
    }

    @AfterSuite
    public void closeDriver() {
        webDriver.quit();
    }
}
