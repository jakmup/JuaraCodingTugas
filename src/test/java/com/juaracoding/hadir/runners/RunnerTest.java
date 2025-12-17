package com.juaracoding.hadir.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
    
    @CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com.juaracoding.hadir.stepdefinitions", "com.juaracoding.hadir.hooks"},
        plugin = {
            "pretty",
            "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        }
    )

    public class RunnerTest extends AbstractTestNGCucumberTests {

    }