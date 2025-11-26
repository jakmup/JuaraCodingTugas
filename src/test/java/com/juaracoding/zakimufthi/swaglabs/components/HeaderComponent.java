package com.juaracoding.zakimufthi.swaglabs.components;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HeaderComponent {
  private WebDriver driver;

  private By buttonAddToChart;
  private By buttonRemoveChart;
  private By chartIcon = By.xpath("//span[@data-test='shopping-cart-badge']");

  private WebDriverWait wait;

  public HeaderComponent(WebDriver driver) {
    this.driver = driver;
    wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  }

  public void setButtonAddToChart(String xpathExpression) {
    this.buttonAddToChart = By.xpath(xpathExpression);
  }

  public void setButtonRemoveChart(String xpathExpression) {
    this.buttonRemoveChart = By.xpath(xpathExpression);
  }

  public void clickButtonAddToChart() {
    WebElement element = wait.until(ExpectedConditions.elementToBeClickable(buttonAddToChart));
    element.click();
  }

  public void clickButtonRemoveChart() {
    WebElement element = wait.until(ExpectedConditions.elementToBeClickable(buttonRemoveChart));
    element.click();
  }

  public boolean isVisibleButtonAddToChart() {
    try {
      wait.until(ExpectedConditions.visibilityOfElementLocated(buttonAddToChart));
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  public boolean isVisibleButtonRemoveToChart() {
    try {
      wait.until(ExpectedConditions.visibilityOfElementLocated(buttonRemoveChart));
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  public boolean isVisibleChartIcon() {
    try {
      wait.until(ExpectedConditions.visibilityOfElementLocated(chartIcon));
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  public String getTextButtonAddToChart() {
    return wait.until(ExpectedConditions.visibilityOfElementLocated(buttonAddToChart)).getText();
  }

  public String getTextButtonRemoveChart() {
    return wait.until(ExpectedConditions.visibilityOfElementLocated(buttonRemoveChart)).getText();
  }

  public int getTotalChart() {
    WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(chartIcon));
    return Integer.parseInt(element.getText());
  }
}
