package org.example.test;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.OwnerEntity;


import java.sql.SQLException;

import static org.junit.Assert.*;

public class OwnerFeatureSteps {

    public OwnerFeatureSteps(OwnerEntity obj){
        super();
        this.obj = obj;
    }
    OwnerEntity obj;
    boolean ownerFlag = true;
    boolean loggedOut = false;
    boolean department = false;
    boolean photo = false;
    boolean services = false;
    boolean price = false;
    boolean locationInfo = false;
    @Given("owner wants to login and add a residence")
    public void ownerWantsToLoginAndAddAResidence(){
        assertTrue(true);
    }
    @Given("owner enters {string} as username and {string} as a password")
    public void ownerEntersAsUsernameAndAsAPassword(String userName, String passWord) throws SQLException {
        ownerFlag = true;
        assertEquals("owner", obj.checkValues(userName, passWord));
    }
    @Then("owner logged in with {string} as username and {string} as a password and dashboard appears and adding list appears")
    public void ownerLoggedInWithAsUsernameAndAsAPasswordAndDashboardAppearsAndAddingListAppears(String userName, String passWord) {
        assertTrue(ownerFlag);
    }



    @Given("owner is logged in with username {string} and  password {string} and selected {string} for housing then selected {string} to add housing.")
    public void ownerIsLoggedInWithUsernameAndPasswordAndSelectedForHousingThenSelectedToAddHousing(String string, String string2, String string3, String string4) {
        if(ownerFlag)
            assertTrue(string3.equals("1") && string4.equals("1"));
    }
    @And("enters {string} as department name using function departmentName")
    public void entersAsDepartmentNameUsingFunctionDepartmentName(String string) throws SQLException {
        if (obj.departmentName(string)) {
            department = true;assertTrue(true);}
    }
    @Then("department added successfully for owner {string}")
    public void departmentAddedSuccessfullyForOwner(String string) {assertTrue(department);}



    @Given("owner is logged in with username {string} and  password {string} and selected {string} for housing then selected {string} for add housing")
    public void ownerIsLoggedInWithUsernameAndPasswordAndSelectedForHousingThenSelectedForAddHousing(String string, String string2, String string3, String string4) throws SQLException {
        if(ownerFlag) {
            assertTrue(string3.equals("1") && string4.equals("1"));
            obj.addHousing(string);
        }
    }
    @And("adding to the housing options appears and owner added {string} by function addPhoto")
    public void addingToTheHousingOptionsAppearsAndOwnerAddedPhotoByFunctionAddPhoto(String photoLink) throws SQLException {
        if(obj.addPhoto(photoLink))
        {photo = true;
            assertTrue(true);} else assertFalse(true);
    }
    @Then("photo added successfully for owner {string}")
    public void photoAddedSuccessfullyForOwner(String string) {
        assertTrue(photo);
    }


    @Given("owner is logged in with username {string} and  password {string} and selected {string} for housing and {string} for add housing")
    public void ownerIsLoggedInWithUsernameAndPasswordAndSelectedForHousingAndForAddHousing(String string, String string2, String string3, String string4) {
        if(ownerFlag)
            assertTrue(string3.equals("1")&&string4.equals("1"));
    }

    @And("adding to the housing options appears and owner entered {string} as location and information by function addLocationInfo")
    public void addingToTheHousingOptionsAppearsAndOwnerEnteredAsLocationAndInformationByFunctionAddLocationInfo(String string) throws SQLException {
        locationInfo = true;assertTrue(obj.addLocationInfo(string));
    }
    @Then("location and information added successfully for owner {string}")
    public void locationAndInformationAddedSuccessfullyForOwner(String string) {
        assertTrue(locationInfo);
    }



    @Given("owner is logged in with username {string} and  password {string} then selected {string} for housing and {string} for add housing")
    public void ownerIsLoggedInWithUsernameAndPasswordThenSelectedForHousingAndForAddHousing(String string, String string2, String string3, String string4) {
        if(ownerFlag)
            assertTrue(string3.equals("1")&&string4.equals("1"));
    }
    @And("adding to the housing options appears and owner entered {string} as services by function addServices")
    public void addingToTheHousingOptionsAppearsAndOwnerEnteredAsServicesByFunctionAddServices(String string) throws SQLException {
        services = true;assertTrue(obj.addServices(string));
    }
    @Then("services added successfully for owner {string}")
    public void servicesAddedSuccessfullyForOwner(String string) {
        assertTrue(services);
    }



    @Given("owner is logged in with username {string},  password {string} and selected {string} for housing and {string} for add housing")
    public void ownerIsLoggedInWithUsernamePasswordAndSelectedForHousingAndForAddHousing(String string, String string2, String string3, String string4) {
        if(ownerFlag)
            assertTrue(string3.equals("1")&&string4.equals("1"));
    }
    @And("adding to the housing options appears and owner entered {string} as monthly rent by function addPrice")
    public void addingToTheHousingOptionsAppearsAndOwnerEnteredAsMonthlyRentByFunctionAddPrice(String string) throws SQLException {
        price = true;
        assertTrue(obj.addPrice(string));
    }
    @Then("monthly rent added successfully for owner {string}")
    public void monthlyRentAddedSuccessfullyForOwner(String string) {
        assertTrue(price);
    }



    @Given("owner logged in")
    public void ownerLoggedIn() {
        assertTrue(ownerFlag);
    }
    @Given("dashboard appears then selected {string} for housing then selected {string} for show housings full information using two queries from database")
    public void dashboardAppearsThenSelectedForHousingThenSelectedForShowHousingsFullInformationUsingTwoQueriesFromDatabase(String housing, String showHousings) {
        if(ownerFlag)
            assertTrue(housing.equals("1")&&showHousings.equals("2"));
    }
    @Then("housings and contact information appears for owner {string}")
    public void housingsAndContactInformationAppearsForOwner(String owner) throws SQLException {
        assertTrue(obj.showHousings(owner));
    }



    @Given("owner is logged in")
    public void ownerIsLoggedIn() {
        assertTrue(ownerFlag);
    }
    @Given("selected {string} from the dashboard")
    public void selectedFromTheDashboard(String logout) {
        if(ownerFlag&&logout.equals("2")){
            assertEquals("2", logout);
            loggedOut = true;
        }
    }
    @Then("owner logged out successfully")
    public void ownerLoggedOutSuccessfully() {
        assertTrue(loggedOut);
    }


}