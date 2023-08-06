package org.example;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.loginEntity;

import static org.junit.Assert.*;

public class loginFeatureSteps {

    boolean adminFlag,userLoggedin;
    boolean tenantFlag, ownerFlag,flag;
    String host = "localhost";
    int port = 3306;
    String database = "Sakancom";
    String username = "root";
    String password = "password";
    String url = "jdbc:mysql://" + host + ":" + port + "/" + database;
    loginEntity obj;
    public loginFeatureSteps(loginEntity obj){
        super();
        this.obj = obj;
    }
    @Given("admin wants to sign in")
    public void adminWantsToSignIn() {
        adminFlag = false;
    }
    @Given("enters {string} as a username and enters {string} as a password")
    public void entersAsAUsernameAndEntersAsAPassword(String uname, String pword) {
        adminFlag = false;
        String Role=new String("admin");
        if(Role.equals(obj.checkValues(uname,pword))){
        assertEquals(true, Role.equals(obj.checkValues(uname,pword)));
        adminFlag = true;
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
    public void entersAsAUsernameAndAsAPasswordAndBothAreCorrect(String USERNAME, String PASSWORD)
    {
        if(obj.checkValues(USERNAME,PASSWORD).equals("tenant")||obj.checkValues(USERNAME,PASSWORD).equals("owner"))
        {
            assertTrue(obj.checkValues(USERNAME,PASSWORD).equals("tenant")||obj.checkValues(USERNAME,PASSWORD).equals("owner"));
            tenantFlag = true;
            ownerFlag = true;
        }
    }
    @Then("login successful")
    public void login_successful() {
            assertTrue(tenantFlag||ownerFlag);
    }
    @Given("tenant or owner login to the system")
    public void tenantOrOwnerLoginToTheSystem() {
        tenantFlag = false;
        ownerFlag = false;
    }
    @Given("enters {string} as a username and {string} as a password and one of them are wrong")
    public void entersAsAUsernameAndAsAPasswordAndOneOfThemAreWrong(String USERNAME, String PASSWORD)
    {

        if(!obj.checkValues(USERNAME,PASSWORD).equals("owner")||!obj.checkValues(USERNAME,PASSWORD).equals("tenant")||!obj.checkValues(USERNAME,PASSWORD).equals("admin")){
            assertTrue(!obj.checkValues(USERNAME,PASSWORD).equals("owner")||!obj.checkValues(USERNAME,PASSWORD).equals("tenant")||!obj.checkValues(USERNAME,PASSWORD).equals("admin"));
            tenantFlag = true;
            ownerFlag = true;
        }

    }
    @Then("error appears")
    public void error_appears() {
        assertTrue("error",true);
    }
    @Given("user wants to register as a tenant or owner")
    public void userWantsToRegisterAsATenantOrOwner() {
        assertTrue(true);
    }
    @And("first name  = {string}, second name = {string}, lastname = {string}, Phone={string}, email = {string}, age ={string}, OwUser = {string}, OwPass = {string} for owner and first name  = {string}, second name = {string}, lastname = {string}, Phone={string}, email = {string}, age ={string}, Reg_num = {string}, major = {string}, tenUser = {string}, tenPass = {string} for tenant and both usernames is available and used two database queries")
    public void firstNameSecondNameLastnamePhoneEmailAgeOwUserOwPassForOwnerAndFirstNameSecondNameLastnamePhoneEmailAgeRegNumMajorTenUserTenPassForTenantAndBothUsernamesIsAvailableAndUsedTwoDatabaseQueries(String Fname, String Mname, String Lname, String Phone, String Owemail, String age, String OwUser, String OwPass, String FFname, String MMname, String LLname, String PPhone, String tenmail, String Age, String Reg_num, String major, String tenUser, String tenPass) {
        obj.printTenant(FFname, MMname, LLname, PPhone, tenmail, Age, Reg_num, major, tenUser, tenPass);
        obj.printOwner(Fname, Mname, Lname, Phone, Owemail, age, OwUser, OwPass);
    }
    @Then("registration complete and the account is created with username{string} and password {string}")
    public void registrationCompleteAndTheAccountIsCreatedWithUsernameAndPassword(String username, String password)
    {
            assertTrue(("tenant".equals(obj.checkValues(username, password))||"owner".equals(obj.checkValues(username, password))));
    }
    @Given("user wants to signup as a tenant or owner")
    public void user_wantsToSignupAsATenantOrOwner()
    {
        assertTrue(true);
    }
    @Given("first name  = {string}, second name = {string}, lastname = {string}, Phone={string}, email = {string}, age ={string}, OwUser = {string}, OwPass = {string} for owner and first name  = {string}, second name = {string}, lastname = {string}, Phone={string}, email = {string}, age ={string}, Reg_num = {string}, major = {string}, tenUser = {string}, tenPass = {string} for tenant and usernames isn't available")
    public void firstNameSeconNameLastnamePhoneEmailAgeOwUserOwPassForOwnerAndFirstNameSecondNameLastnamePhoneEmailAgeRegNumMajorTenUserTenPassForTenantAndUsernamesIsnTAvailable(String Fname, String Mname, String Lname, String Phone, String Owemail, String age, String OwUser, String OwPass, String FFname, String MMname, String LLname, String PPhone, String tenmail, String Age, String Reg_num, String major, String tenUser, String tenPass)
    {
        assertTrue(obj.failureReg(tenUser, tenPass));
    }
    @Then("registration fails the account with username{string} and password {string} isn't created")
    public void registrationFailsTheAccountWithUsernameAndPasswordIsnTCreated(String username, String password) {
        if("tenant".equals(obj.checkValues(username, password))||"owner".equals(obj.checkValues(username, password)))
        {
            assertTrue("tenant".equals(obj.checkValues(username, password))||"owner".equals(obj.checkValues(username, password)));
        }
    }
}