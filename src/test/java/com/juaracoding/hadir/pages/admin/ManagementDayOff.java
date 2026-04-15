package com.juaracoding.hadir.pages.admin;

import com.juaracoding.hadir.base.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ManagementDayOff extends BasePage {
    private WebDriverWait wait;

    public ManagementDayOff(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void openPage() {
        driver.get("https://magang.dikahadir.com/management/day-off");
        wait.until(ExpectedConditions.urlContains("management/day-off"));
    }
}
