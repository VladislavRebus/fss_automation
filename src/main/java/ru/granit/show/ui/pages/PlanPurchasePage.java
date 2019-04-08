package ru.granit.show.ui.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PlanPurchasePage extends BasePage {

    private static final By LOCATOR_TXT_REGISTRY_PLAN_PURCHASE_NUMBER = By.xpath("//div[contains(@class,'col') and " +
            "./label[text()='Реестровый номер плана закупок:']]/input");
    private static final By LOCATOR_TXT_AUTHORIZED_PERSON_SURNAME = By.xpath("//input[@ng-model='entity.confirmLastName']");
    private static final By LOCATOR_TXT_AUTHORIZED_PERSON_NAME = By.xpath("//input[@ng-model='entity.confirmFirstName']");
    private static final By LOCATOR_TXT_AUTHORIZED_PERSON_POSITION = By.xpath("//input[@ng-model='entity.confirmPosition']");
    private static final By LOCATOR_TXT_SUMKEY_FIELD_DETAIL_KBK = By.xpath("//*[2]/span[1]/span[1]/input[@type='text' and @tabindex='0']");
    private static final By LOCATOR_PAGE = By.xpath(".//div[contains(@class, 'purchaseView')]");

    public PlanPurchasePage(WebDriver driver) {
        super(driver, "Страница плана закупок");
    }

    @Override
    public boolean isOpened(int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), timeout);
            return wait.until(ExpectedConditions.visibilityOfElementLocated(LOCATOR_PAGE)) != null;
        } catch (TimeoutException e) {
            getLogger().getLogger().debug(e);
            return false;
        }
    }

    public String getRegistryPlanPurchaseNumber() {
        WebElement registryPlanPurchaseNumberTxt = getDriver().findElement(LOCATOR_TXT_REGISTRY_PLAN_PURCHASE_NUMBER);
        return registryPlanPurchaseNumberTxt.getAttribute("value");
    }

    public void clickButtonOnCreatePurchaseObject() throws InterruptedException {
        getLogger().getLogger().info("Нажать на 'Создать объект закупки'");
        WebElement createButtonPurchaseObject = getDriver().findElement(By.xpath("//button[text()='Создать объект закупки']"));
        createButtonPurchaseObject.click();
        Thread.sleep(2000);
    }

    public void savePlan() throws InterruptedException {
        getLogger().getLogger().info("Сохранить ПЛАН ЗАКУПОК");
        WebElement saveButton = getDriver().findElement(By.xpath("//button[@ng-click='save()']"));
        saveButton.click();
        Thread.sleep(2000);
    }

    public void clickButtonAction() {
        getLogger().getLogger().info("Нажать на кнопку 'Действие'");
        WebElement button = getDriver().findElement(By.xpath("//button[@type='button' and starts-with(.,'Действие')]"));
        button.click();
    }

    public void setAuthorizedPerson(String surnameKey, String nameKey, String positionKey) throws InterruptedException {
        getLogger().getLogger().info("Ввести уполномоченное лицо: Фамилия, Имя, должность" + surnameKey + nameKey + positionKey);
        WebElement buttonHead = getDriver().findElement(By.xpath("//div[@id='accordion8']//span[@class='fa fa-angle-down']"));
        JavascriptExecutor jse = (JavascriptExecutor) getDriver();
        jse.executeScript("arguments[0].scrollIntoView(true);",buttonHead);
        buttonHead.click();
        Thread.sleep(2000);

        getLogger().getLogger().info("Фамилия");
        WebElement surname = getDriver().findElement(LOCATOR_TXT_AUTHORIZED_PERSON_SURNAME);
        surname.clear();
        surname.sendKeys(surnameKey);
        Thread.sleep(2000);

        getLogger().getLogger().info("Имя");
        WebElement name = getDriver().findElement(LOCATOR_TXT_AUTHORIZED_PERSON_NAME);
        name.clear();
        name.sendKeys(nameKey);
        Thread.sleep(2000);

        getLogger().getLogger().info("Должность");
        WebElement position = getDriver().findElement(LOCATOR_TXT_AUTHORIZED_PERSON_POSITION);
        position.clear();
        position.sendKeys(positionKey);
        Thread.sleep(2000);
    }

    public void closeMessage() throws InterruptedException {
        getLogger().getLogger().info("Закрыть сообщение"); //*[@class='btn btn-default btn-message-read ng-binding']
        WebElement button = getDriver().findElement(By.xpath("//div[contains(@ng-click,'toggleIsReaded')]"));
        button.click();
        Thread.sleep(2000);
    }

    public void setDetailKbk(String sumKey) throws InterruptedException {
        getLogger().getLogger().info("Ввести детализацию КБК" + sumKey);
        WebElement elementDetailKBK = getDriver().findElement(By.xpath("//div[@id='accordion7']//span[@class='fa fa-angle-down']"));
        JavascriptExecutor jse = (JavascriptExecutor) getDriver();
        jse.executeScript("window.scrollBy(0,-300)", "");
        elementDetailKBK.click();
        Thread.sleep(2000);
        WebElement changeKBK = getDriver().findElement(By.xpath("//button[@ng-click='changeKbkDetails($event)']"));
        changeKBK.click();
        Thread.sleep(2000);
        WebElement field2019 = getDriver().findElement(LOCATOR_TXT_SUMKEY_FIELD_DETAIL_KBK);
        field2019.sendKeys(sumKey);
        Thread.sleep(2000);
    }

    public void clickSendingForApproval() throws InterruptedException {
        getLogger().getLogger().info("Отправить на утверждение");
        WebElement sendApprovButton = getDriver().findElement(By.xpath("//a[contains(@ng-click, 'sendForApproval')]"));
        sendApprovButton.click();
        Thread.sleep(3000);
    }

    public void clickLoadingForm(int number) {
        getLogger().getLogger().info("Выбрать форму под номером:" + number);
        WebElement form = getDriver().findElement(By.xpath("//*[@id=\"main\"]/div[2]/div/div/div[1]/div[2]/div/ul/li[" + number + "]/a"));
        form.click();
    }

    public void clickTypePurchase() throws InterruptedException {
        getLogger().getLogger().info("Выбрать тип закупки");
        WebElement tipZak = getDriver().findElement(By.xpath("//div[1]/div[1]/core-combo[1]//div[1]//span[1 and @unselectable='on']//span[@role='button']"));
        Thread.sleep(2000);
        tipZak.click();
        WebElement vybor2 = getDriver().findElement(By.xpath("/html/body/div[30]/div/ul/li[5]"));
        vybor2.click();
        Thread.sleep(1000);
    }

    public void saveChangeButton() throws InterruptedException {
        getLogger().getLogger().info("Сохранить изменения");
        WebElement saveChange = getDriver().findElement(By.xpath("//button[contains(@ng-click,'saveKbkDetails')]"));
        saveChange.click();
        Thread.sleep(2000);
    }

    public void saveChangeConfirmationButton() throws InterruptedException {
        getLogger().getLogger().info("Подтвердить сохранение изменений");
        WebElement saveChangeConfirmation = getDriver().findElement(By.xpath("//button[@ng-click='btn2Click()']"));
        saveChangeConfirmation.click();
        Thread.sleep(2000);
    }
}
