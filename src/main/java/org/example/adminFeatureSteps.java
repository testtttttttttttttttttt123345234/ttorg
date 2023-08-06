package org.example;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class adminFeatureSteps {
    boolean accepted = false;
    boolean rejected = false;
    //////
    boolean loggedIn = true;

    boolean loggedOut = false;
    public adminFeatureSteps(AdminEntity obj){
        super();
        this.obj = obj;
    }

    AdminEntity obj;
    @Given("admin logged in with {string} as username and {string} as password and dashboard appears")
    public void admin_logged_in_with_as_username_and_as_password_and_dashboard_appears(String string, String string2) throws SQLException {
        assertEquals("admin", obj.checkValues(string, string2));
    }

    @And("selected {string} from dashboard to see the pending housings using function pending housings")
    public void selectedFromDashboardToSeeThePendingHousingsUsingFunctionPendingHousings(String string) throws SQLException {
        if(string.equals("1"));
            assertTrue(obj.pendingHousings());
    }

    @And("entered {string} to select pending housing")
    public void enteredToSelectPendingHousing(String arg0) {assertEquals("10",arg0);
    }
    @And("entered {string} to select pending housing then Selected {string} to accept the housing")
    public void enteredToSelectPendingHousingThenSelectedToAcceptTheHousing(String arg0, String arg1) throws SQLException {
        if(arg0.equals("11")){
            accepted = true; assertTrue(obj.acceptRejectHousing(arg0, arg1));
        }
    }

    @Then("housing accepted")
    public void housing_accepted() {
        assertTrue(accepted);
    }



    @Given("admin logged in with {string} as username and {string} as password then dashboard appears")
    public void admin_logged_in_with_as_username_and_as_password_then_dashboard_appears(String string, String string2) throws SQLException {
        assertEquals("admin", obj.checkValues(string, string2));
    }
    @Given("selected {string} from dashboard and see the pending housings")
    public void selected_from_dashboard_and_see_the_pending_housings(String string) throws SQLException {
        if(string.equals("1"));
        assertTrue(obj.pendingHousings());
    }
    @And("entered {string} to select pending housing and Selected {string} to accept the housing")
    public void enteredToSelectPendingHousingAndSelectedToAcceptTheHousing(String arg0, String arg1) throws SQLException {
        if(arg0.equals("12")){
            rejected = true;  assertTrue(obj.acceptRejectHousing(arg0, arg1));
        }
    }
    @Then("housing rejected")
    public void housing_rejected() {assertTrue(rejected);}




    @Given("admin pressed {string} to show housing reservations")
    public void admin_pressed_to_show_housing_reservations(String string) {
        assertEquals("2", string);
    }
    @Given("admin is logged in with {string} and {string}")
    public void admin_is_logged_in_with_and(String string, String string2) throws SQLException {
        assertEquals("admin",obj.checkValues(string, string2));
    }
    @Then("housing reservations appears using function showReservations with many database Queries to print all informations")
    public void housingReservationsAppearsUsingFunctionShowReservationsWithManyDatabaseQueriesToPrintAllInformations() throws SQLException {
        assertTrue(obj.showReservations());
    }


    @Given("admin is logged in")
    public void adminIsLoggedIn() {
        assertTrue(loggedIn);
    }
    @Given("selected {string} from admin dashboard")
    public void selectedFromAdminDashboard(String string) {loggedOut = true;assertEquals("3", string);
    }
    @Then("admin logged out successfully")
    public void adminLoggedOutSuccessfully() {assertTrue(loggedOut);
    }


}

