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

    //        Ride metrices today
    By onRideToday = By.xpath("/html/body/div[2]/main/div/div[1]/div[2]/div/div[1]/div/div[2]/p[1]");
    By rideEndToday = By.xpath("/html/body/div[2]/main/div/div[1]/div[2]/div/div[2]/div/div[2]/p[1]");
    By endRideCompToday = By.xpath("/html/body/div[2]/main/div/div[1]/div[2]/div/div[3]/div/div[2]/p[1]");
    By motorLockToday = By.xpath("/html/body/div[2]/main/div/div[1]/div[2]/div/div[4]/div/div[2]/p[1]");
    By liveTrackingMenu = By.xpath("//span[contains(text(),'Live Tracking')]");


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

    //        Ride metrices today
    public String getOnRideMetricesToday() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(onRideToday));
        return driver.findElement(onRideToday).getText();
    }
    public String getRideEndReqToday() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(rideEndToday));
        return driver.findElement(rideEndToday).getText();
    }
    public String getRECompToday() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(endRideCompToday));
        return driver.findElement(endRideCompToday).getText();
    }
    public String getMotorLockToday() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(motorLockToday));
        return driver.findElement(motorLockToday).getText();
    }

    public void clickLiveTracking() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(liveTrackingMenu));
        driver.findElement(liveTrackingMenu).click();
    }

}
