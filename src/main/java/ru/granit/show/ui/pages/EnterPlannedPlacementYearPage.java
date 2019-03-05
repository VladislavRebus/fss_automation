package ru.granit.show.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EnterPlannedPlacementYearPage extends BasePage {

    private String year = "2019";

    public EnterPlannedPlacementYearPage(WebDriver driver) {
        super(driver, "Enter planned placement year Page");
    }

    @Override
    public boolean isOpened(int timeout) {
        return false;
    }

    public void enterPlannedPlacementYearMethod() throws InterruptedException {

        getLogger().getLogger().info("Enter the planned placement year (6)");
        WebElement yearPlacement = getDriver().findElement(By.xpath("//*[@id=\"mainDataPanel\"]/div/form/fieldset/div[7]/div[2]/div/core-combo/div/div/span/span/input"));
        yearPlacement.sendKeys(year);
        Thread.sleep(2000);
        WebElement selection = getDriver().findElement(By.xpath("/html/body/div[12]/div/ul/li[1]"));
        selection.click();
    }
}
