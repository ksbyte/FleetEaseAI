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

}
