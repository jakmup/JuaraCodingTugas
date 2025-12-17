package com.juaracoding.hadir.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverUtil {
    
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private DriverUtil() {}

    /**
     * 
     * @param platform "mobile" / "admin"
     */

    public static void getInstance(){
        if (driver.get() == null){
            WebDriverManager.chromedriver().setup();
            WebDriver webDriver = new ChromeDriver();
            webDriver.manage().window().maximize();
            driver.set(webDriver);
        }
    }

    public static WebDriver getDriver(){
        return driver.get();
    }

    public static void quitDriver(){
        if(driver.get() != null){
            driver.get().quit();
            driver.remove();
        }
    }
}
