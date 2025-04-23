package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import AutomationExerciseDemo.pageobjects.HomePage;
import AutomationExerciseDemo.pageobjects.LoginPage;

public class ErrorValidationsTest extends BaseTest {
	
	HomePage home ; 
	LoginPage login ; 
	
	@Test(retryAnalyzer = data.Retry.class)
	public void LoginErrorValidation() throws IOException, InterruptedException {

	
		home = new HomePage(getDriver()); 
		home.openLoginPage();
		login = new LoginPage(getDriver()); 
		login.UserLogin("esraa.gll93@gmail.com", "Israa#123");
		Assert.assertEquals("Your email or password is inc orrect!", login.getErrorMessage());

	}
	

}
