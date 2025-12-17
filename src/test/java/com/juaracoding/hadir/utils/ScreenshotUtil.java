package com.juaracoding.hadir.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {
    
    private ScreenshotUtil() {}

    /**
     * @param driver WebDriver instance
     * @param platform admin / mobile
     * @param module absensi / user / jadwal
     * @param status PASS / FAIL
     * @param scenarioName nama scenario
     */

    public static String takeScreenshot(
        WebDriver driver,
        String platform,
        String module,
        String status,
        String scenarioName
    ){

        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);

        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String safeScenarioName = scenarioName.replaceAll("[^a-zA-Z0-9]", "_");
        String fileName ="screenshots/" + platform + "/" + module + "/" + status + "_" + safeScenarioName + "_" + timestamp + ".png";
        File destination = new File("target/screenshots/" + fileName);

        try {
            destination.getParentFile().mkdirs();
            FileUtils.copyFile(sourceFile, destination);
            return destination.getAbsolutePath();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
