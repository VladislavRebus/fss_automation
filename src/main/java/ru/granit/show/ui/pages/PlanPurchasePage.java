package ru.granit.show.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PlanPurchasePage extends BasePage {

    private static final By LOCATOR_TXT_REGISTRY_PLAN_PURCHASE_NUMBER = By.xpath("//div[contains(@class,'col') and " +
            "./label[text()='Реестровый номер плана закупок:']]/input");
    private static final By LOCATOR_TXT_SERIAL_NUMBER_FOR_IKZ = By.xpath("//div[contains(@class,'col') and " +
            "./label[text()='Порядковый номер для ИКЗ:']]/input");
    private static final By LOCATOR_TXT_YEAR_PLANNED_PLACEMENT = By.xpath(".//span[contains(@class,'dropdown')]//span[@class='k-select']");
    private static final By LOCATOR_TXT_INTRODUCE_JUSTIFICATION = By.xpath("//*[@id=\"to-purchase\"]");
    private static final By LOCATOR_TXT_SPECIFY_TIME_AND_FREQUENCY_DELIVERY = By.xpath("//textarea[@ng-model='entity.purchasePeriodDescription']");
    private static final By LOCATOR_TXT_INTRODUCE_NAME_OBJECT_PURCHASE = By.xpath("//input[@ng-model='entity.name']");
    private static final By LOCATOR_TXT_SUM_IN_SOURCE_FUNDING = By.xpath("//input[@style='display: inline-block;']");
    private static final By LOCATOR_TXT_AUTHORIZED_PERSON_SURNAME = By.xpath("//*[@id=\"confirmPersonPanel\"]/div/div/" +
            "div[1]/div/input");
    private static final By LOCATOR_TXT_AUTHORIZED_PERSON_NAME = By.xpath("//*[@id=\"confirmPersonPanel\"]/div/div/" +
            "div[2]/div/input");
    private static final By LOCATOR_TXT_AUTHORIZED_PERSON_POSITION = By.xpath("//*[@id=\"confirmPersonPanel\"]/div/div/" +
            "div[4]/div/input");
    private static final By LOCATOR_TXT_SUMKEY_FIELD_DETAIL_KBK = By.xpath("//*[@id=\"kbkDetailsGrid\"]/div[2]/table/" +
            "tbody/tr/td[2]/span/span/input[1]");

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

    public void clickButtonOnCreatePurchaseObject() throws InterruptedException {
        getLogger().getLogger().info("Нажать на 'Создать объект закупки'");
        WebElement createButtonPurchaseObject = getDriver().findElement(By.xpath(".//button[@ng-click='createSpecification()']"));
        createButtonPurchaseObject.click();
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
        WebElement closeButton = getDriver().findElement(By.xpath(".//div[@class='modal-footer ng-scope']//button[@ng-click='close()']"));
        closeButton.click();
        Thread.sleep(2000);
    }

    public void setSerialNumberIKZ(String serialNumberIKZ) {
        getLogger().getLogger().info("Ввести порядковый номер для ИКЗ - '" + serialNumberIKZ + "'");
        WebElement txt = getDriver().findElement(LOCATOR_TXT_SERIAL_NUMBER_FOR_IKZ);
        txt.sendKeys(serialNumberIKZ);
    }

    public void setPlannedPlacementYear() throws InterruptedException {
        getLogger().getLogger().info("Выбрать планируемый год размещения : 2019 (6)");
        WebElement yearPlacement = getDriver().findElement(LOCATOR_TXT_YEAR_PLANNED_PLACEMENT);
        yearPlacement.click();
        Thread.sleep(1000);
        WebElement selection = getDriver().findElement(By.xpath("/html/body/div[12]/div/ul/li[1]")); //--этот не придумал как переписать красивее|||||||||||||||||||||
        selection.click();
    }

    public void setIntroduceJustificationObject(String justification) throws InterruptedException {
        getLogger().getLogger().info("Ввести обоснование соответствия объекта: " + justification);//(12)
        WebElement justificationObj = getDriver().findElement(LOCATOR_TXT_INTRODUCE_JUSTIFICATION);
        justificationObj.sendKeys(justification);
        Thread.sleep(2000);
    }

    public void setSpecifyTimeAndFrequencyDelivery(String time2) throws InterruptedException {
        getLogger().getLogger().info("Ввести срок и периодичность поставки: " + time2);//(14)
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
        nameObjectPurchaseElement.sendKeys(nameObjectPurch);
        Thread.sleep(2000);
    }

    public void addSourceFunding(String sum) throws InterruptedException {
        getLogger().getLogger().info("Добавить источник финансирования (16)");
        WebElement sourceFundButton = getDriver().findElement(By.xpath("//button[text()='Добавить источник финансирования']"));
        sourceFundButton.click();
        Thread.sleep(2000);
        WebElement yearButton = getDriver().findElement(By.xpath("/html/body/div[21]/div/div/div[2]/div[2]/form/div[1]/div[1]/div/div/core-combo/div/div/span/span/span"));
        yearButton.click();
        Thread.sleep(2000);
        WebElement year2019Button = getDriver().findElement(By.xpath("/html/body/div[22]/div/ul/li[1]"));
        year2019Button.click();
        Thread.sleep(2000);
        WebElement kbkButton = getDriver().findElement(By.xpath("/html/body/div[21]/div/div/div[2]/div[2]/form/div[1]/div[2]/div[3]/core-combo/div/div/span/span/span"));
        kbkButton.click();
        Thread.sleep(2000);
        WebElement kbk149346Button = getDriver().findElement(By.xpath("/html/body/div[24]/div/ul/li[1]"));
        kbk149346Button.click();
        Thread.sleep(2000);
        WebElement personalAccountButton = getDriver().findElement(By.xpath("/html/body/div[21]/div/div/div[2]/div[2]/form/div[3]/div[2]/div/core-combo/div/div/span/span/span")); //лицевой счет
        personalAccountButton.click();
        Thread.sleep(2000);
        WebElement account05604 = getDriver().findElement(By.xpath("/html/body/div[25]/div/ul/li[1]")); //номер счета
        account05604.click();
        Thread.sleep(2000);
        WebElement sumElement = getDriver().findElement(LOCATOR_TXT_SUM_IN_SOURCE_FUNDING);
        sumElement.sendKeys(sum);
        Thread.sleep(2000);
    }

    public void clickOnCreatePurchaseObjectButton2() throws InterruptedException {
        getLogger().getLogger().info("Нажать на 'Создать объект закупки' повторно");
        WebElement purchaseObjectCreateButton = getDriver().findElement(By.xpath("//*[@id=\"accordion8\"]/div/div[2]/button"));
        purchaseObjectCreateButton.click();
        Thread.sleep(2000);
        WebElement potrIzReestraButton = getDriver().findElement(By.xpath("/html/body/div[27]/div/div/div[2]/div[1]/div[2]/core-link/div/div[1]/div/button"));
        potrIzReestraButton.click();
        Thread.sleep(2000);
        WebElement objFromRegistry701 = getDriver().findElement(By.xpath("//*[@id=\"tsrNeedsGrid\"]/div[2]/table/tbody/tr[1]/td[2]"));
        objFromRegistry701.click();
        Thread.sleep(2000);
        WebElement choiceButton = getDriver().findElement(By.xpath("/html/body/div[29]/div/div/div/div[4]/button[2]"));//кнопка выбор
        choiceButton.click();
        Thread.sleep(2000);
        WebElement typeOrderButton = getDriver().findElement(By.xpath("/html/body/div[27]/div/div/div[2]/div[3]/div[2]/core-combo/div/div/span/span/span"));//тип заказа
        typeOrderButton.click();
        Thread.sleep(2000);
        WebElement productButton = getDriver().findElement(By.xpath("/html/body/div[28]/div/ul/li[1]")); //товар
        productButton.click();
    }

    public void setSubstantiationOfficer() throws InterruptedException {
        getLogger().getLogger().info("Ввести ответственных лиц. Ответственный за формирование обоснования");
        WebElement elementSubstOfficersButton = getDriver().findElement(By.xpath("//*[@id=\"accordion7\"]/div/div[1]/h2"));
        elementSubstOfficersButton.click();
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

    public void setProcurementOfficer() throws InterruptedException {
        getLogger().getLogger().info("Ввести ответственных лиц. Ответственный за проведение закупки");
        WebElement buttonAddProcurementOfficer = getDriver().findElement(By.xpath("//*[@id=\"responsiblePersonGrid\"]/div[2]/table/tbody/tr[2]/td[4]/div/button"));
        buttonAddProcurementOfficer.click();
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

    public void clickButtonAction() {
        getLogger().getLogger().info("Нажать на кнопку 'Действие'");
        WebElement button = getDriver().findElement(By.xpath("//*[@id=\"main\"]/div[2]/div/div/div[1]/div[2]/div/button"));
        button.click();
    }

    public void clickButtonReadinessConfirmation() throws InterruptedException {
        getLogger().getLogger().info("Выбрать пункт 'Подтверждение готовности'");
        WebElement buttonReadinessConfirm = getDriver().findElement(By.xpath("//*[@id=\"main\"]/div[2]/div/div/div[1]/div[2]/div/ul/li[2]/a"));
        buttonReadinessConfirm.click();
        WebElement ReadinessConfirmation = getDriver().findElement(By.xpath("/html/body/div[32]/div/div/div[3]/button[2]"));
        ReadinessConfirmation.click();
        Thread.sleep(3000);
    }

    public void setAuthorizedPerson(String surnameKey, String nameKey, String positionKey) throws InterruptedException {
        getLogger().getLogger().info("Ввести уполномоченное лицо: Фамилия, Имя, должность" + surnameKey + nameKey + positionKey);
        WebElement buttonHead = getDriver().findElement(By.xpath("//*[@id=\"accordion8\"]/div[1]/h2"));
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
        getLogger().getLogger().info("Закрыть сообщение");
        WebElement button = getDriver().findElement(By.xpath("/html/body/div[13]/div/div/div[3]/div/div[1]/div"));
        button.click();
        Thread.sleep(2000);
    }

    public void setDetailKbk(String sumKey) throws InterruptedException {
        getLogger().getLogger().info("Ввести детализацию КБК" + sumKey);
        WebElement elementDetailKBK = getDriver().findElement(By.xpath("//*[@id=\"accordion7\"]/div[1]/h2"));
        elementDetailKBK.click();
        Thread.sleep(2000);
        WebElement changeKBK = getDriver().findElement(By.xpath("//*[@id=\"accordion7\"]/div[1]/button[1]"));
        changeKBK.click();
        Thread.sleep(2000);
        WebElement field2019 = getDriver().findElement(LOCATOR_TXT_SUMKEY_FIELD_DETAIL_KBK);
        field2019.sendKeys(sumKey);
        Thread.sleep(2000);
    }

    public void clickSendingForApproval() throws InterruptedException {
        getLogger().getLogger().info("Отправить на утверждение");
        WebElement sendApprovButton = getDriver().findElement(By.xpath("//*[@id=\"main\"]/div[2]/div/div/div[1]/div[2]/div/ul/li[13]/a"));
        sendApprovButton.click();
        Thread.sleep(3000);
    }

    public void clickLoadingForm(int number) {
        getLogger().getLogger().info("Выбрать форму под номером:" + number);
        WebElement form = getDriver().findElement(By.xpath("//*[@id=\"main\"]/div[2]/div/div/div[1]/div[2]/div/ul/li[" + number + "]/a"));
        form.click();
    }

    public void clickTypePurchase() throws InterruptedException {

        getLogger().getLogger().info("Выбрать тип закупки"); //(8)
        WebElement tipZak = getDriver().findElement(By.xpath("//*[@id=\"mainDataPanel\"]/div/form/fieldset/div[8]/div/div/core-combo/div/div/span/span/span"));
        Thread.sleep(2000);
        tipZak.click();
        WebElement vybor2 = getDriver().findElement(By.xpath("/html/body/div[30]/div/ul/li[5]"));
        vybor2.click();
        Thread.sleep(1000);
    }

    public void saveChangeButton() throws InterruptedException {
        getLogger().getLogger().info("Сохранить изменения");
        WebElement saveChange = getDriver().findElement(By.xpath("//*[@id=\"accordion7\"]/div[1]/button[1]"));
        saveChange.click();
        Thread.sleep(2000);
    }

    public void saveChangeConfirmationButton() throws InterruptedException {
        getLogger().getLogger().info("Подтвердить сохранение изменений");
        WebElement saveChangeConfirmation = getDriver().findElement(By.xpath("/html/body/div[13]/div/div/div[3]/button[2]"));
        saveChangeConfirmation.click();
        Thread.sleep(2000);
    }

    public void saveSourceOfFundingButton() throws InterruptedException {
        getLogger().getLogger().info("Сохранить источник финансирования");
        WebElement buttonSave = getDriver().findElement(By.xpath("/html/body/div[21]/div/div/div[2]/div[3]/button[2]"));
        buttonSave.click();
        Thread.sleep(2000);
    }

    public void savePlannedPurchaseObjectButton() throws InterruptedException {
        getLogger().getLogger().info("Сохранить планируемый объект закупки");
        WebElement buttonSave = getDriver().findElement(By.xpath("/html/body/div[21]/div/div/div[2]/div[3]/button[2]"));
        buttonSave.click();
        Thread.sleep(2000);
    }
}
