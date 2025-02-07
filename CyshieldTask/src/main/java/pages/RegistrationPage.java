package pages;

import base.UIActions;
import org.openqa.selenium.By;

import java.util.Random;

public class RegistrationPage
{
	UIActions ui = new UIActions();
	private final By userNameTxtBox = By.name("username");
	private final By emailTxtBox = By.name("email");
	private final By passwordTxtBox = By.name("password");
	private final By confirmPasswordTxtBox = By.name("confirmPassword");
	private final By recaptcha = By.className("recaptcha-checkbox-checkmark");
	private final By registerBtn = By.xpath("//button[contains(text(),'Create Account')]");
	private final By successMessage = By.cssSelector("div.result");

	private final By userNameErrorMessage = By.xpath("//*[@id=\"app-content\"]/div/div/div/div/div[2]/form/div/div[1]/div[1]/div/div/text()");
	private final By emailErrorMessage = By.xpath("d//*[@id=\"app-content\"]/div/div/div/div/div[2]/form/div/div[1]/div[2]/div/div");
	private final By passwordErrorMessage = By.xpath("//*[@id=\"app-content\"]/div/div/div/div/div[2]/form/div/div[1]/div[3]/div/div");


	// Method to fill out the registration form with valid data
	public HomePage userRegistration(String username, String email , String password)
	{
		ui.writeIn(userNameTxtBox, username);
		ui.writeIn(emailTxtBox, email);
		ui.writeIn(passwordTxtBox, password);
		ui.writeIn(confirmPasswordTxtBox, password);
		ui.clickOn(recaptcha);
		ui.clickOn(registerBtn);
		System.out.println(email);
		return new HomePage();
	}
	// Method to check if all form elements are visible
	public boolean areFormElementsVisible() {

		return ui.isElementExisted(userNameTxtBox) && ui.isElementExisted(emailTxtBox)
				&& ui.isElementExisted(passwordTxtBox)&& ui.isElementExisted(confirmPasswordTxtBox)
				&& ui.isElementExisted(recaptcha)&& ui.isElementExisted(registerBtn);
	}
	public void UserLeaveAllFieldEmpty() {
		ui.clickOn(registerBtn);

	}
	public String getUserNameErrorMessage() {
		return ui.getTextOfElement(userNameErrorMessage);

	}


	public String getEmailErrorMessage() {
		return ui.getTextOfElement(emailErrorMessage);
	}

	public String getPasswordErrorMessage() {
		return ui.getTextOfElement(passwordErrorMessage);
	}
	public String getSuccessMessage() {
		return ui.getTextOfElement(successMessage);
	}
}
