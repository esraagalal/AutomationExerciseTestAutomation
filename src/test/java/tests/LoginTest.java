package tests;

import org.testng.annotations.Test;
//import org.testng.annotations.Test;

import AutomationExerciseDemo.pageobjects.HomePage;
import AutomationExerciseDemo.pageobjects.LoginPage;

public class LoginTest extends BaseTest {
	
	HomePage home ; 
	LoginPage login ; 
	
	@Test
	public void RegisteredUserCanLogin() 
	{
		home = new HomePage(getDriver()); 
		home.openLoginPage();
		login = new LoginPage(getDriver()); 
		login.UserLogin("esraa.glal93@gmail.com", "Israa#123");
		login.verifyLogin("israa");
	}

}


