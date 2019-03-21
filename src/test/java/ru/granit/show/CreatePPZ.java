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
        Thread.sleep(2000);

        PlanPurchasePage planPurchasePage = new PlanPurchasePage(webDriver);
        Assert.assertEquals(planPurchasePage.getRegistryPlanPurchaseNumber(), registryNumber,
                "Реестровый номер плана закупок - верный");

        planPurchasePage.clickButtonOnCreatePurchaseObject();

        planPurchasePage.savePlan();
        planPurchasePage.closeAlert();

        planPurchasePage.setSerialNumberIKZ(numIKZ);

        planPurchasePage.savePlan();
        planPurchasePage.closeAlert();

        planPurchasePage.setPlannedPlacementYear();

        planPurchasePage.savePlan();
        planPurchasePage.closeAlert();

        getLogger().info("Scroll down");
        JavascriptExecutor jse = (JavascriptExecutor) webDriver;
        jse.executeScript("window.scrollBy(0,900)", "");

        planPurchasePage.setIntroduceJustificationObject(justification);

        planPurchasePage.savePlan();
        planPurchasePage.closeAlert();

        planPurchasePage.setSpecifyTimeAndFrequencyDelivery(time2);

        planPurchasePage.savePlan();
        planPurchasePage.closeAlert();

        getLogger().info("Scroll up");
        jse.executeScript("window.scrollBy(0,-800)", "");
        Thread.sleep(2000);

        planPurchasePage.setIntroduceNameObjectPurchase(nameObjectPurch);

        planPurchasePage.savePlan();
        Thread.sleep(4000);

        planPurchasePage.addSourceFunding(sum);
        planPurchasePage.saveSourceOfFundingButton();

        planPurchasePage.clickOnCreatePurchaseObjectButton2();
        planPurchasePage.savePlannedPurchaseObjectButton();

        getLogger().info("Scroll down");
        jse.executeScript("window.scrollBy(0,1000)", "");
        Thread.sleep(2000);

        planPurchasePage.setSubstantiationOfficer();

        getLogger().info("Scroll down");
        jse.executeScript("window.scrollBy(0,400)", "");
        Thread.sleep(2000);

        planPurchasePage.setProcurementOfficer();

        planPurchasePage.clickButtonAction();

        planPurchasePage.clickButtonReadinessConfirmation();
       // planPurchasePage.closeMessage();
    }
}
