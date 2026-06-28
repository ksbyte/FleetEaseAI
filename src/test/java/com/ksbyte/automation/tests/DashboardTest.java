package com.ksbyte.automation.tests;

import com.ksbyte.automation.base.BaseTest;
import com.ksbyte.automation.pages.DashboardPage;
import com.ksbyte.automation.pages.LoginPage;
import com.ksbyte.automation.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {

    @Test
    public void verifyDashboardLoaded() {

        driver.get(ConfigReader.get("baseUrl"));

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail(ConfigReader.get("email"));
        loginPage.enterPassword(ConfigReader.get("password"));
        loginPage.clickLogin();

        DashboardPage dashboardPage = new DashboardPage(driver);
        String totalFleet = dashboardPage.getTotalFleetCount();
        System.out.println("Total Fleet: " + totalFleet);

        String totalOnRide = dashboardPage.getOnRideCount();
        System.out.println("Total onRide: " + totalOnRide);

        String rfaCount = dashboardPage.getRFACount();
        System.out.println("Total rfa: " + rfaCount);

        String umCount = dashboardPage.getUMCount();
        System.out.println("Total um: " + umCount);

        String rideEndCount = dashboardPage.getRideEndCount();
        System.out.println("Total rideEnd: " + rideEndCount);

        Assert.assertTrue(dashboardPage.isDashboardLoaded());
        Assert.assertFalse(totalFleet.isEmpty());
        Assert.assertTrue(totalFleet.matches("\\d+"));
    }
}
