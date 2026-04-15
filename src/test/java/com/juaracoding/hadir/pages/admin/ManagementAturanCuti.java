package com.juaracoding.hadir.pages.admin;

import com.juaracoding.hadir.base.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ManagementAturanCuti extends BasePage {
    private WebDriverWait wait;

    public ManagementAturanCuti(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // --- Locators ---
    private By btnTambahAturan = By.xpath("//button[contains(text(),'Tambahkan Aturan Cuti')]");
    private By btnTambahDetail = By.xpath("//button[contains(text(),'Tambahkan Detail Aturan Cuti')]");
    private By searchInput = By.name("search");
    private By searchButton = By.xpath("//button[.='Search']");
    private By resetButton = By.xpath("//button[.='Reset']");
    private By inputNama = By.name("name");
    private By inputEligible = By.name("eligible_leave_total_month");
    private By inputTglBatas = By.xpath("//input[@placeholder='d']");
    private By inputBulanBatas = By.xpath("//input[@placeholder='m']");
    private By inputMaxSisa = By.name("max_carry_forward");
    private By inputBulanKerja = By.name("carry_forward_total_month");
    private By btnTambah = By.xpath("//button[contains(text(),'Tambahkan') or contains(text(), 'Simpan')]");
    private By btnHapus = By.xpath("//button[contains(text(),'Hapus')]");
    private By btnTambahModal = By.xpath("//div[@role='dialog']//button[contains(text(),'Tambahkan') or contains(text(), 'Simpan')]");
    private By inputMinimKerja = By.xpath("//input[@id='total_month_greater' or @placeholder='Minimal Bulan Bekerja']");
    private By inputTotalCuti = By.xpath("//input[@id='total_leave' or @placeholder='Total Cuti']");

    // --- Actions ---

    public void openPage() {
        driver.get("https://magang.dikahadir.com/management/unit-leave");
        wait.until(ExpectedConditions.urlContains("management/unit-leave"));
        // wait.until(ExpectedConditions.visibilityOfElementLocated(searchInput));
    }

    public void waitForPageLoad() {
    wait.until(webDriver -> ((JavascriptExecutor) webDriver)
        .executeScript("return document.readyState").equals("complete"));
    }

    public void clickTambahAturan() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(btnTambahAturan));
        try {
            element.click();
        } catch (Exception e) {
            // JavaScript fallback for Material UI interference
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        }
    }

    public void clickTambahDetail() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(btnTambahDetail));
        try {
            element.click();
        } catch (Exception e) {
            // JavaScript fallback for Material UI interference
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        }
    }

    public void clickMenuAction(String ruleName) {
    // This XPath finds the row containing your text, then looks for the button in the last column
        By threeDots = By.xpath("//tr[contains(.,'" + ruleName + "')]//button[@aria-haspopup='menu' or contains(@class, 'MuiButton')]");
        
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(threeDots));
        try {
            element.click();
        } catch (Exception e) {
            // Fallback for intercepted clicks
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        }
    }

    public void selectOption(String option) {
        By menuOption = By.xpath("//li[contains(.,'" + option + "')]");
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(menuOption));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public void inputSearchKeyword(String keyword) {
        // 1. Wait for page to be ready (JS check)
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(
            webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete")
        );
        
        // 2. Find element with explicit wait
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(searchInput));
        
        // 3. Clear and type
        element.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
        element.sendKeys(keyword);
    }

    public void clickSearchButton() {
        wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
    }

    public void clickResetButton() {
        wait.until(ExpectedConditions.elementToBeClickable(resetButton)).click();
    }

    // Individual Input Methods for the Step Definitions
    public void inputNama(String name) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(inputNama));
        element.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
        element.sendKeys(name);
    }

    public void inputEligible(String num) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(inputEligible));
        element.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
        element.sendKeys(num);
    }

    public void inputTglBatas(String date) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(inputTglBatas));
        element.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
        element.sendKeys(date);
    }

    public void inputBulanBatas(String date) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(inputBulanBatas));
        element.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
        element.sendKeys(date);
    }

    public void inputMaxSisa(String num) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(inputMaxSisa));
        element.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
        element.sendKeys(num);
    }

    public void inputBulanKerja(String num) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(inputBulanKerja));
        element.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
        element.sendKeys(num);
    }

    public void inputMinimKerja(String num) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(inputMinimKerja));
        element.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
        element.sendKeys(num);
    }

    public void inputTotalCuti(String num) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(inputTotalCuti));
        element.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
        element.sendKeys(num);
    }
 
    public void saveAturan() {
         WebElement element = wait.until(ExpectedConditions.elementToBeClickable(btnTambah));
            try {
                element.click();
            } catch (Exception e) {
                // Fallback to JS Click if the element is intercepted
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
            }
    }

    public void saveAturanDialog() {
    // 1. Wait for the button on the modal to be clickable
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(btnTambahModal));
        
        try {
            element.click();
        } catch (Exception e) {
            // Fallback for MUI overlay issues
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        }

        // 2. IMPORTANT: Wait for the dialog to close so your eyes (and Selenium) 
        // know the "Create" process is actually done.
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@role='dialog']")));
    }

    public void clickSimpan() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(btnTambahModal));
        element.click();
    }

    // Reusable typing method with Clear-First logic
    private void type(By locator, String value) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.click(); // Focus the field
        element.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
        
        // Only send keys if the value isn't empty
        if (value != null && !value.isEmpty()) {
            element.sendKeys(value);
        }
    }

    public void saveAturanDel() {
         WebElement element = wait.until(ExpectedConditions.elementToBeClickable(btnHapus));
            try {
                element.click();
            } catch (Exception e) {
                // Fallback to JS Click if the element is intercepted
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
            }
    }

    public String getErrorMessage() {
        try {
            // Updated XPath to catch MUI helper text, alerts, and general error classes
            By errorLocator = By.xpath("//p[contains(@class, 'Mui-error')] | //div[@role='alert'] | //span[contains(@class, 'error')]");
            
            // Increased wait slightly and added visibility check
            WebElement error = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(errorLocator));
                
            return error.getText();
        } catch (Exception e) {
            // This is what you are seeing in your log currently
            return "No error message found"; 
        }
    }
}   