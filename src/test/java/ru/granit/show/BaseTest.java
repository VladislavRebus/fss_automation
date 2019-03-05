package ru.granit.show;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.lang.reflect.Method;

@Listeners(DefaultListener.class)
public class BaseTest {

    private final static String DEFAULT_URL = "http://show.granit.ru/test/fss/#/PlanPurchase?id=1118414";

    protected WebDriver webDriver;
    private TestLogger testLogger;
    private String suiteName;


    private void initializationDriver() {
        testLogger.getLogger().debug("Init driver for default browser Chrome");
        System.setProperty("webdriver.chrome.driver", getClass().getClassLoader().getResource("chromedriver.exe").getPath());
        webDriver = new ChromeDriver();
    }

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite(ITestContext context) {
        testLogger = TestLogger.get();
        initializationDriver();
        webDriver.manage().window().maximize();
        suiteName = context.getSuite().getXmlSuite().getName();
        testLogger.startSuite(suiteName);
        testLogger.getLogger().info("Navigate to " + DEFAULT_URL);
        webDriver.get(DEFAULT_URL);
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod(Method method) {
        testLogger.startTest(method.getName());
    }

  /*  @AfterMethod(alwaysRun = true)
    public void afterMethod(Method method) {
        testLogger.endTest(method.getName());
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        testLogger.getLogger().debug("Close browser");
        if (webDriver != null) webDriver.quit();
        testLogger.endSuite(suiteName);
    } */

    protected Logger getLogger(){
        return testLogger.getLogger();
    }

    protected WebDriver getDriver() {
        return webDriver;
    }
}
