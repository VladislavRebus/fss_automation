package ru.granit.show;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.granit.show.ui.pages.*;

public class CreatePPZ extends BaseTest {

    private final String login = "saratovsch";
    private final String password = "SHETKO1990";

    @Test
    public void openTest() throws InterruptedException {

        LoginPage loginPage = new LoginPage(getDriver());
        Assert.assertTrue(loginPage.isOpened(BasePage.DEFAULT_PAGE_TIMEOUT), loginPage.getPageName() + " is opened");
        loginPage.login(login, password);
        Thread.sleep(2000);

        CheckPurchaseNumberPage checkPurchasePlanNumber = new CheckPurchaseNumberPage(webDriver);
        checkPurchasePlanNumber.purchasePlanNumber();

        CreateFormPurchaseObjectPage createObjectPurchase = new CreateFormPurchaseObjectPage(webDriver);
        createObjectPurchase.createFormPurchaseObjectMethod();

        SaveButtonPage saveButton = new SaveButtonPage(webDriver);
        saveButton.saveButtonMethod();
        CloseAlertButtonPage closeAlertButton = new CloseAlertButtonPage(webDriver);
        closeAlertButton.closeAlertButtonMethod();

        EnterSequenceNumberIkzPage enterSequenceNumber = new EnterSequenceNumberIkzPage(webDriver);
        enterSequenceNumber.enterSequenceNumberIkzMethod();

        saveButton.saveButtonMethod();
        closeAlertButton.closeAlertButtonMethod();

        EnterPlannedPlacementYearPage enterPlannedPlacementYear = new EnterPlannedPlacementYearPage(webDriver);
        enterPlannedPlacementYear.enterPlannedPlacementYearMethod();

        saveButton.saveButtonMethod();
        closeAlertButton.closeAlertButtonMethod();

        getLogger().info("Scroll down");
        JavascriptExecutor jse = (JavascriptExecutor) webDriver;
        jse.executeScript("window.scrollBy(0,900)", "");

        IntroduceJustificationObjectPage introduceJustificationObject = new IntroduceJustificationObjectPage(webDriver);
        introduceJustificationObject.introduceJustificationObjectMethod();

        saveButton.saveButtonMethod();
        closeAlertButton.closeAlertButtonMethod();

        SpecifyTimeAndFrequencyDeliveryPage specifTimeAnFrequDeliv = new SpecifyTimeAndFrequencyDeliveryPage(webDriver);
        specifTimeAnFrequDeliv.specifyTimeAndFrequencyDeliveryMethod();

        saveButton.saveButtonMethod();
        closeAlertButton.closeAlertButtonMethod();

        getLogger().info("Scroll up");
        jse.executeScript("window.scrollBy(0,-800)", "");
        Thread.sleep(2000);

        IntroduceNameObjectPurchasePage introduceNameObjectPurchase = new IntroduceNameObjectPurchasePage(webDriver);
        introduceNameObjectPurchase.introduceNameObjectPurchaseMethod();

        saveButton.saveButtonMethod();
        Thread.sleep(4000);

        AddSourceFundingPage addSourceFunding = new AddSourceFundingPage(webDriver);
        addSourceFunding.AddSourceFundingMethod();

        getLogger().info("Save button (9)");//Пробуем сохранить (9) - здесь не стандартный локатор
        WebElement buttonSave = webDriver.findElement(By.xpath("/html/body/div[21]/div/div/div[2]/div[3]/button[2]"));
        buttonSave.click();
        Thread.sleep(2000);

        CreatePurchaseObjectPage createPurchaseObject = new CreatePurchaseObjectPage(webDriver);
        createPurchaseObject.createPurchaseObjectMethod();

        getLogger().info("Save button (9)");//Пробуем сохранить (9) - здесь не стандартный локатор2
        WebElement buttonSave2 = webDriver.findElement(By.xpath("/html/body/div[27]/div/div/div[3]/button[2]"));
        buttonSave2.click();
        Thread.sleep(2000);


        getLogger().info("Scroll down");
        jse.executeScript("window.scrollBy(0,1000)", "");
        Thread.sleep(2000);

        InputSubstantiationOfficerPage inputSubstantiationOfficer = new InputSubstantiationOfficerPage(webDriver);
        inputSubstantiationOfficer.inputSubstantiationOfficerMethod();

        getLogger().info("Scroll down");
        jse.executeScript("window.scrollBy(0,400)", "");
        Thread.sleep(2000);

        InputProcurementOfficerPage inputProcurementOfficer = new InputProcurementOfficerPage(webDriver);
        inputProcurementOfficer.inputProcurementOfficerMethod();

        ActionButtonPage actionButton = new ActionButtonPage(webDriver);
        actionButton.clickActionButton();

        ReadinessConfirmationPage readinessConfirmation = new ReadinessConfirmationPage(webDriver);
        readinessConfirmation.readinessConfirmationMethod();
    }
}
