package ru.granit.show.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddSourceFundingPage extends BasePage {

    private String sum = "75000000";

    public AddSourceFundingPage(WebDriver driver) {
        super(driver, "Add a source of funding Page");
    }

    @Override
    public boolean isOpened(int timeout) {
        return false;
    }

    public void AddSourceFundingMethod() throws InterruptedException {

        getLogger().getLogger().info("Add a source of funding (16)");//Добавим источник финансирования (16)
        WebElement sourceFundButton = getDriver().findElement(By.xpath("//*[@id=\"accordion2\"]/div/div[2]/button"));
        sourceFundButton.click();
        Thread.sleep(2000);
        WebElement buttonYear = getDriver().findElement(By.xpath("/html/body/div[21]/div/div/div[2]/div[2]/form/div[1]/div[1]/div/div/core-combo/div/div/span/span/span"));
        buttonYear.click();
        Thread.sleep(2000);
        WebElement year2019Button = getDriver().findElement(By.xpath("/html/body/div[22]/div/ul/li[1]"));
        year2019Button.click();
        Thread.sleep(2000);
        WebElement buttonKbk = getDriver().findElement(By.xpath("/html/body/div[21]/div/div/div[2]/div[2]/form/div[1]/div[2]/div[3]/core-combo/div/div/span/span/span"));
        buttonKbk.click();
        Thread.sleep(2000);
        WebElement kbk149346Button = getDriver().findElement(By.xpath("/html/body/div[24]/div/ul/li[1]"));
        kbk149346Button.click();
        Thread.sleep(2000);
        WebElement buttonPersonalAccount = getDriver().findElement(By.xpath("/html/body/div[21]/div/div/div[2]/div[2]/form/div[3]/div[2]/div/core-combo/div/div/span/span/span")); //лицевой счет
        buttonPersonalAccount.click();
        Thread.sleep(2000);
        WebElement account05604 = getDriver().findElement(By.xpath("/html/body/div[25]/div/ul/li[1]")); //номер счета
        account05604.click();
        Thread.sleep(2000);
        WebElement sumElement = getDriver().findElement(By.xpath("/html/body/div[21]/div/div/div[2]/div[2]/form/div[4]/div[2]/span/span/input[1]"));
        sumElement.sendKeys(sum);
        Thread.sleep(2000);
    }
}
