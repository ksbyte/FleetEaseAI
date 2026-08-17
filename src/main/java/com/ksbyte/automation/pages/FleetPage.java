package com.ksbyte.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
    By addFleetBtn = By.xpath("//button[contains(text(), '+ Add Fleet')]");
    By rgtNum = By.xpath("//input[@id = 'registrationNumber']");
    By fleetTypeDropdown = By.xpath("//select[@id='fleetType']");
    By bullacartOption = By.xpath("//select[@id='fleetType']/option[@value='58']");
    By selectCity = By.xpath("//select[@id='city']/option[@value='GURGAON']");
    By selectHub = By.xpath("//select[@id='hub']/option[@value='Vintage']");
    By chassisNo = By.xpath("//input[@placeholder='Enter Chassis No.']");
    By imei = By.xpath("//input[@placeholder='Search IMEI...']");
    By saveBtn = By.xpath("//button[contains(text(),'Save Fleet')]");
    By duplicateVehicleMsg = By.xpath("//p[contains(text(),'Vehicle with given number is already present')]");


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

    public void addNewFleet(String regNo, String chasNum, String imeiNo){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(addFleetBtn)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(rgtNum)).sendKeys(regNo);
        wait.until(ExpectedConditions.elementToBeClickable(fleetTypeDropdown)).click();
        wait.until(ExpectedConditions.elementToBeClickable(bullacartOption)).click();
        wait.until(ExpectedConditions.elementToBeClickable(selectCity)).click();
        wait.until(ExpectedConditions.elementToBeClickable(selectHub)).click();

        WebElement chassis = wait.until(ExpectedConditions.visibilityOfElementLocated(chassisNo));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", chassis);
        wait.until(ExpectedConditions.visibilityOfElementLocated(chassisNo)).sendKeys(chasNum);
        wait.until(ExpectedConditions.visibilityOfElementLocated(imei)).sendKeys(imeiNo);
        wait.until(ExpectedConditions.visibilityOfElementLocated(saveBtn)).click();
    }

    public String getDuplicateVehicleMsg(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement msg = wait.until(ExpectedConditions.visibilityOfElementLocated(duplicateVehicleMsg));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", msg);
        return msg.getText();
    }


}
