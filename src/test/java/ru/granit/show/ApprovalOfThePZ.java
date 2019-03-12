package ru.granit.show;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
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

        getLogger().info("Scroll down");
        JavascriptExecutor jse = (JavascriptExecutor) webDriver;
        jse.executeScript("window.scrollBy(0,900)", "");
        Thread.sleep(2000);

        planPurchasePage.setAuthorizedPerson(surnameKey, nameKey, positionKey);

        planPurchasePage.savePlan();

        getLogger().info("Scroll up");
        jse.executeScript("window.scrollBy(0,-800)", "");
        Thread.sleep(2000);

        planPurchasePage.setDetailKbk(sumKey);

        getLogger().info("Save change"); //этот кусок незнаю как оформить отдельно,или можно так же в SaveButton как-то прикрепить
        WebElement saveChange = webDriver.findElement(By.xpath("//*[@id=\"accordion7\"]/div[1]/button[1]"));
        saveChange.click();
        Thread.sleep(2000);
        WebElement saveChangeConfirmation = webDriver.findElement(By.xpath("/html/body/div[13]/div/div/div[3]/button[2]"));
        saveChangeConfirmation.click();
        Thread.sleep(2000);

        planPurchasePage.clickButtonAction();

        planPurchasePage.clickSendingForApproval();
    }
}
