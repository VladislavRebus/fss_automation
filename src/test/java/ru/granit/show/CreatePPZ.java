package ru.granit.show;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreatePPZ extends BaseTest {
    @Test
    public void openTest() throws InterruptedException {

        //вход
        String login = "saratovsch";
        String password = "SHETKO1990";
        String registryNumber = "000060-19";
        String numIKZ = "3301";
        String year = "2019";
        String nameObjectPurch = "Партия кожаных дипломатов MAKEY";
        String justification = "Прямая необходимость";
        String time2 = "эти буквы должны быть здесь";
        String sum = "75000000";
        WebElement elementLog = webDriver.findElement(By.id("loginTxt"));
        elementLog.sendKeys(login);
        WebElement elementPass = webDriver.findElement(By.id("passwordTxt"));
        elementPass.sendKeys(password);
        WebElement elementButtonEnter = webDriver.findElement(By.className("send-data"));
        elementButtonEnter.click();
        Thread.sleep(2000);


        getLogger().info("Check the purchase plan number");
        WebElement elementNumberPlan = webDriver.findElement(By.xpath("//*[@id=\"mainDataPanel\"]/div/form/fieldset/div[6]/div[1]/input"));
        Assert.assertEquals(elementNumberPlan.getAttribute("value"), registryNumber);

        getLogger().info("Create a purchase object (2)");
        WebElement createObjectZak = webDriver.findElement(By.xpath("//*[@id=\"specificationsPanel\"]/div/div[1]/div[2]/button[1]"));
        createObjectZak.click();
        Thread.sleep(2000);

        getLogger().info("Save button");
        WebElement saveButton = webDriver.findElement(By.xpath("//*[@id=\"main\"]/div[2]/div/div/div[1]/div[2]/button[1]"));
        saveButton.click();
        Thread.sleep(2000);

        getLogger().info("Close the alert (3)");
        WebElement closeAlertTab = webDriver.findElement(By.xpath("/html/body/div[21]/div/div/div[3]/button"));
        closeAlertTab.click();
        Thread.sleep(2000);

        getLogger().info("Enter the sequence number for IKZ (4)");
        WebElement numberIKZ = webDriver.findElement(By.xpath("//*[@id=\"mainDataPanel\"]/div/form/fieldset/div[5]/div/input"));
        System.out.println("Вводим" + numIKZ);
        numberIKZ.sendKeys(numIKZ);

        getLogger().info("Save button (5)");
        saveButton.click();
        Thread.sleep(2000);

        getLogger().info("Close the alert");
        WebElement closeWarningTab2 = webDriver.findElement(By.xpath("/html/body/div[21]/div/div/div[3]/button"));
        closeWarningTab2.click();
        Thread.sleep(2000);

        getLogger().info("Enter the planned placement year (6)");
        WebElement yearPlacement = webDriver.findElement(By.xpath("//*[@id=\"mainDataPanel\"]/div/form/fieldset/div[7]/div[2]/div/core-combo/div/div/span/span/input"));
        yearPlacement.sendKeys(year);
        Thread.sleep(2000);
        WebElement vybor = webDriver.findElement(By.xpath("/html/body/div[12]/div/ul/li[1]"));
        vybor.click();

        getLogger().info("Save button (7)");
        saveButton.click();
        Thread.sleep(2000);

        getLogger().info("Close the alert");
        WebElement closeWarningTab3 = webDriver.findElement(By.xpath("/html/body/div[21]/div/div/div[3]/button"));
        closeWarningTab3.click();

        getLogger().info("Scroll down");
        JavascriptExecutor jse = (JavascriptExecutor) webDriver;
        jse.executeScript("window.scrollBy(0,900)", "");

        getLogger().info("Introduce the justification of the object");//Вводим обоснование соответствия объекта (12)
        WebElement justificObj = webDriver.findElement(By.xpath("//*[@id=\"to-purchase\"]"));
        justificObj.sendKeys(justification);
        Thread.sleep(2000);

        getLogger().info("Save button (13)");
        saveButton.click();
        Thread.sleep(2000);

        getLogger().info("Close the alert");
        WebElement closeWarningTab6 = webDriver.findElement(By.xpath("/html/body/div[21]/div/div/div[3]/button"));
        closeWarningTab6.click();
        Thread.sleep(2000);

        getLogger().info("Specify the time and frequency of delivery");//Укажем срок и периодичность поставки (14)
        WebElement checkBoxTime = webDriver.findElement(By.xpath("//*[@id=\"deliveryTerm\"]/div/div/div[1]/label/input"));
        checkBoxTime.click();
        Thread.sleep(2000);
        //поле иное
        WebElement otherwise = webDriver.findElement(By.xpath("//*[@id=\"deliveryTerm\"]/div/div/div[3]/textarea[2]"));
        otherwise.sendKeys(time2);
        Thread.sleep(2000);

        getLogger().info("Save button");
        saveButton.click();
        Thread.sleep(2000);

        getLogger().info("Close the alert");
        WebElement closeWarningTab7 = webDriver.findElement(By.xpath("/html/body/div[21]/div/div/div[3]/button"));
        closeWarningTab7.click();
        Thread.sleep(2000);

        getLogger().info("Scroll up");
        jse.executeScript("window.scrollBy(0,-800)", "");
        Thread.sleep(2000);

        getLogger().info("Introduce the name of the object or objects of purchase");//Введем наименование объекта или объектов закупки ()
        WebElement nameObjectPurchElement = webDriver.findElement(By.xpath("//*[@id=\"mainDataPanel\"]/div/form/fieldset/div[11]/div/div/input"));
        nameObjectPurchElement.sendKeys(nameObjectPurch);
        Thread.sleep(2000);

        getLogger().info("Save button");
        saveButton.click();
        Thread.sleep(4000);

        getLogger().info("Add a source of funding (16)");//Добавим источник финансирования (16)
        WebElement sourceFundButton = webDriver.findElement(By.xpath("//*[@id=\"accordion2\"]/div/div[2]/button"));
        sourceFundButton.click();
        Thread.sleep(2000);
        WebElement buttonYear = webDriver.findElement(By.xpath("/html/body/div[21]/div/div/div[2]/div[2]/form/div[1]/div[1]/div/div/core-combo/div/div/span/span/span"));
        buttonYear.click();
        Thread.sleep(2000);
        WebElement year2019Button = webDriver.findElement(By.xpath("/html/body/div[22]/div/ul/li[1]"));
        year2019Button.click();
        Thread.sleep(2000);
        WebElement buttonKbk = webDriver.findElement(By.xpath("/html/body/div[21]/div/div/div[2]/div[2]/form/div[1]/div[2]/div[3]/core-combo/div/div/span/span/span"));
        buttonKbk.click();
        Thread.sleep(2000);
        WebElement kbk149346Button = webDriver.findElement(By.xpath("/html/body/div[24]/div/ul/li[1]"));
        kbk149346Button.click();
        Thread.sleep(2000);
        WebElement buttonPersonalAccount = webDriver.findElement(By.xpath("/html/body/div[21]/div/div/div[2]/div[2]/form/div[3]/div[2]/div/core-combo/div/div/span/span/span")); //лицевой счет
        buttonPersonalAccount.click();
        Thread.sleep(2000);
        WebElement account05604 = webDriver.findElement(By.xpath("/html/body/div[25]/div/ul/li[1]")); //номер счета
        account05604.click();
        Thread.sleep(2000);
        WebElement sumElement = webDriver.findElement(By.xpath("/html/body/div[21]/div/div/div[2]/div[2]/form/div[4]/div[2]/span/span/input[1]"));
        sumElement.sendKeys(sum);
        Thread.sleep(2000);

        getLogger().info("Save button (9)");//Пробуем сохранить (9) - здесь не стандартный локатор
        WebElement buttonSave = webDriver.findElement(By.xpath("/html/body/div[21]/div/div/div[2]/div[3]/button[2]"));
        buttonSave.click();
        Thread.sleep(2000);

        getLogger().info("Create a purchase object");//Создадим объект закупки
        WebElement buttonPurchaseObjCreate = webDriver.findElement(By.xpath("//*[@id=\"accordion8\"]/div/div[2]/button"));
        buttonPurchaseObjCreate.click();
        Thread.sleep(2000);
        WebElement buttonPotrIzReestra = webDriver.findElement(By.xpath("/html/body/div[27]/div/div/div[2]/div[1]/div[2]/core-link/div/div[1]/div/button"));
        buttonPotrIzReestra.click();
        Thread.sleep(2000);
        WebElement objFromRegistry701 = webDriver.findElement(By.xpath("//*[@id=\"tsrNeedsGrid\"]/div[2]/table/tbody/tr[1]/td[2]"));
        objFromRegistry701.click();
        Thread.sleep(2000);
        WebElement buttonChoice = webDriver.findElement(By.xpath("/html/body/div[29]/div/div/div/div[4]/button[2]"));//кнопка выбор
        buttonChoice.click();
        Thread.sleep(2000);
        WebElement typeOrder = webDriver.findElement(By.xpath("/html/body/div[27]/div/div/div[2]/div[3]/div[2]/core-combo/div/div/span/span/span"));//тип заказа
        typeOrder.click();
        Thread.sleep(2000);
        WebElement product = webDriver.findElement(By.xpath("/html/body/div[28]/div/ul/li[1]")); //товар
        product.click();

        getLogger().info("Save button (9)");//Пробуем сохранить (9) - здесь не стандартный локатор2
        WebElement buttonSave2 = webDriver.findElement(By.xpath("/html/body/div[27]/div/div/div[3]/button[2]"));
        buttonSave2.click();
        Thread.sleep(2000);


        getLogger().info("Scroll down");
        jse.executeScript("window.scrollBy(0,1000)", "");
        Thread.sleep(2000);

        getLogger().info("Input of responsible persons");//введем ответственных лиц
        getLogger().info("Substantiation officer");//отв за формир.обоснования.
        WebElement elementButtonSubstOfficers = webDriver.findElement(By.xpath("//*[@id=\"accordion7\"]/div/div[1]/h2"));
        elementButtonSubstOfficers.click();
        Thread.sleep(2000);
        WebElement buttonAddSubstOfficer = webDriver.findElement(By.xpath("//*[@id=\"responsiblePersonGrid\"]/div[2]/table/tbody/tr[1]/td[4]/div/button"));
        buttonAddSubstOfficer.click();
        Thread.sleep(2000);
        WebElement buttonResponsPerson = webDriver.findElement(By.xpath("/html/body/div[30]/div/div/div/div[2]/form/fieldset/div[2]/div[2]/core-link/div/div[1]/div/button"));
        buttonResponsPerson.click();
        Thread.sleep(2000);
        WebElement responsiblePerson = webDriver.findElement(By.xpath("//*[@id=\"responsiblePersonDialogGrid\"]/div[2]/table/tbody/tr/td[1]"));
        responsiblePerson.click();
        Thread.sleep(2000);
        WebElement buttonChoice2 = webDriver.findElement(By.xpath("/html/body/div[32]/div/div/div/div[4]/button[2]"));
        buttonChoice2.click();
        Thread.sleep(2000);
        WebElement saveChoice = webDriver.findElement(By.xpath("/html/body/div[30]/div/div/div/div[2]/form/fieldset/div[4]/div/button[1]"));
        saveChoice.click();
        Thread.sleep(2000);

        getLogger().info("Scroll down");
        jse.executeScript("window.scrollBy(0,400)", "");
        Thread.sleep(2000);

        getLogger().info("Procurement officer");//ответств.за пров.закуп.
        WebElement buttonAddProcurOfficer = webDriver.findElement(By.xpath("//*[@id=\"responsiblePersonGrid\"]/div[2]/table/tbody/tr[2]/td[4]/div/button"));
        buttonAddProcurOfficer.click();
        Thread.sleep(2000);
        WebElement buttonResponsPerson2 = webDriver.findElement(By.xpath("/html/body/div[31]/div/div/div/div[2]/form/fieldset/div[2]/div[2]/core-link/div/div[1]/div/button"));
        buttonResponsPerson2.click();
        Thread.sleep(2000);
        WebElement responsiblePerson2 = webDriver.findElement(By.xpath("//*[@id=\"responsiblePersonDialogGrid\"]/div[2]/table/tbody/tr/td[1]"));
        responsiblePerson2.click();
        Thread.sleep(2000);
        WebElement buttonChoice3 = webDriver.findElement(By.xpath("/html/body/div[33]/div/div/div/div[4]/button[2]"));
        buttonChoice3.click();
        Thread.sleep(2000);
        WebElement saveChoice2 = webDriver.findElement(By.xpath("/html/body/div[31]/div/div/div/div[2]/form/fieldset/div[4]/div/button[1]"));
        saveChoice2.click();
        Thread.sleep(2000);

        getLogger().info("Looking for action button");
        WebElement actionButton = webDriver.findElement(By.xpath("//*[@id=\"main\"]/div[2]/div/div/div[1]/div[2]/div/button"));
        actionButton.click();
        Thread.sleep(2000);

        getLogger().info("Readiness confirmation");//подтверждение готовности
        WebElement buttonReadinessConfirm = webDriver.findElement(By.xpath("//*[@id=\"main\"]/div[2]/div/div/div[1]/div[2]/div/ul/li[2]/a"));
        buttonReadinessConfirm.click();

        WebElement ReadinessConfirmation = webDriver.findElement(By.xpath("/html/body/div[32]/div/div/div[3]/button[2]"));
        ReadinessConfirmation.click();
        Thread.sleep(3000);
/*
        //Выбираем тип закупки (8)
        WebElement tipZak = webDriver.findElement(By.xpath("//*[@id=\"mainDataPanel\"]/div/form/fieldset/div[8]/div/div/core-combo/div/div/span/span/span"));
        Thread.sleep(2000);
        tipZak.click();
        WebElement vybor2 = webDriver.findElement(By.xpath("/html/body/div[30]/div/ul/li[5]"));
        vybor2.click();
        Thread.sleep(1000);
*/
    }
}
