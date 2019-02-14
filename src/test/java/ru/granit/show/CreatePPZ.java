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
        String reestrNumber = "000060-19";
        String numIKZ = "3301";
        String godRazmeshen = "2019";
        String objZak = "Партия кожаных дипломатов MAKEY";
        String obocnovanie = "Прямая необходимость";
        String time2 = "эти буквы должны быть здесь";
        String sum = "75000000";
        WebElement elementLog = webDriver.findElement(By.id("loginTxt"));
        elementLog.sendKeys(login);
        WebElement elementPass = webDriver.findElement(By.id("passwordTxt"));
        elementPass.sendKeys(password);
        WebElement elementButtonEnter = webDriver.findElement(By.className("send-data"));
        elementButtonEnter.click();
        Thread.sleep(2000);


        //проверим номер плана закупок
        WebElement elementNumberPlan = webDriver.findElement(By.xpath("//*[@id=\"mainDataPanel\"]/div/form/fieldset/div[6]/div[1]/input"));
        Assert.assertEquals(elementNumberPlan.getAttribute("value"), reestrNumber);

        //создадим объект закупки (2)
        WebElement createObjectZak = webDriver.findElement(By.xpath("//*[@id=\"specificationsPanel\"]/div/div[1]/div[2]/button[1]"));
        createObjectZak.click();
        Thread.sleep(2000);

        //пробуем сохранить (3)
        WebElement saveButton = webDriver.findElement(By.xpath("//*[@id=\"main\"]/div[2]/div/div/div[1]/div[2]/button[1]"));
        saveButton.click();
        Thread.sleep(2000);

        //Закрываем оповещение
        WebElement closeWarningTab = webDriver.findElement((By.xpath("/html/body/div[21]/div/div/div[3]/button")));
        closeWarningTab.click();
        Thread.sleep(2000);

        //Вводим порядковый номер для ИКЗ (4)
        WebElement numberIKZ = webDriver.findElement(By.xpath("//*[@id=\"mainDataPanel\"]/div/form/fieldset/div[5]/div/input"));
        System.out.println("Вводим" + numIKZ);
        numberIKZ.sendKeys(numIKZ);

        //Пробуем сохранить (5)
        saveButton.click();
        Thread.sleep(2000);

        //Закрываем оповещение
        WebElement closeWarningTab2 = webDriver.findElement(By.xpath("/html/body/div[21]/div/div/div[3]/button"));
        closeWarningTab2.click();
        Thread.sleep(2000);

        //Вводим планируемый год размещения (6)
        WebElement yearRazm = webDriver.findElement(By.xpath("//*[@id=\"mainDataPanel\"]/div/form/fieldset/div[7]/div[2]/div/core-combo/div/div/span/span/input"));
        yearRazm.sendKeys(godRazmeshen);
        Thread.sleep(2000);
        WebElement vybor = webDriver.findElement(By.xpath("/html/body/div[12]/div/ul/li[1]"));
        vybor.click();

        //Пробуем сохранить (7)
        saveButton.click();
        Thread.sleep(2000);

        //Закрываем оповещение
        WebElement closeWarningTab3 = webDriver.findElement(By.xpath("/html/body/div[21]/div/div/div[3]/button"));
        closeWarningTab3.click();


        JavascriptExecutor jse = (JavascriptExecutor) webDriver;
        jse.executeScript("window.scrollBy(0,900)", "");

        //Вводим обоснование соответствия объекта (12)
        WebElement obocnObj = webDriver.findElement(By.xpath("//*[@id=\"to-purchase\"]"));
        obocnObj.sendKeys(obocnovanie);
        Thread.sleep(2000);

        // Пробуем сохранить (13)
        saveButton.click();
        Thread.sleep(2000);

        //Закрываем оповещение
        WebElement closeWarningTab6 = webDriver.findElement(By.xpath("/html/body/div[21]/div/div/div[3]/button"));
        closeWarningTab6.click();
        Thread.sleep(2000);

        //Укажем срок и периодичность поставки (14)

        WebElement checkBoxSrok = webDriver.findElement(By.xpath("//*[@id=\"deliveryTerm\"]/div/div/div[1]/label/input"));
        checkBoxSrok.click();
        Thread.sleep(2000);

        WebElement poleInoe = webDriver.findElement(By.xpath("//*[@id=\"deliveryTerm\"]/div/div/div[3]/textarea[2]"));
        poleInoe.sendKeys(time2);
        Thread.sleep(2000);

        // Пробуем сохранить ()
        saveButton.click();
        Thread.sleep(2000);

        //Закрываем оповещение
        WebElement closeWarningTab7 = webDriver.findElement(By.xpath("/html/body/div[21]/div/div/div[3]/button"));
        closeWarningTab7.click();
        Thread.sleep(2000);

        //скролим вверх
        jse.executeScript("window.scrollBy(0,-800)", "");
        Thread.sleep(2000);

        //Введем наименование объекта или объектов закупки ()
        WebElement objectZak = webDriver.findElement(By.xpath("//*[@id=\"mainDataPanel\"]/div/form/fieldset/div[11]/div/div/input"));
        objectZak.sendKeys(objZak);
        Thread.sleep(2000);

        //Пробуем сохранить ()
        saveButton.click();
        Thread.sleep(4000);

        //Добавим источник финансирования (16)
        WebElement istFinan = webDriver.findElement(By.xpath("//*[@id=\"accordion2\"]/div/div[2]/button"));
        istFinan.click();
        Thread.sleep(2000);
        WebElement buttonGod = webDriver.findElement(By.xpath("/html/body/div[21]/div/div/div[2]/div[2]/form/div[1]/div[1]/div/div/core-combo/div/div/span/span/span"));
        buttonGod.click();
        Thread.sleep(2000);
        WebElement god2019 = webDriver.findElement(By.xpath("/html/body/div[22]/div/ul/li[1]"));
        god2019.click();
        Thread.sleep(2000);
        WebElement buttonKbk = webDriver.findElement(By.xpath("/html/body/div[21]/div/div/div[2]/div[2]/form/div[1]/div[2]/div[3]/core-combo/div/div/span/span/span"));
        buttonKbk.click();
        Thread.sleep(2000);
        WebElement kbk149346 = webDriver.findElement(By.xpath("/html/body/div[24]/div/ul/li[1]"));
        kbk149346.click();
        Thread.sleep(2000);
        WebElement buttonLicSchet = webDriver.findElement(By.xpath("/html/body/div[21]/div/div/div[2]/div[2]/form/div[3]/div[2]/div/core-combo/div/div/span/span/span"));
        buttonLicSchet.click();
        Thread.sleep(2000);
        WebElement schet05604 = webDriver.findElement(By.xpath("/html/body/div[25]/div/ul/li[1]"));
        schet05604.click();
        Thread.sleep(2000);
        WebElement summa = webDriver.findElement(By.xpath("/html/body/div[21]/div/div/div[2]/div[2]/form/div[4]/div[2]/span/span/input[1]"));
        summa.sendKeys(sum);
        Thread.sleep(2000);

        //Пробуем сохранить (9)
        WebElement buttonSave = webDriver.findElement(By.xpath("/html/body/div[21]/div/div/div[2]/div[3]/button[2]"));
        buttonSave.click();
        Thread.sleep(2000);

        //Создадим объект закупки
        WebElement buttonSozdObjZak = webDriver.findElement(By.xpath("//*[@id=\"accordion8\"]/div/div[2]/button"));
        buttonSozdObjZak.click();
        Thread.sleep(2000);
        WebElement buttonPotrIzReestra = webDriver.findElement(By.xpath("/html/body/div[27]/div/div/div[2]/div[1]/div[2]/core-link/div/div[1]/div/button"));
        buttonPotrIzReestra.click();
        Thread.sleep(2000);
        WebElement objIzReestra701 = webDriver.findElement(By.xpath("//*[@id=\"tsrNeedsGrid\"]/div[2]/table/tbody/tr[1]/td[2]"));
        objIzReestra701.click();
        Thread.sleep(2000);
        WebElement buttonVibor = webDriver.findElement(By.xpath("/html/body/div[29]/div/div/div/div[4]/button[2]"));
        buttonVibor.click();
        Thread.sleep(2000);
        WebElement tipZakaza = webDriver.findElement(By.xpath("/html/body/div[27]/div/div/div[2]/div[3]/div[2]/core-combo/div/div/span/span/span"));
        tipZakaza.click();
        Thread.sleep(2000);
        WebElement tovar = webDriver.findElement(By.xpath("/html/body/div[28]/div/ul/li[1]"));
        tovar.click();

        //Пробуем сохранить (9)
        WebElement buttonSave2 = webDriver.findElement(By.xpath("/html/body/div[27]/div/div/div[3]/button[2]"));
        buttonSave2.click();
        Thread.sleep(2000);


        //скролим ниже
        jse.executeScript("window.scrollBy(0,1000)", "");
        Thread.sleep(2000);

        //введем ответственных лиц
        //отв за формир.обоснования.
        WebElement elementButtonOtvLic = webDriver.findElement(By.xpath("//*[@id=\"accordion7\"]/div/div[1]/h2"));
        elementButtonOtvLic.click();
        Thread.sleep(2000);
        WebElement buttonAddOtvZaFormObocn = webDriver.findElement(By.xpath("//*[@id=\"responsiblePersonGrid\"]/div[2]/table/tbody/tr[1]/td[4]/div/button"));
        buttonAddOtvZaFormObocn.click();
        Thread.sleep(2000);
        WebElement buttonOtvLico = webDriver.findElement(By.xpath("/html/body/div[30]/div/div/div/div[2]/form/fieldset/div[2]/div[2]/core-link/div/div[1]/div/button"));
        buttonOtvLico.click();
        Thread.sleep(2000);
        WebElement otvLico = webDriver.findElement(By.xpath("//*[@id=\"responsiblePersonDialogGrid\"]/div[2]/table/tbody/tr/td[1]"));
        otvLico.click();
        Thread.sleep(2000);
        WebElement buttonVibor2 = webDriver.findElement(By.xpath("/html/body/div[32]/div/div/div/div[4]/button[2]"));
        buttonVibor2.click();
        Thread.sleep(2000);
        WebElement saveVibor = webDriver.findElement(By.xpath("/html/body/div[30]/div/div/div/div[2]/form/fieldset/div[4]/div/button[1]"));
        saveVibor.click();
        Thread.sleep(2000);

        //скролим ниже
        jse.executeScript("window.scrollBy(0,400)", "");
        Thread.sleep(2000);

        //ответств.за пров.закуп.
        WebElement buttonAddOtvZaProvZak = webDriver.findElement(By.xpath("//*[@id=\"responsiblePersonGrid\"]/div[2]/table/tbody/tr[2]/td[4]/div/button"));
        buttonAddOtvZaProvZak.click();
        Thread.sleep(2000);
        WebElement buttonOtvLico2 = webDriver.findElement(By.xpath("/html/body/div[31]/div/div/div/div[2]/form/fieldset/div[2]/div[2]/core-link/div/div[1]/div/button"));
        buttonOtvLico2.click();
        Thread.sleep(2000);
        WebElement otvLico2 = webDriver.findElement(By.xpath("//*[@id=\"responsiblePersonDialogGrid\"]/div[2]/table/tbody/tr/td[1]"));
        otvLico2.click();
        Thread.sleep(2000);
        WebElement buttonVibor3 = webDriver.findElement(By.xpath("/html/body/div[33]/div/div/div/div[4]/button[2]"));
        buttonVibor3.click();
        Thread.sleep(2000);
        WebElement saveVibor2 = webDriver.findElement(By.xpath("/html/body/div[31]/div/div/div/div[2]/form/fieldset/div[4]/div/button[1]"));
        saveVibor2.click();
        Thread.sleep(2000);

        //кнопка действие
        WebElement buttonDo = webDriver.findElement(By.xpath("//*[@id=\"main\"]/div[2]/div/div/div[1]/div[2]/div/button"));
        buttonDo.click();
        Thread.sleep(2000);

        //подтверждение готовности
        WebElement buttonPodtvGot = webDriver.findElement(By.xpath("//*[@id=\"main\"]/div[2]/div/div/div[1]/div[2]/div/ul/li[2]/a"));
        buttonPodtvGot.click();

        WebElement finalPodtv = webDriver.findElement(By.xpath("/html/body/div[32]/div/div/div[3]/button[2]"));
        finalPodtv.click();
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
