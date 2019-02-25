package ru.granit.show.ui.pages;

import org.openqa.selenium.WebDriver;
import ru.granit.show.TestLogger;

public abstract class BasePage {

    public static final int DEFAULT_PAGE_TIMEOUT = 3;

    private final String pageName;
    private final WebDriver driver;

    public BasePage(WebDriver driver, String pageName){
        this.pageName = pageName;
        this.driver = driver;
    }

    public String getPageName() {
        return pageName;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public boolean isOpened(){
        return isOpened(0);
    }

    public abstract boolean isOpened(int timeout);

    protected TestLogger getLogger(){
        return TestLogger.get();
    }
}
