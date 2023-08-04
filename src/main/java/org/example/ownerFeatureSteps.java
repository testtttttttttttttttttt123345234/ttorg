package org.example;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.ownerEntity;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class ownerFeatureSteps {

    public ownerFeatureSteps(ownerEntity obj){
        super();
        this.obj = obj;
    }
    ownerEntity obj;
    boolean ownerFlag = true;
    boolean loggedOut = false;
    boolean department = false;
    boolean photo = false;
    boolean contactInfo = false;
    boolean services = false;
    boolean price = false;
    boolean locationInfo = false;
    @Given("owner wants to login and add a residence")
    public void owner_wants_to_login_and_add_a_residence(){
        assertTrue(true);
    }
    @Given("owner enters {string} as username and {string} as a password")
    public void owner_enters_as_username_and_as_a_password(String Username, String Password){
            ownerFlag = true;
            assertEquals("owner", obj.checkValues(Username, Password));
    }
    @Then("owner logged in with {string} as username and {string} as a password and dashboard appears and adding list appears")
    public void owner_logged_in_with_as_username_and_as_a_password_and_dashboard_appears_and_adding_list_appears(String Username, String Password) {
        assertTrue(ownerFlag);
    }



    @Given("owner is logged in with username {string} and  password {string} and selected {string} for housing then selected {string} to add housing.")
    public void owner_is_logged_in_with_username_and_password_and_selected_for_housing_then_selected_to_add_housing(String string, String string2, String string3, String string4) {
            if(ownerFlag)
                assertTrue(string3.equals("1") && string4.equals("1"));
    }
    @And("enters {string} as department name using function departmentName")
    public void entersAsDepartmentNameUsingFunctionDepartmentName(String string) {
        if (obj.departmentName(string)) {
            department = true;assertTrue(true);} else assertFalse(true);
    }
    @Then("department added successfully for owner {string}")
    public void department_added_successfully_for_owner(String string) {assertTrue(department);}



    @Given("owner is logged in with username {string} and  password {string} and selected {string} for housing then selected {string} for add housing")
    public void owner_is_logged_in_with_username_and_password_and_selected_for_housing_then_selected_for_add_housing(String string, String string2, String string3, String string4) throws SQLException {
        if(ownerFlag) {
            assertTrue(string3.equals("1") && string4.equals("1"));
            obj.addHousing(string);
        }
    }
    @And("adding to the housing options appears and owner added {string} by function addPhoto")
    public void addingToTheHousingOptionsAppearsAndOwnerAddedPhotoByFunctionAddPhoto(String photoLink) {
        if(obj.addPhoto(photoLink))
        {photo = true;
            assertTrue(true);} else assertFalse(true);
    }
    @Then("photo added successfully for owner {string}")
    public void photo_added_successfully_for_owner(String string) {
            assertTrue(photo);
    }


    @Given("owner is logged in with username {string} and  password {string} and selected {string} for housing and {string} for add housing")
    public void owner_is_logged_in_with_username_and_password_and_selected_for_housing_and_for_add_housing(String string, String string2, String string3, String string4) {
        if(ownerFlag)
            assertTrue(string3.equals("1")&&string4.equals("1"));
    }

    @And("adding to the housing options appears and owner entered {string} as location and information by function addLocationInfo")
    public void addingToTheHousingOptionsAppearsAndOwnerEnteredAsLocationAndInformationByFunctionAddLocationInfo(String string) {
            locationInfo = true;assertTrue(obj.addLocationInfo(string));
    }
    @Then("location and information added successfully for owner {string}")
    public void location_and_information_added_successfully_for_owner(String string) {
        assertTrue(locationInfo);
    }



    @Given("owner is logged in with username {string} and  password {string} then selected {string} for housing and {string} for add housing")
    public void owner_is_logged_in_with_username_and_password_then_selected_for_housing_and_for_add_housing(String string, String string2, String string3, String string4) {
        if(ownerFlag)
            assertTrue(string3.equals("1")&&string4.equals("1"));
    }
    @And("adding to the housing options appears and owner entered {string} as services by function addServices")
    public void addingToTheHousingOptionsAppearsAndOwnerEnteredAsServicesByFunctionAddServices(String string) {
            services = true;assertTrue(obj.addServices(string));
    }
    @Then("services added successfully for owner {string}")
    public void services_added_successfully_for_owner(String string) {
            assertTrue(services);
    }



    @Given("owner is logged in with username {string},  password {string} and selected {string} for housing and {string} for add housing")
    public void owner_is_logged_in_with_username_password_and_selected_for_housing_and_for_add_housing(String string, String string2, String string3, String string4) {
        if(ownerFlag)
            assertTrue(string3.equals("1")&&string4.equals("1"));
    }
    @And("adding to the housing options appears and owner entered {string} as monthly rent by function addPrice")
    public void addingToTheHousingOptionsAppearsAndOwnerEnteredAsMonthlyRentByFunctionAddPrice(String string) {
            price = true;
            assertTrue(obj.addPrice(string));
    }
    @Then("monthly rent added successfully for owner {string}")
    public void monthly_rent_added_successfully_for_owner(String string) {
            assertTrue(price);
    }



    @Given("owner logged in")
    public void owner_logged_in() {
        assertTrue(ownerFlag);
    }
    @Given("dashboard appears then selected {string} for housing then selected {string} for show housings full information using two queries from database")
    public void dashboard_appears_then_selected_for_housing_then_selected_for_show_housings_full_information_using_two_queries_from_database(String housing, String showHousings) {
        if(ownerFlag)
            assertTrue(housing.equals("1")&&showHousings.equals("2"));
    }
    @Then("housings and contact information appears for owner {string}")
    public void housings_and_contact_information_appears_for_owner(String owner) {
        assertTrue(obj.showHousings(owner));
    }



    @Given("owner is logged in")
    public void owner_is_logged_in() {
        assertTrue(ownerFlag);
    }
    @Given("selected {string} from the dashboard")
    public void selected_from_the_dashboard(String logout) {
        if(ownerFlag&&logout.equals("2")){
            assertEquals("2", logout);
            loggedOut = true;
        }
    }
    @Then("owner logged out successfully")
    public void owner_logged_out_successfully() {
        assertTrue(loggedOut);
    }
}
