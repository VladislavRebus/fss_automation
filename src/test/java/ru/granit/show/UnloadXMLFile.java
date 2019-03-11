package ru.granit.show;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.granit.show.ui.pages.*;

public class UnloadXMLFile extends BaseTest {

    private final String login = "saratovsch";
    private final String password = "SHETKO1990";

    private final String registryNumber = "000060-19";

    @Test
    public void unloadXMLFile() throws InterruptedException {

        LoginPage loginPage = new LoginPage(getDriver());
        Assert.assertTrue(loginPage.isOpened(BasePage.DEFAULT_PAGE_TIMEOUT), loginPage.getPageName() + " is opened");
        loginPage.login(login, password);
        Thread.sleep(2000);

        PlanPurchasePage purchasePlanNumberPage = new PlanPurchasePage(webDriver);
        Assert.assertEquals(purchasePlanNumberPage.getRegistryPlanPurchaseNumber(), registryNumber,
                "Реестровый номер плана закупок - верный");

        ActionButtonPage actionButton = new ActionButtonPage(webDriver);
        actionButton.clickActionButton();

        getLogger().info("Choose unload XML in EIS");
        FormLoadingPage unloadXMLinEICPage = new FormLoadingPage(webDriver);
        unloadXMLinEICPage.openFormByNumber(16);
        Thread.sleep(2000);
    }
}