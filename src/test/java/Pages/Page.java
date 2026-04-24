package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Page {
	 WebDriver driver;

	    public Page(WebDriver driver) {
	        this.driver = driver;
	    }
	    By nameField =By.id("name");
	    By emailField = By.id("email");
	    By passwordField = By.id("password");
	    By confirmPasswordField = By.id("cpassword");
	    By mobileField = By.id("mobile");
	    By groupDropdown = By.xpath("//*[contains(text(),'Select Group')]");
	    By phoneField = By.id("phoneNo");
	    By idProof = By.id("id_proof");
	    By registerBtn = By.xpath("//input[@value='Register Now']");
	    
	    public void enterName(String name) {
	    	driver.findElement(nameField).sendKeys(name);
	    	
	    }
	    public void enterEmail(String email) {
	    	driver.findElement(emailField).sendKeys(email);	
	    }
	    public void enterPassword(String password) {
	    	driver.findElement(passwordField).sendKeys(password);
	    }
	    public void enterConfirmPassword(String confirmPassword) {
	    	driver.findElement(confirmPasswordField).sendKeys(confirmPassword);
	    }
	    public void enterMobile(String mobile) {
	    	driver.findElement(mobileField).sendKeys(mobile);
	    }
	    public void selectGroup(String group) {
	    driver.findElement(groupDropdown).click();
	    driver.findElement(By.xpath("//option[contains(text(),'" + group + " ')]")).click();
	    }
	    public void enterPhone(String phone) {
	    	driver.findElement(phoneField).sendKeys(phone);
	    }
	    public void uploadIdProof(String filePath) {
	    	WebElement idproof=driver.findElement(idProof);
	    	idproof.click();
	    	idproof.sendKeys(filePath);
	    }
	    public void clickRegister() {
	    	driver.findElement(registerBtn).click();
	    	
	    }
	    public void fillRegistrationForm(String name, String email, String password,
                String confirmPassword, String mobile, String phone, String filePath) {

enterName(name);
enterEmail(email);
enterPassword(password);
enterConfirmPassword(confirmPassword);
enterMobile(mobile);
enterPhone(phone);
uploadIdProof(filePath);
}
	    
	    
	    
}
