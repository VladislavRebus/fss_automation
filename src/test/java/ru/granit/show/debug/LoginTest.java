package ru.granit.show.debug;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.granit.show.BaseTest;
import ru.granit.show.ui.pages.BasePage;
import ru.granit.show.ui.pages.LoginPage;
import ru.granit.show.ui.pages.MainPage;

public class LoginTest extends BaseTest {

    private final String login = "saratovsch";
    private final String password = "SHETKO1990";

    @Test
    public void loginTest(){

        getDriver().navigate().to("http://show.granit.ru/test/fss/");

        LoginPage loginPage = new LoginPage(getDriver());
        Assert.assertTrue(loginPage.isOpened(BasePage.DEFAULT_PAGE_TIMEOUT), loginPage.getPageName() + " is opened");

        MainPage mainPage = loginPage.login(login, password);
        Assert.assertTrue(mainPage.isOpened(BasePage.DEFAULT_PAGE_TIMEOUT), mainPage.getPageName() + " is opened");
    }
}
