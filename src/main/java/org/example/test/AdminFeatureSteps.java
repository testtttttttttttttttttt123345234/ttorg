package org.example.test;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.AdminEntity;

import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AdminFeatureSteps {
    boolean accepted = false;
    boolean rejected = false;
    private static final String ADMIN = "admin";
    boolean loggedIn = true;

    boolean loggedOut = false;
    public AdminFeatureSteps(AdminEntity obj){
        super();
        this.obj = obj;
    }

    AdminEntity obj;
    @Given("admin logged in with {string} as username and {string} as password and dashboard appears")
    public void adminLoggedInWithAsUsernameAndAsPasswordAndDashboardAppears(String string, String string2) throws SQLException {
        assertEquals(ADMIN, obj.checkValues(string, string2));
    }

    @And("selected {string} from dashboard to see the pending housings using function pending housings")
    public void selectedFromDashboardToSeeThePendingHousingsUsingFunctionPendingHousings(String string) throws SQLException {
        if(string.equals("1"))
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
    public void housingAccepted() {
        assertTrue(accepted);
    }



    @Given("admin logged in with {string} as username and {string} as password then dashboard appears")
    public void adminLoggedInWithAsUsernameAndAsPasswordThenDashboardAppears(String string, String string2) throws SQLException {
        assertEquals(ADMIN, obj.checkValues(string, string2));
    }
    @Given("selected {string} from dashboard and see the pending housings")
    public void selectedFromDashboardAndSeeThePendingHousings(String string) throws SQLException {
        if(string.equals("1"))
            assertTrue(obj.pendingHousings());
    }
    @And("entered {string} to select pending housing and Selected {string} to accept the housing")
    public void enteredToSelectPendingHousingAndSelectedToAcceptTheHousing(String arg0, String arg1) throws SQLException {
        if(arg0.equals("12")){
            rejected = true;  assertTrue(obj.acceptRejectHousing(arg0, arg1));
        }
    }
    @Then("housing rejected")
    public void housingRejected() {assertTrue(rejected);}




    @Given("admin pressed {string} to show housing reservations")
    public void adminPressedToShowHousingReservations(String string) {
        assertEquals("2", string);
    }
    @Given("admin is logged in with {string} and {string}")
    public void adminIsLoggedInWithAnd(String string, String string2) throws SQLException {
        assertEquals(ADMIN,obj.checkValues(string, string2));
    }
    @Then("housing reservations appears using function showReservations with many database Queries to print all information")
    public void housingReservationsAppearsUsingFunctionShowReservationsWithManyDatabaseQueriesToPrintAllInformation() throws SQLException{
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