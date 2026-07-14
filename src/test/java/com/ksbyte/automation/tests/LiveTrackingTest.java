package com.ksbyte.automation.tests;

import com.ksbyte.automation.base.BaseTest;
import com.ksbyte.automation.pages.DashboardPage;
import com.ksbyte.automation.pages.LiveTrackingPage;
import com.ksbyte.automation.pages.LoginPage;
import com.ksbyte.automation.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LiveTrackingTest extends BaseTest {

    @Test
    public void verifyLiveTrackingLoaded() {

        driver.get(ConfigReader.get("baseUrl"));

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail(ConfigReader.get("email"));
        loginPage.enterPassword(ConfigReader.get("password"));
        loginPage.clickLogin();

        DashboardPage dashboardPage = new DashboardPage(driver);
        Assert.assertTrue(dashboardPage.isDashboardLoaded());

        dashboardPage.clickLiveTrackingMenu();

        LiveTrackingPage liveTrackingPage = new LiveTrackingPage(driver);
        Assert.assertTrue(liveTrackingPage.isLiveTrackingLoaded());
    }

}
