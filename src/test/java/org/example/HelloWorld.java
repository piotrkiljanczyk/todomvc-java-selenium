package org.example;

import io.github.bonigarcia.wdm.managers.FirefoxDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HelloWorld {

    @Test
    public void browserPuppeteer() throws InterruptedException {
        var browser = new FirefoxDriver();
        browser.get("http://google.pl/");
        Thread.sleep(2000);
        browser.close();
    }
}
