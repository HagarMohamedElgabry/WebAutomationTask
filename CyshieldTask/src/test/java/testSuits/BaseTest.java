package testSuits;

import driver.DriverActions;
import driver.DriverManager;
import helpers.ScreenshotHelper;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.HomePage;
import pages.RegistrationPage;

public class BaseTest {
    protected BaseTest(){}
    protected HomePage homePage;
    protected RegistrationPage registrationPage;
    protected static String email ;
    protected String username = "Hagar Mohamed" ;
    protected String password = "1234567";
    @BeforeClass
    protected void setUp() throws Exception {
        DriverActions.initDriver();
        homePage = new HomePage();
        registrationPage = homePage.openRegistrationPage();
        registrationPage.userRegistration(username, email, password);
        Assert.assertTrue(registrationPage.getSuccessMsg().contains("Your registration completed"));
    }
    @AfterClass
    protected void tearDown(){
        DriverActions.quitDriver();
    }

    @AfterMethod
    public void screenshotOnFailure(ITestResult result)
    {
        if (result.getStatus() == ITestResult.FAILURE)
        {
            System.out.println("Failed!");
            System.out.println("Taking Screenshot....");
            ScreenshotHelper.captureScreenshot(DriverManager.getDriver(), result.getName());
        }
    }
}

