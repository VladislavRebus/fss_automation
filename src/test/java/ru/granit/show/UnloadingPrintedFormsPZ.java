package ru.granit.show;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.granit.show.ui.pages.*;

public class UnloadingPrintedFormsPZ extends BaseTest {

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

        ActionButtonPage actionButton = new ActionButtonPage(webDriver);
        actionButton.clickActionButton();

        getLogger().info("Download printed form 552PP.Pdf");
        FormLoadingPage form552ppPdfPage = new FormLoadingPage(webDriver);
        form552ppPdfPage.openFormByNumber(5);

        actionButton.clickActionButton();
        getLogger().info("Download printed form 552PP.Excel");
        FormLoadingPage form552ppExcelPage = new FormLoadingPage(webDriver);
        form552ppExcelPage.openFormByNumber(6);

        actionButton.clickActionButton();
        getLogger().info("Download printed form 552PP (KOSGU) .Pdf");
        FormLoadingPage form552ppKOSGUPdfPage = new FormLoadingPage(webDriver);
        form552ppKOSGUPdfPage.openFormByNumber(7);

        actionButton.clickActionButton();
        getLogger().info("Download printed form 552PP (KOSGU) .Excel");
        FormLoadingPage form552ppKOSGUExcelPage = new FormLoadingPage(webDriver);
        form552ppKOSGUExcelPage.openFormByNumber(8);

        actionButton.clickActionButton();
        getLogger().info("Download justification for 555 PP Pdf");
        FormLoadingPage justification555ppPdfPage = new FormLoadingPage(webDriver);
        justification555ppPdfPage.openFormByNumber(9);

        actionButton.clickActionButton();
        getLogger().info("Download justification for 555 PP Excel");
        FormLoadingPage justification555ppExcelPage = new FormLoadingPage(webDriver);
        justification555ppExcelPage.openFormByNumber(10);
        Thread.sleep(3000);
    }
}
