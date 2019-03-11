package ru.granit.show.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PlanPurchasePage extends BasePage {

    private static final By LOCATOR_TXT_REGISTRY_PLAN_PURCHASE_NUMBER = By.xpath("//div[contains(@class,'col') and " +
            "./label[text()='Реестровый номер плана закупок:']]/input");
    private static final By LOCATOR_TXT_SERIAL_NUMBER_FOR_IKZ = By.xpath("//div[contains(@class,'col') and " +
            "./label[text()='Порядковый номер для ИКЗ:']]/input");

    public PlanPurchasePage(WebDriver driver) {
        super(driver, "Страница плана закупок");
    }

    @Override
    public boolean isOpened(int timeout) {
        return false;
    }

    public String getRegistryPlanPurchaseNumber() {
        WebElement registryPlanPurchaseNumberTxt = getDriver().findElement(LOCATOR_TXT_REGISTRY_PLAN_PURCHASE_NUMBER);
        return registryPlanPurchaseNumberTxt.getAttribute("value");
    }

    public void clickOnCreatePurchaseObjectButton() throws InterruptedException {
        getLogger().getLogger().info("Нажать на 'Создать объект закупки'");
        WebElement createPurchaseObjectButton = getDriver().findElement(By.xpath(".//button[@ng-click='createSpecification()']"));
        createPurchaseObjectButton.click();
        Thread.sleep(2000);
    }

    public void savePlan() throws InterruptedException {
        getLogger().getLogger().info("Сохранить ПЛАН ЗАКУПОК");
        WebElement saveButton = getDriver().findElement(By.xpath("//button[@ng-click='save()']"));
        saveButton.click();
        Thread.sleep(2000);
    }

    public void closeAlert() throws InterruptedException {
        getLogger().getLogger().info("Закрыть предупреждение");
        WebElement closeButton = getDriver().findElement(By.xpath("/html/body/div[21]/div/div/div[3]/button"));
        closeButton.click();
        Thread.sleep(2000);
    }

    public void setSerialNumberIKZ(String serialNumberIKZ) {
        getLogger().getLogger().info("Ввести Порядковый номер для ИКЗ - '" + serialNumberIKZ + "'");
        WebElement txt = getDriver().findElement(LOCATOR_TXT_SERIAL_NUMBER_FOR_IKZ);
        txt.sendKeys(serialNumberIKZ);
    }
}
