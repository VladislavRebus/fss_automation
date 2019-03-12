package ru.granit.show;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.granit.show.ui.pages.*;

public class UnloadingPrintedFormsPZ extends BaseTest {

    private final String login = "saratovsch";
    private final String password = "SHETKO1990";

    private final String registryNumber = "000060-19";

    @Test
    public void openTest() throws InterruptedException {

        LoginPage loginPage = new LoginPage(getDriver());
        Assert.assertTrue(loginPage.isOpened(BasePage.DEFAULT_PAGE_TIMEOUT), loginPage.getPageName() + " is opened");
        loginPage.login(login, password);
        Thread.sleep(2000);

        PlanPurchasePage planPurchasePage = new PlanPurchasePage(webDriver);
        Assert.assertEquals(planPurchasePage.getRegistryPlanPurchaseNumber(), registryNumber,
                "Реестровый номер плана закупок - верный");

        planPurchasePage.clickButtonAction();

        getLogger().info("Загрузить печатную форму 552ПП.Pdf");
        planPurchasePage.clickLoadingForm(5);

        planPurchasePage.clickButtonAction();
        getLogger().info("Загрузить печатную форму 552ПП.Excel");
        planPurchasePage.clickLoadingForm(6);

        planPurchasePage.clickButtonAction();
        getLogger().info("Загрузить печатную форму 552ПП(КОСГУ).Pdf");
        planPurchasePage.clickLoadingForm(7);

        planPurchasePage.clickButtonAction();
        getLogger().info("Загрузить печатную форму 552ПП(КОСГУ).Excel");
        planPurchasePage.clickLoadingForm(8);

        planPurchasePage.clickButtonAction();
        getLogger().info("Сформировать обоснование по 555ПП.Pdf");
        planPurchasePage.clickLoadingForm(9);

        planPurchasePage.clickButtonAction();
        getLogger().info("Сформировать обоснование по 555ПП.Excel");
        planPurchasePage.clickLoadingForm(10);
        Thread.sleep(3000);
    }
}
