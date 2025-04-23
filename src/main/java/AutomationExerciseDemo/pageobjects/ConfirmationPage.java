package AutomationExerciseDemo.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ConfirmationPage extends BasePage{

	public ConfirmationPage(WebDriver driver) 
	 {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	 }
	
	@FindBy(css = "div[class='col-sm-9 col-sm-offset-1'] p")
	WebElement confirmationMessage;
	
	@FindBy(css = "a[data-qa='continue-button")
	WebElement continueBtn;
	
	public String getConfirmationMessage()
	{
		return confirmationMessage.getText();
	}
	
	public void continueToHomePage()
	{
		clickButton(continueBtn);

	}
	
	public void  isOnHomePage(String homeURL)
	{
		 Assert.assertEquals(driver.getCurrentUrl(), homeURL);

	}
}

