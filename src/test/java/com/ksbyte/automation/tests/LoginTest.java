package com.ksbyte.automation.tests;

import com.ksbyte.automation.tests.base.BaseTest;
import com.ksbyte.automation.pages.LoginPage;
import com.ksbyte.automation.utils.ConfigReader;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class LoginTest extends BaseTest {

    @Test
    public void verifyLogin() throws InterruptedException {

        driver.get(ConfigReader.get("baseUrl"));
        Thread.sleep(3000);

        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterEmail(ConfigReader.get("email"));
        loginPage.enterPassword(ConfigReader.get("password"));
        loginPage.clickLogin();
//        System.out.println("clicking login.");
//        Thread.sleep(10000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.urlToBe("https://dashboard.fleetease.ai/dashboard"));

        Assert.assertTrue(driver.getCurrentUrl().contains("/dashboard"));
        Thread.sleep(5000);
        driver.switchTo().activeElement().sendKeys(Keys.ENTER);
    }
}