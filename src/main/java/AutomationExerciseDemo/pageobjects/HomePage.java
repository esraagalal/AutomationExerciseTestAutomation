package AutomationExerciseDemo.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	

	public HomePage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
	}
	
	
	@FindBy(css="a[href='/login']")
	WebElement loginLink;
	
	@FindBy(css="a[href='/products']")
	WebElement productsLink;
	
	
	public void openLoginPage() 
	{
		clickButton(loginLink);
	}
	
	public void openProductsPage() 
	{
		clickButton(productsLink);
	}
	
	public void goToUrl()
	{
		driver.get("https://www.automationexercise.com");
	}
}
