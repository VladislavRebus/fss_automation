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
    private final String year = "2019";
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

        planPurchasePage.clickOnCreatePurchaseObjectButton();

        planPurchasePage.savePlan();
        planPurchasePage.closeAlert();

        planPurchasePage.setSerialNumberIKZ(numIKZ);

        planPurchasePage.savePlan();
        planPurchasePage.closeAlert();

        /*===========to be continued===========*/

        planPurchasePage.setPlannedPlacementYear(year);

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

        getLogger().info("Save button (9)");//Пробуем сохранить (9) - здесь не стандартный локатор
        WebElement buttonSave = webDriver.findElement(By.xpath("/html/body/div[21]/div/div/div[2]/div[3]/button[2]"));
        buttonSave.click();
        Thread.sleep(2000);

        planPurchasePage.clickOnCreatePurchaseObjectButton2();

        getLogger().info("Save button (9)");//Пробуем сохранить (9) - здесь не стандартный локатор2
        WebElement buttonSave2 = webDriver.findElement(By.xpath("/html/body/div[27]/div/div/div[3]/button[2]"));
        buttonSave2.click();
        Thread.sleep(2000);

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
    }
}
