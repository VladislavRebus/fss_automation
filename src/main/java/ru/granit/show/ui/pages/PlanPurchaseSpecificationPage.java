package ru.granit.show.ui.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PlanPurchaseSpecificationPage extends BasePage {

    private static final By LOCATOR_TXT_SERIAL_NUMBER_FOR_IKZ = By.xpath("//div[contains(@class,'col') and " +
            "./label[text()='Порядковый номер для ИКЗ:']]/input");
    private static final By LOCATOR_TXT_YEAR_PLANNED_PLACEMENT = By.xpath(".//div[contains(@class, 'hold-select') and" +
            " .//*[@combo-value=\"planningYearBind\"]]//*[@role='button']");
    private static final By LOCATOR_TXT_INTRODUCE_JUSTIFICATION = By.xpath("//*[@id='to-purchase']");
    private static final By LOCATOR_TXT_SPECIFY_TIME_AND_FREQUENCY_DELIVERY = By.xpath("//textarea[@ng-model='entity.purchasePeriodDescription']");
    private static final By LOCATOR_TXT_INTRODUCE_NAME_OBJECT_PURCHASE = By.xpath("//input[@ng-model='entity.name']");
    private static final By LOCATOR_TXT_SUM_IN_SOURCE_FUNDING = By.xpath("//input[@style='display: inline-block;']");
    private static final By LOCATOR_SPECIFICATION_PAGE = By.xpath(".//div[contains(@class, 'main object')]");

    public PlanPurchaseSpecificationPage(WebDriver driver) {
        super(driver, "Страница позиции плана закупок");
    }

    @Override
    public boolean isOpened(int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), timeout);
            return wait.until(ExpectedConditions.visibilityOfElementLocated(LOCATOR_SPECIFICATION_PAGE)) != null;
        } catch (TimeoutException e) {
            getLogger().getLogger().debug(e);
            return false;
        }
    }

    public void savePlan() throws InterruptedException {
        getLogger().getLogger().info("Сохранить ПЛАН ЗАКУПОК");
        WebElement saveButton = getDriver().findElement(By.xpath("//button[@ng-click='save()']"));
        saveButton.click();
        Thread.sleep(2000);
    }

    public void closeAlert() throws InterruptedException {
        getLogger().getLogger().info("Закрыть предупреждение");
        WebElement closeButton = getDriver().findElement(By.xpath(".//div[@class='modal-footer ng-scope']//button[@ng-click='close()']"));
        closeButton.click();
        Thread.sleep(2000);
    }

    public void setSerialNumberIKZ(String serialNumberIKZ) throws InterruptedException {
        getLogger().getLogger().info("Ввести порядковый номер для ИКЗ - '" + serialNumberIKZ + "'");
        WebElement txt = getDriver().findElement(LOCATOR_TXT_SERIAL_NUMBER_FOR_IKZ);
        txt.sendKeys(serialNumberIKZ);
        Thread.sleep(2000);
    }

    public void setPlannedPlacementYear() throws InterruptedException {
        getLogger().getLogger().info("Выбрать планируемый год размещения : 2019 (6)");
        WebElement yearPlacement = getDriver().findElement(LOCATOR_TXT_YEAR_PLANNED_PLACEMENT);
        yearPlacement.click();
        Thread.sleep(2000);
        WebElement selection = getDriver().findElement(By.xpath("//ul[@role='listbox' and @aria-hidden='false']/li[text()='2019']"));
        selection.click();
    }

    public void setIntroduceJustificationObject(String justification) throws InterruptedException {
        getLogger().getLogger().info("Ввести обоснование соответствия объекта: " + justification);
        WebElement justificationObj = getDriver().findElement(LOCATOR_TXT_INTRODUCE_JUSTIFICATION);
        JavascriptExecutor jse = (JavascriptExecutor) getDriver();
        jse.executeScript("arguments[0].scrollIntoView(true);", justificationObj); //пробую использовать скролл1
        justificationObj.sendKeys(justification);
        Thread.sleep(2000);
    }

    public void setSpecifyTimeAndFrequencyDelivery(String time2) throws InterruptedException {
        getLogger().getLogger().info("Ввести срок и периодичность поставки: " + time2);
        WebElement checkBoxTime = getDriver().findElement(By.xpath("//*[@id=\"deliveryTerm\"]//input[contains(@ng-model,'isDelivery')]"));
        checkBoxTime.click();
        Thread.sleep(2000);
        WebElement otherwise = getDriver().findElement(LOCATOR_TXT_SPECIFY_TIME_AND_FREQUENCY_DELIVERY); //поле иное
        otherwise.sendKeys(time2);
        Thread.sleep(2000);
    }

    public void setIntroduceNameObjectPurchase(String nameObjectPurch) throws InterruptedException {
        getLogger().getLogger().info("Ввести наименование объекта или объектов закупки: " + nameObjectPurch);
        WebElement nameObjectPurchaseElement = getDriver().findElement(LOCATOR_TXT_INTRODUCE_NAME_OBJECT_PURCHASE);
        JavascriptExecutor jse = (JavascriptExecutor) getDriver();
        jse.executeScript("arguments[0].scrollIntoView(true);", nameObjectPurchaseElement); //пробую использовать скролл2
        jse.executeScript("window.scrollBy(0,50)", "");//поднял чуть выше, т.к. не видно элемента на экране
        nameObjectPurchaseElement.sendKeys(nameObjectPurch);
        Thread.sleep(2000);
    }

    public void addSourceFunding(String sum) throws InterruptedException {
        getLogger().getLogger().info("Добавить источник финансирования");
        WebElement sourceFundButton = getDriver().findElement(By.xpath("//button[text()='Добавить источник финансирования']"));
        sourceFundButton.click();
        Thread.sleep(2000);
        WebElement yearButton = getDriver().findElement(By.xpath(".//div[@class='modal-content']//*[@combo-value='kbkYear']//*[@role='button']"));
        yearButton.click();
        Thread.sleep(2000);
        WebElement year2019Button = getDriver().findElement(By.xpath("//ul[@role='listbox' and @aria-hidden='false']/li[text()='2019']"));
        year2019Button.click();
        Thread.sleep(2000);
        WebElement kbkButton = getDriver().findElement(By.xpath(".//div[@class='modal-content']" +
                "//*[@combo-display-field='internalCode' and @combo-value='kbkFixedValuesBind']//*[@role='button']"));
        kbkButton.click();
        Thread.sleep(2000);
        WebElement kbk149346Button = getDriver().findElement(By.xpath("//ul[@role='listbox' and @aria-hidden='false']/li[text()='393-0113-0370290059/1-149-346']"));
        kbk149346Button.click();
        Thread.sleep(2000);
        WebElement personalAccountButton = getDriver().findElement(By.xpath(".//div[@class='modal-content']//*[contains(@combo-value, 'entityForCreation')]//*[@role='button']")); //лицевой счет
        personalAccountButton.click();
        Thread.sleep(2000);
        WebElement account05604 = getDriver().findElement(By.xpath("//ul[@role='listbox' and @aria-hidden='false']/li[text()='05604С00020']")); //номер счета
        account05604.click();
        Thread.sleep(2000);
        WebElement sumElement = getDriver().findElement(LOCATOR_TXT_SUM_IN_SOURCE_FUNDING);
        sumElement.sendKeys(sum);
        Thread.sleep(2000);
    }

    public void saveSourceOfFundingButton() throws InterruptedException {
        getLogger().getLogger().info("Сохранить источник финансирования");
        WebElement buttonSave = getDriver().findElement(By.xpath("//button[@class='btn btn-primary blue']"));
        buttonSave.click();
        Thread.sleep(2000);
    }

    public void clickOnCreatePurchaseObjectButton2() throws InterruptedException {
        getLogger().getLogger().info("Нажать на 'Создать объект закупки' повторно");
        WebElement purchaseObjectCreateButton = getDriver().findElement(By.xpath("//button[text()='Создать объект закупки']"));
        purchaseObjectCreateButton.click();
        Thread.sleep(2000);
        WebElement potrIzReestraButton = getDriver().findElement(By.xpath("//div[1]/div[contains(@class, 'indent')]//button[contains(@class, 'ng-scope')]"));
        potrIzReestraButton.click();
        Thread.sleep(2000);
        WebElement objFromRegistry701 = getDriver().findElement(By.xpath("//*[@id='tsrNeedsGrid']//tr[@class='ng-scope']//td[@role='gridcell']//span[text()='6-01-01']"));
        objFromRegistry701.click();
        Thread.sleep(2000);
        WebElement choiceButton = getDriver().findElement(By.xpath("//button[@ng-click='select()']"));//кнопка выбор
        choiceButton.click();
        Thread.sleep(2000);
        WebElement typeOrderButton = getDriver().findElement(By.xpath(".//div[@class='modal-content']//*[@combo-value='entity.purchaseTypeId']//*[@role='button']"));//тип заказа
        typeOrderButton.click();
        Thread.sleep(2000);
        WebElement productButton = getDriver().findElement(By.xpath("//ul[@role='listbox' and @aria-hidden='false']/li[text()='Товары']")); //товар
        productButton.click();
    }

    public void savePlannedPurchaseObjectButton() throws InterruptedException {
        getLogger().getLogger().info("Сохранить планируемый объект закупки");
        WebElement buttonSave = getDriver().findElement(By.xpath("//button[@class='btn btn-primary ng-scope']"));
        buttonSave.click();
        Thread.sleep(2000);
    }

    public void setSubstantiationOfficer() throws InterruptedException {
        getLogger().getLogger().info("Ввести ответственных лиц. Ответственный за формирование обоснования");
        WebElement elementSubstOfficersButton = getDriver().findElement(By.xpath("//div[@id='accordion7']//span[@class='fa fa-angle-down']"));
        JavascriptExecutor jse = (JavascriptExecutor) getDriver();
        jse.executeScript("arguments[0].scrollIntoView(true);", elementSubstOfficersButton); //пробую использовать скролл3
        elementSubstOfficersButton.click();
        Thread.sleep(2000);
        WebElement addSubstOfficerButton = getDriver().findElement(By.xpath("//tr[1]//button[contains(@ng-click,'addResponsiblePerson')]"));
        addSubstOfficerButton.click();
        Thread.sleep(2000);
        WebElement buttonResponsPerson = getDriver().findElement(By.xpath("//button[@ng-if='findVisible()']"));
        buttonResponsPerson.click();
        Thread.sleep(2000);
        WebElement responsiblePerson = getDriver().findElement(By.xpath("//*[@id='responsiblePersonDialogGrid']//span[text()='Семенов Егор Иванович']"));
        responsiblePerson.click();
        Thread.sleep(2000);
        WebElement buttonChoice2 = getDriver().findElement(By.xpath("//button[@ng-click='select()']"));
        buttonChoice2.click();
        Thread.sleep(2000);
        WebElement saveChoice = getDriver().findElement(By.xpath("//button[@ng-click='ok()']"));
        saveChoice.click();
        Thread.sleep(2000);
    }

    public void setProcurementOfficer() throws InterruptedException {
        getLogger().getLogger().info("Ввести ответственных лиц. Ответственный за проведение закупки");
        WebElement buttonAddProcurementOfficer = getDriver().findElement(By.xpath("//tr[2]//button[contains(@ng-click,'addResponsiblePerson')]"));
        buttonAddProcurementOfficer.click();
        Thread.sleep(2000);
        WebElement buttonResponsPerson2 = getDriver().findElement(By.xpath("//button[@ng-if='findVisible()' and @ng-click='find()']"));
        buttonResponsPerson2.click();
        Thread.sleep(2000);
        WebElement responsiblePerson2 = getDriver().findElement(By.xpath("//*[@id='responsiblePersonDialogGrid']//span[text()='Семенов Егор Иванович']"));
        responsiblePerson2.click();
        Thread.sleep(2000);
        WebElement buttonChoice3 = getDriver().findElement(By.xpath("//button[@ng-click='select()']"));
        buttonChoice3.click();
        Thread.sleep(2000);
        WebElement saveChoice2 = getDriver().findElement(By.xpath("//button[@ng-click='ok()']"));
        saveChoice2.click();
        Thread.sleep(3000);
    }

    public void clickButtonAction() {
        getLogger().getLogger().info("Нажать на кнопку 'Действие'");
        WebElement button = getDriver().findElement(By.xpath("//button[@type='button' and starts-with(.,'Действие')]"));
        button.click();
    }

    public void clickButtonReadinessConfirmation() throws InterruptedException {
        getLogger().getLogger().info("Выбрать пункт 'Подтверждение готовности'");
        WebElement buttonReadinessConfirm = getDriver().findElement(By.xpath("//a[@ng-show='canPrepare()']"));
        buttonReadinessConfirm.click();
        WebElement ReadinessConfirmation = getDriver().findElement(By.xpath("//button[@ng-click='btn2Click()']"));
        ReadinessConfirmation.click();
        Thread.sleep(3000);
    }

}
