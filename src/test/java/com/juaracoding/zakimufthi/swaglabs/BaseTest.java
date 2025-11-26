package com.juaracoding.zakimufthi.swaglabs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import com.juaracoding.zakimufthi.swaglabs.listeners.ScreenshotListener;
import com.juaracoding.zakimufthi.swaglabs.pages.LoginPage;

@Listeners(ScreenshotListener.class)
public abstract class BaseTest {

  protected WebDriver driver;
  private boolean manualOpeningBrowser = false;

  public void setManualOpenBrowser() {
    manualOpeningBrowser = true;
  }

  public void setAutoOpenBrowser() {
    manualOpeningBrowser = false;
  }

  @BeforeMethod
  public void setUp(ITestContext context) {
    driver = new FirefoxDriver();
    driver.manage().window().maximize();
    context.setAttribute("driver", driver);
    if (!manualOpeningBrowser) {
      openBrowser("https://www.saucedemo.com/");
    }
  }

  @AfterMethod
  public void teardown(ITestContext context) {
    if (driver != null) {
      driver.quit();
    }
  }
  
  public void openBrowser(String url) {
    driver.get(url);
  }

  public void preTestLogin(String username, String password) {
    LoginPage loginPage = new LoginPage(driver);
    loginPage.login(username, password);
  }
}
