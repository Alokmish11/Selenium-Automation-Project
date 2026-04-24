package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.Page;

public class RegistrationTestRunner  extends Base.BaseClass{
	@Test
    public void verifyValidRegistration() {

		Page register = new Page(driver);

        register.fillRegistrationForm(
                "Alok Mishra",
                "aloktest123@gmail.com",
                "Test@123",
                "Test@123",
                "9876543210",
                "0532123456",
                "C:\\Users\\Alokm\\Downloads\\screenshot.png"
        );

        register.clickRegister();

        String currentUrl = driver.getCurrentUrl();

        Assert.assertTrue(currentUrl.contains("login") || currentUrl.contains("dashboard"),
                "Registration failed or user not redirected");
    }
	 @Test
	    public void verifyBlankRegistrationForm() {

	        Page register = new Page(driver);

	        register.clickRegister();

	        String pageSource = driver.getPageSource();

	        Assert.assertTrue(pageSource.contains("required") || pageSource.contains("Name"),
	                "Validation message not displayed for blank form");
	    }
	 @Test
	    public void verifyInvalidEmailFormat() {

	        Page register = new Page(driver);

	        register.fillRegistrationForm(
	                "Alok Mishra",
	                "alokgmail.com",
	                "Test@123",
	                "Test@123",
	                "9876543210",
	                "0532123456",
	                "C:\\Users\\\\Alokm\\Downloads\\screenshot.png"
	        );

	        register.clickRegister();

	        String pageSource = driver.getPageSource();

	        Assert.assertTrue(pageSource.contains("email") || pageSource.contains("invalid"),
	                "Invalid email validation message not displayed");
	    }
	 @Test
	    public void verifyPasswordMismatch() {

	        Page register = new Page(driver);

	        register.fillRegistrationForm(
	                "Alok Mishra",
	                "aloktest456@gmail.com",
	                "Test@123",
	                "Test@456",
	                "9876543210",
	                "0532123456",
	                "C:\\Users\\Alokm\\Downloads\\screenshot.png"
	        );

	        register.clickRegister();

	        String pageSource = driver.getPageSource();

	        Assert.assertTrue(pageSource.contains("Password") || pageSource.contains("match"),
	                "Password mismatch validation not displayed");
	    }
	 @Test
	    public void verifyInvalidMobileNumber() {

	        Page register = new Page(driver);

	        register.fillRegistrationForm(
	                "Alok Mishra",
	                "aloktest789@gmail.com",
	                "Test@123",
	                "Test@123",
	                "12345",
	                "0532123456",
	                "C:\\Users\\Alokm\\Downloads\\screenshot.png"
	        );

	        register.clickRegister();

}
}
