package AutomationExerciseDemo.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class CartPage extends BasePage{
	
	
	@FindBy(css = "#cart_info_table tbody tr h4 a")
	private List<WebElement> cartProducts;
	
	@FindBy(css="a.check_out")
	WebElement checkoutBtn ;
	
	@FindBy(xpath="//a[@href='/payment']")
	WebElement placeOrderBtn ;
	
	@FindBy(name="message")
	WebElement commentTxt ;
	
	public CartPage(WebDriver driver) 
	 {
		super(driver);
		this.driver = driver;
	 }
	
	public void  isOnCartPage(String cartURL)
	{
		 Assert.assertEquals(driver.getCurrentUrl(), cartURL);

	}
	
	public Boolean VerifyProductDisplay(String productName) {
		Boolean match = cartProducts.stream().anyMatch(product -> product.getText().equalsIgnoreCase(productName));
		return match;

	}
	

	public void goToCheckout() {
		clickButton(checkoutBtn);
	}
	
	public void isOnCheckoutPage(String checkoutURL)
	{
		 Assert.assertEquals(driver.getCurrentUrl(), checkoutURL);
	}
	
	public void addNotesToOrder(String msg) 
	{
		setTextElementText(commentTxt, msg);
	}
	
	public void goToPayment() {
		scrollToBottom(placeOrderBtn);
		waitForWebElementToAppear(placeOrderBtn);
		clickButton(placeOrderBtn);
	}
	
}
