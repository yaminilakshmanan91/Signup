package mainPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageObjectClass {

	public static WebDriver driver;

	public PageObjectClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "div [class*=panel] a[href*=create]")
	private WebElement createAccountLink;

	public WebElement getCreateAccountLink() {
		return createAccountLink;
	}

	@FindBy(css = "#firstname")
	private WebElement firstNameTextBox;

	public WebElement getFirstNameTextBox() {
		return firstNameTextBox;
	}

	@FindBy(css = "#lastname")
	private WebElement lastNameTextBox;

	public WebElement getLastNameTextBox() {
		return lastNameTextBox;
	}

	@FindBy(css = "#email_address")
	private WebElement emailTextBox;

	public WebElement getEmailTextBox() {
		return emailTextBox;
	}

	@FindBy(xpath = "//input[@id='password']")
	private WebElement passwordTextBox;

	public WebElement getPasswordTextBox() {
		return passwordTextBox;
	}

	@FindBy(xpath = "//input[@id='password-confirmation']")
	private WebElement confirmPasswordTextBox;

	public WebElement getConfirmPasswordTextBox() {
		return confirmPasswordTextBox;
	}

	@FindBy(css = "button[class*=submit]")
	private WebElement createAccountButton;

	public WebElement getCreateAccountButton() {
		return createAccountButton;
	}

	@FindBy(css = "#email")
	private WebElement signInemailTextBox;

	public WebElement getSignInemailTextBox() {
		return signInemailTextBox;
	}

	@FindBy(xpath = "//input[@name='login[password]']")
	private WebElement signInPassTextBox;

	public WebElement getSignInPassTextBox() {
		return signInPassTextBox;
	}

	@FindBy(xpath = "(//button[@id='send2'])[1]")
	private WebElement signInButton;

	public WebElement getSignInButton() {
		return signInButton;
	}

	@FindBy(css = "div[class*=success] div")
	private WebElement successMessage;

	public WebElement getSuccessMessage() {
		return successMessage;
	}

	@FindBy(css = "div[class='box-content'] p")
	private WebElement contactInformation;

	public WebElement getContactInformation() {
		return contactInformation;
	}

	@FindBy(css = "div [class*=panel] a[href*=login]")
	private WebElement SignInLink;

	public WebElement getSignInLink() {
		return SignInLink;
	}

	@FindBy(xpath = "//div[@class='panel header']//li/span[@class='logged-in']")
	private WebElement welcomeUserFullName;

	public WebElement getWelcomeUserFullName() {
		return welcomeUserFullName;
	}

}
