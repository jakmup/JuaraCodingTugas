package com.juaracoding.hadir.hooks;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.juaracoding.hadir.pages.admin.AdminLoginPage;
import com.juaracoding.hadir.pages.mobile.MobileLoginPage;
import com.juaracoding.hadir.utils.ConfigReader;
import com.juaracoding.hadir.utils.DriverUtil;
import com.juaracoding.hadir.utils.ScreenshotUtil;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class hooks {
    
    @Before
    public void beforeScenario(Scenario scenario){
        boolean isMobile = scenario.getSourceTagNames().contains("@mobile");
        String platform = isMobile ? "mobile" : "admin";

        DriverUtil.getInstance();

        String url = ConfigReader.get(platform + ".url");
        String username = ConfigReader.get(platform + ".username");
        String password = ConfigReader.get(platform + ".password");

        WebDriver driver = DriverUtil.getDriver();

        driver.get(url);
        if(isMobile){
            new MobileLoginPage(driver).login(username, password);
        } else{
            new AdminLoginPage(driver).login(username, password);
        }
    }

    @After
    public void afterScenario(Scenario scenario){
        WebDriver driver = DriverUtil.getDriver();

        String platform = scenario.getSourceTagNames().contains("@mobile") ? "mobile" : "admin";
        String module = scenario.getSourceTagNames().stream()
                        .filter(tag -> !tag.equalsIgnoreCase("@mobile") && !tag.equalsIgnoreCase("@admin"))
                        .findFirst()
                        .orElse("UnknownModule")
                        .replace("@", "");

        String status = scenario.isFailed() ? "FAIL" : "PASS";
        String screenshotPath = ScreenshotUtil.takeScreenshot(driver, platform, module, status, scenario.getName());
        
        if(screenshotPath != null){
                final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES); 
                scenario.attach(screenshot, "image/png",scenario.getName() + "_"+ status);
        }
        DriverUtil.quitDriver();
    }
}
