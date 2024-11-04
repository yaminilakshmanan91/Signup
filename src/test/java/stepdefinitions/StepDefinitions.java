package stepdefinitions;

import java.io.IOException;

import org.apache.log4j.Level;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.*;
import io.qameta.allure.Step;
import mainPackage.PageObjectClass;
import mainPackage.ReusableMethods;

public class StepDefinitions extends ReusableMethods {

	private Shared_State sharedState;
	public static WebDriver driver;
	public static String password;
	public static String email;
	public static String firstName;
	public static String lastName;
	public static PageObjectClass pageObject;
	public SoftAssert softAssert = new SoftAssert();

	private static final Logger logger = LoggerFactory.getLogger(StepDefinitions.class);

	@Step
	@Given("User launch the browser")
	public void user_launch_the_browser() throws Exception {
		driver = launchBrowserMethod(readPropertyFile("Browser"));
		pageObject = new PageObjectClass(driver);
		maximizeWindowMethod();
		staticWaitMethod(3000);
		deleteAllCookiesMethod();
	}

	@Step
	@And("User navigate into Magento Software Testing Board Home Page")
	public void user_navigate_into_Magento_Software_Testing_Board_Home_Page() throws Exception {
		getBrowserMethod(readPropertyFile("url"));
		staticWaitMethod(3000);
		softAssert.assertEquals(getTitleMethod(), readPropertyFile("MainPage"));
		takesScreenShotMethod("Application_Main_Page");
	}

	@Step
	@And("User navigate into Create New Customer Account Page")
	public void user_navigate_into_Create_New_Customer_Account_Page() throws Exception {
		staticWaitMethod(3000);
		clickMethod(pageObject.getCreateAccountLink());
		softAssert.assertEquals(getTitleMethod(), readPropertyFile("NewCustomerAccountPage"));
		takesScreenShotMethod("Create_New_Customer_Account_Page");
	}

	@Step
	@When("User enters the first name")
	public void user_enters_the_first_name() {
		staticWaitMethod(2000);
		firstName = generateRandomName();
		sendKeysMethod(pageObject.getFirstNameTextBox(), firstName);
	}

	@Step
	@When("User enters the last name")
	public void user_enters_the_last_name() {
		staticWaitMethod(2000);
		lastName = generateRandomName();
		sendKeysMethod(pageObject.getLastNameTextBox(), lastName);
	}

	@Step
	@When("User enters the email")
	public void user_enters_the_email() {
		email = generateRandomEmail();
		staticWaitMethod(2000);
		sendKeysMethod(pageObject.getEmailTextBox(), email);
	}

	@Step
	@When("User enters the password  and confirms with ConfirmPassword")
	public void user_enters_the_password_and_confirms_with_confirm_password() {
		password = generateRandomPassword();
		staticWaitMethod(2000);
		sendKeysMethod(pageObject.getPasswordTextBox(), password);
		staticWaitMethod(2000);
		sendKeysMethod(pageObject.getConfirmPasswordTextBox(), password);
	}

	@Step
	@When("User clicks the CreateAccount button")
	public void user_clicks_the_create_account_button(){
		staticWaitMethod(2000);
		softAssert.assertTrue(isEnabledMethod(pageObject.getCreateAccountButton()));
		clickMethod(pageObject.getCreateAccountButton());
	}

	@Step
	@Then("The account should be created successfully")
	public void the_account_should_be_created_successfully() throws IOException {
		staticWaitMethod(3000);
		softAssert.assertEquals(getTitleMethod(), readPropertyFile("MyAccountPage"));
		takesScreenShotMethod("New_Account_Create_Successfull");
		softAssert.assertTrue(containsMethod(getTextMethod(pageObject.getContactInformation()), firstName));
		
	}

	@Given("User navigate into Customer login Page")
	public void user_navigate_into_customer_login_page() throws IOException {
		staticWaitMethod(2000);
		clickMethod(pageObject.getSignInLink());
		takesScreenShotMethod("Customer_login_Page");
	}

	@When("User enters the UserEmail")
	public void user_enters_the_user_email() {
		staticWaitMethod(2000);
		sendKeysMethod(pageObject.getSignInemailTextBox(), email);
	}

	@When("User enters the password")
	public void user_enters_the_password() {
		staticWaitMethod(2000);
		sendKeysMethod(pageObject.getSignInPassTextBox(), password);
	}

	@When("User clicks the sighIn button")
	public void user_clicks_the_sigh_in_button() {
		staticWaitMethod(2000);
		clickMethod(pageObject.getSignInButton());
	}
	
	@Then("User account login successfully")
	public void user_account_login_successfully() throws IOException {
		staticWaitMethod(2000);
		softAssert.assertEquals(getTitleMethod(), readPropertyFile("MainPage"));
		takesScreenShotMethod("Customer_Home_Page");
		softAssert.assertTrue(containsMethod(getTextMethod(pageObject.getWelcomeUserFullName()), (firstName+" "+lastName)));
	}

	@Then("User close the application")
	public void user_close_the_application() {
		softAssert.assertAll();
		browserQuitMethod();
	}

}
