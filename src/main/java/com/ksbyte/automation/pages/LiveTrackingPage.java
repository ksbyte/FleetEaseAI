package com.ksbyte.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.awt.SystemColor.menu;

public class LiveTrackingPage {

    WebDriver driver;

    public LiveTrackingPage(WebDriver driver) {
        this.driver = driver;
    }


    By liveTrackingMenu = By.xpath("//span[contains(text(),'Live Tracking')]");
    By liveTrackingHeading = By.xpath("//h1[contains(text(),'Live Tracking')]");

    public boolean isLiveTrackingLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(liveTrackingHeading));
        return driver.findElement(liveTrackingHeading).isDisplayed();
    }

    By onRideCount = By.xpath("//span[contains(text(),'On Ride')]/preceding-sibling::span");
    By idleCount = By.xpath("//span[contains(text(),'Idle')]/preceding-sibling::span");
    By disconnectedCount = By.xpath("//span[contains(text(),'Disconnected')]/preceding-sibling::span");
    By firstVehicle = By.xpath("//span[contains(text(),'WARS98901')]");
    By vehicleLocation = By.xpath("//a[contains(@href,'maps?q=')]/preceding-sibling::p[1]");

    public String getOnRideCount() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(onRideCount));
        return driver.findElement(onRideCount).getText();
    }

    public String getidleCount() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(idleCount));
        return driver.findElement(idleCount).getText();
    }

    public String getdisconnectedCount() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(disconnectedCount));
        return driver.findElement(disconnectedCount).getText();
    }

    public void clickFirstVehicle() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(firstVehicle)).click();
    }

    public String getVehicleLocation() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(vehicleLocation));
        return driver.findElement(vehicleLocation).getText();
    }
}
