package ru.granit.show;

import org.testng.annotations.Test;

public class AppTest {
    @Test
    public void testApp() {
         App app = new App();
        app.logMessages();
    }
}
