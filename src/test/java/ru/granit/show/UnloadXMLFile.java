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

        PlanPurchasePage planPurchasePage = new PlanPurchasePage(webDriver);
        Assert.assertEquals(planPurchasePage.getRegistryPlanPurchaseNumber(), registryNumber,
                "Реестровый номер плана закупок - верный");

        planPurchasePage.clickButtonAction();

        getLogger().info("Выгрузить XML в ЕИС");
        planPurchasePage.clickLoadingForm(16);
    }
}