package ru.granit.show;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.granit.show.ui.pages.BasePage;
import ru.granit.show.ui.pages.FormLoadingPage;
import ru.granit.show.ui.pages.LoginPage;

public class VygruzPechFormPZ extends BaseTest {

    private final String login = "saratovsch";
    private final String password = "SHETKO1990";
    private final String registryNumber = "000060-19";

    @Test
    public void openTest() throws InterruptedException {

        LoginPage loginPage = new LoginPage(getDriver());
        Assert.assertTrue(loginPage.isOpened(BasePage.DEFAULT_PAGE_TIMEOUT), loginPage.getPageName() + " is opened");
        loginPage.login(login, password);
        Thread.sleep(2000);

        getLogger().info("Check the purchase plan number");
        WebElement elementNumberPlan = webDriver.findElement(By.xpath("//*[@id=\"mainDataPanel\"]/div/form/fieldset/div[6]/div[1]/input"));
        Assert.assertEquals(elementNumberPlan.getAttribute("value"), registryNumber);
        Thread.sleep(2000);

        getLogger().info("Looking for action button");
        WebElement actionButton = webDriver.findElement(By.xpath("//*[@id=\"main\"]/div[2]/div/div/div[1]/div[2]/div/button"));
        actionButton.click();

        getLogger().info("Download printed form 552PP.Pdf");
        FormLoadingPage form552ppPdfPage = new FormLoadingPage(webDriver);
        form552ppPdfPage.openFormByNumber(5);

        actionButton.click();
        getLogger().info("Download printed form 552PP.Excel");
        FormLoadingPage form552ppExcelPage = new FormLoadingPage(webDriver);
        form552ppExcelPage.openFormByNumber(6);


        actionButton.click();
        getLogger().info("Download printed form 552PP (KOSGU) .Pdf");
        FormLoadingPage form552ppKOSGUPdfPage = new FormLoadingPage(webDriver);
        form552ppKOSGUPdfPage.openFormByNumber(7);


        actionButton.click();
        getLogger().info("Download printed form 552PP (KOSGU) .Excel");
        FormLoadingPage form552ppKOSGUExcelPage = new FormLoadingPage(webDriver);
        form552ppKOSGUExcelPage.openFormByNumber(8);

        actionButton.click();
        getLogger().info("Download justification for 555 PP Pdf");
        FormLoadingPage justification555ppPdfPage = new FormLoadingPage(webDriver);
        justification555ppPdfPage.openFormByNumber(9);

        actionButton.click();
        getLogger().info("Download justification for 555 PP Excel");
        FormLoadingPage justification555ppExcelPage = new FormLoadingPage(webDriver);
        justification555ppExcelPage.openFormByNumber(10);
        Thread.sleep(3000);
    }
}
