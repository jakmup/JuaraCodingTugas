package com.juaracoding.zakimufthi.swaglabs;


import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.juaracoding.zakimufthi.swaglabs.pages.InventoryPage;
import com.juaracoding.zakimufthi.swaglabs.pages.LoginPage;
import com.juaracoding.zakimufthi.swaglabs.utils.MiscUtil;


public class InventoryTest extends BaseTest {
  private InventoryPage inventoryPage;
  private LoginPage loginPage;

  @Test(priority = 1, enabled = true)
  @Parameters({"username", "password"})
  public void addSingleProductToChartTest(String username, String password) {
    preTestLogin(username, password);

    inventoryPage = new InventoryPage(driver);
    inventoryPage.getHeaderComponent().setButtonAddToChart("//button[@data-test='add-to-cart-sauce-labs-backpack']");
    inventoryPage.getHeaderComponent().setButtonRemoveChart("//button[@data-test='remove-sauce-labs-backpack']");

    inventoryPage.getHeaderComponent().clickButtonAddToChart();

    Assert.assertFalse(inventoryPage.getHeaderComponent().isVisibleButtonAddToChart());
    Assert.assertTrue(inventoryPage.getHeaderComponent().isVisibleButtonRemoveToChart());

    Assert.assertEquals(inventoryPage.getHeaderComponent().getTotalChart(), 1);
  }

  @Test(priority = 2, enabled = true)
  @Parameters({"username", "password"})
  public void addMultipleProdductToChartTest(String username, String password) {
    
    preTestLogin(username, password);
    List<Boolean> removeButtons = new ArrayList<>();

    inventoryPage = new InventoryPage(driver);

    inventoryPage.getHeaderComponent().setButtonAddToChart("//button[@data-test='add-to-cart-sauce-labs-backpack']");
    inventoryPage.getHeaderComponent().clickButtonAddToChart();

    inventoryPage.getHeaderComponent().setButtonAddToChart("//button[@data-test='add-to-cart-sauce-labs-bike-light']");
    inventoryPage.getHeaderComponent().clickButtonAddToChart();

    inventoryPage.getHeaderComponent().setButtonAddToChart("//button[@data-test='add-to-cart-sauce-labs-bolt-t-shirt']");
    inventoryPage.getHeaderComponent().clickButtonAddToChart();

    inventoryPage.getHeaderComponent().setButtonRemoveChart("//button[@data-test='remove-sauce-labs-backpack']");
    removeButtons.add(inventoryPage.getHeaderComponent().isVisibleButtonRemoveToChart());

    inventoryPage.getHeaderComponent().setButtonRemoveChart("//button[@data-test='remove-sauce-labs-bike-light']");
    removeButtons.add(inventoryPage.getHeaderComponent().isVisibleButtonRemoveToChart());

    inventoryPage.getHeaderComponent().setButtonRemoveChart("//button[@data-test='remove-sauce-labs-bolt-t-shirt']");
    removeButtons.add(inventoryPage.getHeaderComponent().isVisibleButtonRemoveToChart());

    int expected = 3;
    long actual = removeButtons.stream()
      .filter(n -> n)
      .count();

    Assert.assertEquals(actual, expected);
    Assert.assertEquals(inventoryPage.getHeaderComponent().getTotalChart(), expected);
  }

  @Test(priority = 3, enabled = true)
  @Parameters({"username", "password"})
  public void deleteProductFromInventariesPageTest(String username, String password) {
    
    preTestLogin(username, password);

    inventoryPage = new InventoryPage(driver);

    inventoryPage.getHeaderComponent().setButtonAddToChart("//button[@data-test='add-to-cart-sauce-labs-backpack']");
    inventoryPage.getHeaderComponent().clickButtonAddToChart();

    Assert.assertEquals(inventoryPage.getHeaderComponent().getTotalChart(), 1);

    inventoryPage.getHeaderComponent().setButtonRemoveChart("//button[@data-test='remove-sauce-labs-backpack']");
    inventoryPage.getHeaderComponent().clickButtonRemoveChart();

    Assert.assertTrue(inventoryPage.getHeaderComponent().isVisibleButtonAddToChart());
    Assert.assertFalse(inventoryPage.getHeaderComponent().isVisibleChartIcon());
  }

  @Test(priority = 4, enabled = true)
  @Parameters({"username", "password"})
  public void orderLowToHighBasePriceTest(String username, String password) {  
    preTestLogin(username, password);

    inventoryPage = new InventoryPage(driver);
    inventoryPage.selectLowToHigh();

    Assert.assertTrue(MiscUtil.isSorted(inventoryPage.getPrices()));
  }

  
  @Test(priority = 5, enabled = true)
  public void forbidenAccessToInventoryPageWithoutLoginTest() {
    setManualOpenBrowser();
    openBrowser("https://www.saucedemo.com/inventory.html");

    loginPage = new LoginPage(driver);

    String expected = "https://www.saucedemo.com/";
    Assert.assertEquals(loginPage.getCurrentURL(), expected);


    expected = "Epic sadface: You can only access '/inventory.html' when you are logged in.";
    Assert.assertEquals(loginPage.getErrorMessage(), expected);

    setAutoOpenBrowser();
  }
}

