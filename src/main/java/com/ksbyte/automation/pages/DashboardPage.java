package com.ksbyte.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class DashboardPage {

    WebDriver driver;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public String getTitle() {
        return driver.getTitle();
    }

    By dashboardHeading = By.xpath("//h1[contains(text(),'Dashboard')]");
    By totalFleetCount = By.xpath("//p[contains(text(),'Total Fleet')]/preceding-sibling::p");
    By totalOnRide = By.xpath("//p[contains(text(),'On Ride')]/preceding-sibling::p");
    By totalRFA = By.xpath("//p[contains(text(),'Ready for Allotment')]/preceding-sibling::p");
    By totalUM = By.xpath("//p[contains(text(),'Under Maintenance')]/preceding-sibling::p");
    By totalRideEnd = By.xpath("//p[contains(text(),'Ride End')]/preceding-sibling::p");

    public boolean isDashboardLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardHeading));
        return driver.findElement(dashboardHeading).isDisplayed();
    }
    public String getTotalFleetCount() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(totalFleetCount));
        return driver.findElement(totalFleetCount).getText();
    }
    public String getOnRideCount() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(totalOnRide));
        return driver.findElement(totalOnRide).getText();
    }
    public String getRFACount() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(totalRFA));
        return driver.findElement(totalRFA).getText();
    }
    public String getUMCount() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(totalUM));
        return driver.findElement(totalUM).getText();
    }
    public String getRideEndCount() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(totalRideEnd));
        return driver.findElement(totalRideEnd).getText();
    }
}
