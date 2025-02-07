package testSuits;
import dataProvider.Json;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RegistrationPage;

public class RegisterTest extends BaseTest{
	RegistrationPage registerObject ;

	@Test(priority = 1)
	public void testElementsVisibility() {
		// Check that All element are displayed
		Assert.assertTrue(registerObject.areFormElementsVisible(), "Not all form elements are visible.");
	}

	// Check that error messages are displayed for all required fields

	@Test
	public void leaveAllFieldsEmptyAndSubmit(String username , String email , String password )
	{

			registerObject = new RegistrationPage();
			registerObject.UserLeaveAllFieldEmpty();
			Assert.assertEquals(registerObject.getUserNameErrorMessage(), "Username must be a 6-32 characters long single word. Possible characters are a-z A-Z 0-9 \"_\" \"-\".\n", "Last name error message is incorrect.");
		    Assert.assertEquals(registerObject.getEmailErrorMessage(), "Please specify your email address!");
		    Assert.assertEquals(registerObject.getPasswordErrorMessage(), "Please specify your newly selected password!");
	}



	@Test(dataProviderClass = Json.class, dataProvider = "registration")
	public void UserCanRegisterSuccssfully(String username , String email , String password )
	{
		try {
			registerObject = new RegistrationPage();
			registerObject.userRegistration(username,email,password);
			Assert.assertEquals(registerObject.getSuccessMessage(), "Thank you for registering");

		} catch (Exception e) {
			System.out.println("Error occurred  " + e.getMessage());
		}
	}

}

