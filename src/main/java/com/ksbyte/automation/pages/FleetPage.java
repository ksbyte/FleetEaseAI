package com.ksbyte.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class FleetPage {

    WebDriver driver;
    public FleetPage(WebDriver driver) { this.driver = driver; }

    By fleetHeading = By.xpath("//h1[contains(text(),'Fleet Management')]");
    By searchBox = By.xpath("//input[contains(@placeholder,'Search')]");

    public boolean isFleetPageLoaded(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(fleetHeading));
        return driver.findElement(fleetHeading).isDisplayed();
    }

    public void searchFleet(String fleetName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement search = wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox));
        search.clear();
        search.sendKeys(fleetName);
    }
}
