package ru.granit.show;

import org.apache.log4j.Logger;

public class TestLogger {
    private static TestLogger _instance;
    private final Logger log4jLogger;

    public static TestLogger get() {
        if (_instance == null) _instance = new TestLogger();
        return _instance;
    }

    private TestLogger() {
        log4jLogger = org.apache.log4j.Logger.getLogger("selenium.tests");
    }

    public Logger getLogger(){
        return log4jLogger;
    }

    public void startSuite(String suiteName){
        log4jLogger.info("======[Suite '" + suiteName + "' has been started]======");
    }

    public void endSuite(String suiteName){
        log4jLogger.info("======[Suite '" + suiteName + "' has been ended]======");
    }

    public void startTest(String testName){
        log4jLogger.info("===[Test '" + testName + "' has been started]===");
    }

    public void endTest(String testName){
        log4jLogger.info("===[Test '" + testName + "' has been ended]===");
    }
}
