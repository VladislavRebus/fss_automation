package ru.granit.show.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DetailKbkPage extends BasePage{

    private String sumKey = "75000000";

    public DetailKbkPage(WebDriver driver) {super(driver, "Detail KBK Page");}

    @Override
    public boolean isOpened(int timeout) {
        return false;
    }

    public void detailKbkMethod() throws InterruptedException {

        getLogger().getLogger().info("Detailing KBK");
        WebElement elementDetailKBK = getDriver().findElement(By.xpath("//*[@id=\"accordion7\"]/div[1]/h2"));
        elementDetailKBK.click();
        Thread.sleep(2000);
        WebElement changeKBK = getDriver().findElement(By.xpath("//*[@id=\"accordion7\"]/div[1]/button[1]"));
        changeKBK.click();
        Thread.sleep(2000);
        WebElement field2019 = getDriver().findElement(By.xpath("//*[@id=\"kbkDetailsGrid\"]/div[2]/table/tbody/tr/td[2]/span/span/input[1]"));
        field2019.sendKeys(sumKey);
        Thread.sleep(2000);
    }
}
