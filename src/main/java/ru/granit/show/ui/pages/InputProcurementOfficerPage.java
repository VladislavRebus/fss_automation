package ru.granit.show.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InputProcurementOfficerPage extends BasePage {

    public InputProcurementOfficerPage(WebDriver driver) {
        super(driver, "Input of responsible persons. Procurement officer Page");
    }

    @Override
    public boolean isOpened(int timeout) {
        return false;
    }

    public void inputProcurementOfficerMethod() throws InterruptedException {

        getLogger().getLogger().info("Input of responsible persons. Procurement officer");//введем ответственных лиц //ответств.за пров.закуп.
        WebElement buttonAddProcurOfficer = getDriver().findElement(By.xpath("//*[@id=\"responsiblePersonGrid\"]/div[2]/table/tbody/tr[2]/td[4]/div/button"));
        buttonAddProcurOfficer.click();
        Thread.sleep(2000);
        WebElement buttonResponsPerson2 = getDriver().findElement(By.xpath("/html/body/div[31]/div/div/div/div[2]/form/fieldset/div[2]/div[2]/core-link/div/div[1]/div/button"));
        buttonResponsPerson2.click();
        Thread.sleep(2000);
        WebElement responsiblePerson2 = getDriver().findElement(By.xpath("//*[@id=\"responsiblePersonDialogGrid\"]/div[2]/table/tbody/tr/td[1]"));
        responsiblePerson2.click();
        Thread.sleep(2000);
        WebElement buttonChoice3 = getDriver().findElement(By.xpath("/html/body/div[33]/div/div/div/div[4]/button[2]"));
        buttonChoice3.click();
        Thread.sleep(2000);
        WebElement saveChoice2 = getDriver().findElement(By.xpath("/html/body/div[31]/div/div/div/div[2]/form/fieldset/div[4]/div/button[1]"));
        saveChoice2.click();
        Thread.sleep(2000);
    }
}
