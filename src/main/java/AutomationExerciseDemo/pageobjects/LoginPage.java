package AutomationExerciseDemo.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LoginPage extends BasePage{
	
		
	public LoginPage(WebDriver driver) 
	 {
		super(driver);
		this.driver = driver; 
	  }
	
	
	@FindBy(css="input[placeholder='Email Address']")
	WebElement emailAddress;
	
	@FindBy(css="input[data-qa='login-password']")
	WebElement password;
	
	@FindBy(css="button[data-qa='login-button']")
	WebElement loginBtn;
	
	@FindBy(css="ul[class='nav navbar-nav'] li a b")
	WebElement userName;
	
	@FindBy(css=".login-form p")
	WebElement errorMsg;

	public void UserLogin(String email , String passwordTxt) 
	{
		setTextElementText(emailAddress, email);
		setTextElementText(password, passwordTxt);
		clickButton(loginBtn);
	}
	
	public void verifyLogin(String user)
	{
		Assert.assertEquals(userName.getText(), user);
	}
	
	public String getErrorMessage()
	{
		waitForWebElementToAppear(errorMsg);
		return errorMsg.getText();
	}
}
