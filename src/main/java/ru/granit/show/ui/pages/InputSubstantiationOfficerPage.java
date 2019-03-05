package ru.granit.show.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InputSubstantiationOfficerPage extends BasePage {

    public InputSubstantiationOfficerPage(WebDriver driver) {
        super(driver, "Input of responsible persons. Substantiation officer Page");
    }

    @Override
    public boolean isOpened(int timeout) {
        return false;
    }

    public void inputSubstantiationOfficerMethod() throws InterruptedException {

        getLogger().getLogger().info("Input of responsible persons. Substantiation officer");//введем ответственных лиц //отв за формир.обоснования.
        WebElement elementButtonSubstOfficers = getDriver().findElement(By.xpath("//*[@id=\"accordion7\"]/div/div[1]/h2"));
        elementButtonSubstOfficers.click();
        Thread.sleep(2000);
        WebElement buttonAddSubstOfficer = getDriver().findElement(By.xpath("//*[@id=\"responsiblePersonGrid\"]/div[2]/table/tbody/tr[1]/td[4]/div/button"));
        buttonAddSubstOfficer.click();
        Thread.sleep(2000);
        WebElement buttonResponsPerson = getDriver().findElement(By.xpath("/html/body/div[30]/div/div/div/div[2]/form/fieldset/div[2]/div[2]/core-link/div/div[1]/div/button"));
        buttonResponsPerson.click();
        Thread.sleep(2000);
        WebElement responsiblePerson = getDriver().findElement(By.xpath("//*[@id=\"responsiblePersonDialogGrid\"]/div[2]/table/tbody/tr/td[1]"));
        responsiblePerson.click();
        Thread.sleep(2000);
        WebElement buttonChoice2 = getDriver().findElement(By.xpath("/html/body/div[32]/div/div/div/div[4]/button[2]"));
        buttonChoice2.click();
        Thread.sleep(2000);
        WebElement saveChoice = getDriver().findElement(By.xpath("/html/body/div[30]/div/div/div/div[2]/form/fieldset/div[4]/div/button[1]"));
        saveChoice.click();
        Thread.sleep(2000);
    }
}
