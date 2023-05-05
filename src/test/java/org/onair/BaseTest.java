package org.onair;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.onair.pages.Page.getDriver;
import static org.onair.pages.Page.setDriver;

public class BaseTest {

    @BeforeAll
    public static void init(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("disable-infobars");
        setDriver(new ChromeDriver(options));
    }

    @AfterAll
    public static void tearDown(){
        getDriver().quit();
    }
}
