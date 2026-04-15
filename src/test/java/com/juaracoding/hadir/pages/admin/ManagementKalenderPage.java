package com.juaracoding.hadir.pages.admin;

import com.juaracoding.hadir.base.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ManagementKalenderPage extends BasePage {

    private WebDriverWait wait;

    public ManagementKalenderPage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // ===== LOCATORS (Using By) =====
    private By searchInput = By.xpath("//input[@id='search' or @placeholder='Cari...' or @type='text']");
    private By searchButton = By.xpath("//button[.='Search']");
    private By resetButton = By.xpath("//button[.='Reset']");
    private By btnTambahKalender = By.xpath("//button[contains(text(),'Tambahkan Kalender')]");
    private By inputKalenderName = By.xpath("//input[@id='name' or @placeholder='Kelender Unit']");
    private By btnSimpan = By.xpath("//button[contains(text(),'Simpan') or contains(text(),'Tambah') or contains(text(), 'Ya')]");
    private By kalenderTable = By.xpath("//table");
    private By successMessage = By.xpath("//*[contains(text(),'Berhasil')]");
    private By inputTanggal = By.xpath("//input[@placeholder='mm/dd/yyyy']");
    private By inputTipeCuti = By.id("type");
    private By inputDeskripsi = By.xpath("//input[@id='description' or @placeholder='Disrkipsi libur atau event']");
    private By btnTambahModal = By.xpath("//div[@role='dialog']//button[contains(text(),'Tambah') or contains(text(), 'Simpan') or contains(text(), 'Ya')]");

    // ================= ACTIONS =================

    public void openPage() {
        driver.get("https://magang.dikahadir.com/management/calendar");
        // Ensure we are not redirected to login
        wait.until(ExpectedConditions.urlContains("management/calendar"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchInput));
    }

    public void waitForPageLoad() {
    wait.until(webDriver -> ((JavascriptExecutor) webDriver)
        .executeScript("return document.readyState").equals("complete"));
    }

    public boolean isKalenderTableDisplayed() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(kalenderTable)).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    // ===== SEARCH FLOW =====
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

    // ===== ADD =====
    public void clickTambahKalender() {
        // 1. Wait for any existing backdrops/modals to disappear first
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("MuiBackdrop-root")));
        
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Tambahkan Kalender')]")));
        
        try {
            element.click();
        } catch (Exception e) {
            // 2. Fallback: Use JS Click to bypass the Backdrop overlay if standard click is still blocked
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        }
    }

    public void clickTambahKalenderDetail() {
        By modalTitle = By.xpath("//h2[contains(text(),'Tambah Tanggal Cuti')]");
        
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("MuiBackdrop-root")));

        int attempts = 0;
        boolean isModalOpen = false;

        while (attempts < 3 && !isModalOpen) {
            try {
                WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Tambahkan Kalender')]")));
                
                // Try standard click
                element.click();
                
                // VERIFICATION: Wait a moment to see if the modal appears
                wait.until(ExpectedConditions.visibilityOfElementLocated(modalTitle));
                isModalOpen = true; 
            } catch (Exception e) {
                // If standard click failed to open the modal, use JS Click
                WebElement element = driver.findElement(By.xpath("//button[contains(text(),'Tambahkan Kalender')]"));
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
                
                try {
                    wait.until(ExpectedConditions.visibilityOfElementLocated(modalTitle));
                    isModalOpen = true;
                } catch (TimeoutException te) {
                    attempts++;
                }
            }
        }
    }

    public void inputKalenderName(String name) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(inputKalenderName));
        element.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
        element.sendKeys(name);
    }

    public void saveKalender() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(btnSimpan));
            try {
                element.click();
            } catch (Exception e) {
                // Fallback to JS Click if the element is intercepted
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
            }
    }

    public boolean isSuccessMessageDisplayed() {
        try {
            // We use visibilityOfElementLocated to ensure we wait up to 10 seconds 
            // for the pop-up to actually show up.
            return wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage)).isDisplayed();
        } catch (TimeoutException e) {
            System.out.println("Success message was not found within 10 seconds.");
            return false;
        }
    }

    // ===== EDIT =====
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
        // 1. Wait for the menu container to be present in the DOM
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[@role='menu']")));

        // 2. Use an XPath that specifically looks for the MenuItem role seen in your screenshot
        // Using normalize-space() to remove any hidden newline characters around "View"
        String robustXpath = "//li[@role='menuitem' and normalize-space()='" + option + "']";
        
        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(robustXpath)));
            
            // 3. Use JavaScript Click
            // This bypasses the tabindex differences and any 'ripple' overlays
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        } catch (Exception e) {
            // Fallback: If "View" specifically fails, try clicking by index if it's always the first item
            if (option.equalsIgnoreCase("View")) {
                WebElement firstItem = driver.findElement(By.xpath("(//li[@role='menuitem'])[1]"));
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", firstItem);
            } else {
                throw e;
            }
        }
    }

    public void inputTanggal(String date) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(inputTanggal));
        element.click();
        element.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
        element.sendKeys(date);
    }

    public void selectTipeCuti(String optionText) {
        // Click the combobox to reveal the options
        WebElement combobox = wait.until(ExpectedConditions.elementToBeClickable(inputTipeCuti));
        combobox.click();

        // Find the specific option in the list that appears
        // MUI usually renders these as <li> with role='option'
        By targetOption = By.xpath("//li[@role='option' and contains(text(), '" + optionText + "')]");
        wait.until(ExpectedConditions.elementToBeClickable(targetOption)).click();
    }

    public void inputDeskripsi(String description) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(inputDeskripsi));
        element.clear();
        element.sendKeys(description);
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

    public void clickSimpan() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(btnTambahModal));
        element.click();
    }

    public void inputNama(String name) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(inputKalenderName));
        element.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
        element.sendKeys(name);
    }

}