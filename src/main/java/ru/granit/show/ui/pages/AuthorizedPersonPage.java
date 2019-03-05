package ru.granit.show.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AuthorizedPersonPage extends BasePage{

    private String surnameKey = "Максимов";
    private String nameKey = "Максим";
    private String positionKey = "Ведущий специалист";

    public AuthorizedPersonPage(WebDriver driver) {super(driver, "Authorized person Page");}

    @Override
    public boolean isOpened(int timeout) {
        return false;
    }

    public void authorizedPersonMethod() throws InterruptedException {

        getLogger().getLogger().info("Authorized person: surname, name, position");
        WebElement buttonHead = getDriver().findElement(By.xpath("//*[@id=\"accordion8\"]/div[1]/h2"));
        buttonHead.click();
        Thread.sleep(2000);

        getLogger().getLogger().info("Surname");
        WebElement surname = getDriver().findElement(By.xpath("//*[@id=\"confirmPersonPanel\"]/div/div/div[1]/div/input"));
        surname.clear();
        surname.sendKeys(surnameKey);
        Thread.sleep(2000);

        getLogger().getLogger().info("Name");
        WebElement name = getDriver().findElement(By.xpath("//*[@id=\"confirmPersonPanel\"]/div/div/div[2]/div/input"));
        name.clear();
        name.sendKeys(nameKey);
        Thread.sleep(2000);

        getLogger().getLogger().info("Position");
        WebElement position = getDriver().findElement(By.xpath("//*[@id=\"confirmPersonPanel\"]/div/div/div[4]/div/input"));
        position.clear();
        position.sendKeys(positionKey);
        Thread.sleep(2000);
    }
}
