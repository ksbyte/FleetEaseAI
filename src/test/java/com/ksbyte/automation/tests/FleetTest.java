package com.ksbyte.automation.tests;

import com.ksbyte.automation.pages.FleetPage;
import com.ksbyte.automation.tests.base.BaseTest;
import com.ksbyte.automation.pages.DashboardPage;
import com.ksbyte.automation.pages.LiveTrackingPage;
import com.ksbyte.automation.pages.LoginPage;
import com.ksbyte.automation.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FleetTest extends BaseTest {

    @Test
    public void verifyFleetPageLoaded() throws InterruptedException {

        driver.get(ConfigReader.get("baseUrl"));

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail(ConfigReader.get("email"));
        loginPage.enterPassword(ConfigReader.get("password"));
        loginPage.clickLogin();

        DashboardPage dashboardPage = new DashboardPage(driver);
        Assert.assertTrue(dashboardPage.isDashboardLoaded());

        dashboardPage.clickFleetMenu();

//        LiveTrackingPage liveTrackingPage = new LiveTrackingPage(driver);
//        Assert.assertTrue(liveTrackingPage.isLiveTrackingLoaded());
//
//        liveTrackingPage.clickFleetMenu();

        FleetPage fleetPage = new FleetPage(driver);
        Assert.assertTrue(fleetPage.isFleetPageLoaded());

        fleetPage.searchFleet("DL01AB8993");
        Thread.sleep(5000);
    }

}
