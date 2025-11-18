package com.juaracoding.swaglabs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public abstract class BaseTest {

  protected WebDriver driver;
  
  public void openBrowser() {
    driver = new FirefoxDriver();
    driver.manage().window().maximize();
  }

  public void navigateTo(String url) {
    driver.get(url);
  }

  public void quiteBrowser() {
    driver.quit();
  }

  public void preTestLogin(String username, String password) throws InterruptedException {
    openBrowserAndNavigateTo("https://www.saucedemo.com/");
    Thread.sleep(500);
    driver.findElement(By.id("user-name")).sendKeys(username);
    Thread.sleep(500);
    driver.findElement(By.id("password")).sendKeys(password);
    Thread.sleep(500);
    driver.findElement(By.id("login-button")).click();
  }

  public void openBrowserAndNavigateTo(String url) {
    openBrowser();
    navigateTo(url);
  }
}
