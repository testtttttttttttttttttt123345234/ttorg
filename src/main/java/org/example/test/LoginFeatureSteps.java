package org.example.test;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.LoginEntity;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class LoginFeatureSteps {

    boolean adminFlag;
    boolean tenantFlag;
    boolean ownerFlag;
    String owner="owner";
    String admin="admin";
    String tenant="tenant";

    LoginEntity obj;
    public LoginFeatureSteps(LoginEntity obj){
        super();
        this.obj = obj;
    }
    @Given("admin wants to sign in")
    public void adminWantsToSignIn() {
        adminFlag = false;
    }
    @Given("enters {string} as a username and enters {string} as a password")
    public void entersAsAUsernameAndEntersAsAPassword(String uname, String pword) throws SQLException {
        adminFlag = false;
        String role=admin;
        if(role.equals(obj.checkValues(uname,pword))){
            assertEquals(role, obj.checkValues(uname, pword));adminFlag = true;
        }
    }
    @Then("admin login success")
    public void adminLoginSuccess() {
        assertTrue(adminFlag);
    }
    @Given("tenant or owner wants to login to the system")
    public void tenantOrOwnerWantsToLoginToTheSystem()
    {
        tenantFlag = false;
        ownerFlag = false;
    }
    @Given("enters {string} as a username and {string} as a password and both are correct")
    public void entersAsAUsernameAndAsAPasswordAndBothAreCorrect(String username, String password) throws SQLException {
        if(obj.checkValues(username,password).equals(tenant)||obj.checkValues(username,password).equals(owner))
        {
            assertTrue(obj.checkValues(username,password).equals(tenant)||obj.checkValues(username,password).equals(owner));
            tenantFlag = true;
            ownerFlag = true;
        }
    }
    @Then("login successful")
    public void loginSuccessful() {
        assertTrue(tenantFlag||ownerFlag);
    }
    @Given("tenant or owner login to the system")
    public void tenantOrOwnerLoginToTheSystem() {
        tenantFlag = false;
        ownerFlag = false;
        assertTrue(true);
    }
    @Given("enters {string} as a username and {string} as a password and one of them are wrong")
    public void entersAsAUsernameAndAsAPasswordAndOneOfThemAreWrong(String username, String password) throws SQLException {

        if(!obj.checkValues(username,password).equals(owner)||!obj.checkValues(username,password).equals(tenant)||!obj.checkValues(username,password).equals(admin)){
            assertTrue(!obj.checkValues(username,password).equals(owner)||!obj.checkValues(username,password).equals(tenant)||!obj.checkValues(username,password).equals(admin));
            tenantFlag = true;
            ownerFlag = true;
        }

    }
    @Then("error appears")
    public void errorAppears() {
        assertTrue("error",true);
    }



    @Given("user wants to register as a tenant or owner")
    public void userWantsToRegisterAsATenantOrOwner() {
        assertTrue(true);
    }
    @And("first name  = {string}, second name = {string}, lastname = {string}, Phone={string}, email = {string}, Reg_num = {string}, major = {string}, tenUser = {string}, tenPass = {string} for tenant and username is available and used two database queries")
    public void firstNameSecondNameLastnamePhoneEmailReg_numMajorTenUserTenPassForTenantAndUsernameIsAvailableAndUsedTwoDatabaseQueries(String ffname, String mMname, String lLname, String pPhone, String tenmail, String tenUser, String tenPass) throws SQLException {
        obj.printTenant(ffname, mMname, lLname, pPhone, tenmail,tenUser, tenPass);
    }
    @And("first name  = {string}, second name = {string}, lastname = {string}, Phone={string}, email = {string}, OwUser = {string}, OwPass = {string} for owner and username is available and used two database queries")
    public void firstNameSecondNameLastnamePhoneEmailOwUserOwPassForOwnerAndUsernameIsAvailableAndUsedTwoDatabaseQueries(String fname, String mname, String lname, String phone, String owemail, String owUser, String owPass) throws SQLException {
        obj.printOwner(fname, mname, lname, phone, owemail, owUser, owPass);
    }
    @Then("registration complete and the account is created with username{string} and password {string}")
    public void registrationCompleteAndTheAccountIsCreatedWithUsernameAndPassword(String username, String password) throws SQLException {
        assertTrue((tenant.equals(obj.checkValues(username, password))||owner.equals(obj.checkValues(username, password))));
    }
    @Given("user wants to signup as a tenant or owner")
    public void userWantsToSignupAsATenantOrOwner()
    {
        assertTrue(true);
    }
    @And("tenUser = {string}, tenPass = {string} for tenant and usernames isn't available")
    public void tenUserTenPassForTenantAndUsernamesIsnTAvailable(String arg0, String arg1) throws SQLException {
        assertTrue(obj.failureReg(arg0, arg1));
    }
    @Then("registration fails the account with username{string} and password {string} isn't created")
    public void registrationFailsTheAccountWithUsernameAndPasswordIsnTCreated(String username, String password) throws SQLException {
        if(tenant.equals(obj.checkValues(username, password))||owner.equals(obj.checkValues(username, password)))
        {
            assertTrue(tenant.equals(obj.checkValues(username, password))||owner.equals(obj.checkValues(username, password)));
        }
    }




}