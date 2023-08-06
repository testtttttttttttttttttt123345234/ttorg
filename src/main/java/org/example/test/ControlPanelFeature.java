package org.example.test;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import productioncode.ControlPanel;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class ControlPanelFeature {

    ControlPanel obj=new ControlPanel();
    boolean loggedIn = false;
    boolean loggedOut = false;

    @Given("tenant choosed {string} to view control panel")
    public void tenantChoosedToViewControlPanelUsernameIs(String string) {

        assertEquals("3", string);

    }
    @Given("the tenant has house booked before username is {string}")
    public void theTenantHasHouseBookedBeforeUsernameIs(String string) throws SQLException {

    assertTrue(obj.isBooked(string));



    }
    @Then("the control panel will appear for tenant username {string}")
    public void theControlPanelWillAppear(String string) throws SQLException {
      assertTrue(obj.displayControlPanel(string));
    }

    @Given("tenant pressed {string} to view the control panel")
    public void tenantPressedToViewTheControlPanel(String arg0) {
        assertEquals("3", arg0);
    }

    @And("the tenant didnt booked before username is {string}")
    public void theTenantDidntBookedBeforeUsernameIs(String arg0) throws SQLException {
assertFalse(obj.isBooked(arg0));
    }

    @Then("the control panel will not appear for tenant username {string}")
    public void theControlPanelWillNotAppearForTenantUsername(String arg0) throws SQLException {
     assertFalse(obj.displayControlPanel(arg0));
    }
    @Given("tenant is logged in")
    public void tenantIsLoggedIn() {
        assertTrue(loggedIn);
    }
    @Given("selected {string} from tenant dashboard")
    public void selectedFromTenantDashboard(String string) {
        assertTrue(string.equals("4"));
        loggedOut = false;
    }
    @Then("tenant logged out successfully")
    public void tenantLoggedOutSuccessfully() {
        assertTrue(loggedOut);
    }


}
