package ru.granit.show;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.granit.show.ui.pages.*;

public class ApprovalOfThePZ extends BaseTest {

    private final String login = "saratovsch";
    private final String password = "SHETKO1990";
    private final String registryNumber = "000060-19";
    private final String surnameKey = "Максимов";
    private final String nameKey = "Максим";
    private final String positionKey = "Ведущий специалист";
    private final String sumKey = "75000000";

    @Test
    public void approvalOfThePZ() throws InterruptedException {

        LoginPage loginPage = new LoginPage(getDriver());
        Assert.assertTrue(loginPage.isOpened(BasePage.DEFAULT_PAGE_TIMEOUT), loginPage.getPageName() + " is opened");
        loginPage.login(login, password);
        Thread.sleep(6000);

        PlanPurchasePage planPurchasePage = new PlanPurchasePage(webDriver);

        planPurchasePage.closeMessage();

        Assert.assertEquals(planPurchasePage.getRegistryPlanPurchaseNumber(), registryNumber,
                "Реестровый номер плана закупок - верный");

        planPurchasePage.setAuthorizedPerson(surnameKey, nameKey, positionKey);

        planPurchasePage.savePlan();

        planPurchasePage.setDetailKbk(sumKey);

        planPurchasePage.saveChangeButton();
        planPurchasePage.saveChangeConfirmationButton();

        planPurchasePage.clickButtonAction();

        planPurchasePage.clickSendingForApproval();
    }
}
