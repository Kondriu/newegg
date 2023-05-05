package org.onair.pages;

import org.onair.utills.PropertiesReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public abstract class Page {

//    PropertiesReader propertiesReader;
//
//    {
//        try {
//            propertiesReader = new PropertiesReader();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }

    private static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver webDriver) {
        driver = webDriver;
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public static void waitFor(ExpectedCondition<?> condition) {
        Duration duration = Duration.ofMillis(Long.parseLong(propertiesReader().getValue("default.timeout")));
        (new WebDriverWait(getDriver(), duration)).until(condition);
    }

    public void visitPage(String uri) {
        getDriver().get(uri);
    }

    public static PropertiesReader propertiesReader() {
        PropertiesReader propertiesReader;

        {
            try {
                propertiesReader = new PropertiesReader();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return propertiesReader;
    }
}
