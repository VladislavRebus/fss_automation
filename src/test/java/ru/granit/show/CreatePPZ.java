package ru.granit.show;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.granit.show.ui.pages.*;

public class CreatePPZ extends BaseTest {

    private final String login = "saratovsch";
    private final String password = "SHETKO1990";
    private final String registryNumber = "000060-19";
    private final String numIKZ = "3301";
    private final String justification = "Прямая необходимость";
    private final String time2 = "Эти буквы должны быть здесь";
    private final String nameObjectPurch = "Партия кожаных дипломатов MAKEY";
    private final String sum = "75000000";

    @Test
    public void openTest() throws InterruptedException {

        LoginPage loginPage = new LoginPage(getDriver());
        Assert.assertTrue(loginPage.isOpened(BasePage.DEFAULT_PAGE_TIMEOUT), loginPage.getPageName() + " is opened");
        loginPage.login(login, password);

        PlanPurchasePage planPurchasePage = new PlanPurchasePage(webDriver);
        PlanPurchaseSpecificationPage planPurchaseSpecificationPage = new PlanPurchaseSpecificationPage(webDriver);

        Assert.assertTrue(planPurchasePage.isOpened(BasePage.DEFAULT_PAGE_TIMEOUT), planPurchasePage.getPageName() + " открыта");
        Assert.assertEquals(planPurchasePage.getRegistryPlanPurchaseNumber(), registryNumber,
                "Реестровый номер плана закупок - верный");

        planPurchasePage.clickButtonOnCreatePurchaseObject();

        Assert.assertTrue(planPurchaseSpecificationPage.isOpened(BasePage.DEFAULT_PAGE_TIMEOUT),
                planPurchaseSpecificationPage.getPageName() + "открыта");

        planPurchaseSpecificationPage.savePlan();
        planPurchaseSpecificationPage.closeAlert();

        planPurchaseSpecificationPage.setSerialNumberIKZ(numIKZ);

        planPurchaseSpecificationPage.savePlan();
        planPurchaseSpecificationPage.closeAlert();

        planPurchaseSpecificationPage.setPlannedPlacementYear();

        planPurchaseSpecificationPage.savePlan();
        planPurchaseSpecificationPage.closeAlert();

        planPurchaseSpecificationPage.setIntroduceJustificationObject(justification);

        planPurchaseSpecificationPage.savePlan();
        planPurchaseSpecificationPage.closeAlert();

        planPurchaseSpecificationPage.setSpecifyTimeAndFrequencyDelivery(time2);

        planPurchaseSpecificationPage.savePlan();
        planPurchaseSpecificationPage.closeAlert();

        planPurchaseSpecificationPage.setIntroduceNameObjectPurchase(nameObjectPurch);

        planPurchaseSpecificationPage.savePlan();
        Thread.sleep(1000);

        planPurchaseSpecificationPage.addSourceFunding(sum);
        planPurchaseSpecificationPage.saveSourceOfFundingButton();

        planPurchaseSpecificationPage.clickOnCreatePurchaseObjectButton2();
        planPurchaseSpecificationPage.savePlannedPurchaseObjectButton();

        planPurchaseSpecificationPage.setSubstantiationOfficer();
        planPurchaseSpecificationPage.setProcurementOfficer();

        planPurchaseSpecificationPage.clickButtonAction();
        planPurchaseSpecificationPage.clickButtonReadinessConfirmation();
        // planPurchasePage.closeMessage();
    }
}
