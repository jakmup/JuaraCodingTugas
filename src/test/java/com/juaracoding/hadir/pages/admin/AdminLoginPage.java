package com.juaracoding.hadir.pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.juaracoding.hadir.base.BasePage;

public class AdminLoginPage extends BasePage{

    private By usernamefield = By.id("email");
    private By passwordfield = By.id("password");
    private By loginButton = By.xpath("//button[@type='submit']");

    public AdminLoginPage(WebDriver driver){
        super(driver);
    }

    public void login(String username, String password){
        waitingElementReady(usernamefield).sendKeys(username);
        waitingElementReady(passwordfield).sendKeys(password);
        waitingElementReady(loginButton).click();

        new org.openqa.selenium.support.ui.WebDriverWait(driver, java.time.Duration.ofSeconds(10))
        .until(org.openqa.selenium.support.ui.ExpectedConditions.urlContains("dashboard"));
    }
}
