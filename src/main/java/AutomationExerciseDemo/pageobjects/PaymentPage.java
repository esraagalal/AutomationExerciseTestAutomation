package AutomationExerciseDemo.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class PaymentPage extends BasePage{
	
	
	@FindBy(name="name_on_card")
	WebElement cardNameTxt;
	
	@FindBy(name="card_number")
	WebElement cardNumberTxt;
	
	@FindBy(name="cvc")
	WebElement cvcTxt;
	
	@FindBy(name="expiry_month")
	WebElement expiryMonthTxt;
	
	@FindBy(name="expiry_year")
	WebElement expirYearTxt;
		
	@FindBy(id="submit")
	WebElement submitBtnTxt;	
	
	public PaymentPage(WebDriver driver) 
	 {
		super(driver);
		this.driver = driver;
	 }
	
	public void  isOnPaymentPage(String paymentURL)
	{
		 Assert.assertEquals(driver.getCurrentUrl(), paymentURL);

	}
	
	public void confirmOrder(String cardName, String cardNumber, String cvc, String expiryMonth, String expirYear)
	{
		setTextElementText(cardNameTxt,cardName);
		setTextElementText(cardNumberTxt,cardNumber);
		setTextElementText(cvcTxt,cvc);
		setTextElementText(expiryMonthTxt,expiryMonth);
		setTextElementText(expirYearTxt,expirYear);
		clickButton(submitBtnTxt);
	}

	
	
}
