package AutomationExerciseDemo.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ProductsPage extends BasePage {
		
	public ProductsPage(WebDriver driver) 
	 {
		super(driver);	
		this.driver = driver; 
		
	  }
	
	@FindBy(xpath="//a[@href='/product_details/1']")
	WebElement product;
	
	@FindBy(id="quantity")
	WebElement qtyInput;
	
	@FindBy(xpath="//button[normalize-space()='Add to cart']")
	WebElement addToCartBtn;
	
	@FindBy(id="cartModal")
	WebElement cartModal;
	
	@FindBy(css=".modal-content .modal-body p a")
	WebElement viewCartButton;
	
	
	public void checkIfOnProductPage(String productURL) {
		
		Assert.assertEquals(driver.getCurrentUrl(), productURL);
		
	}
	
	public void openProductDetails()
	{	
		scrollToBottom(product);
		waitForWebElementToAppear(product);
		clickButton(product);
	}
	
	public void verifyProductDetailsPage(String productDetailsURL) {
		
		Assert.assertEquals(driver.getCurrentUrl(), productDetailsURL);
		
	}
	
	public void changeProductQty(String qty)
	{
		qtyInput.clear();
		setTextElementText(qtyInput, qty);
	}
	
	public void addProductToCart()
	{
		clickButton(addToCartBtn);
		waitForWebElementToAppear(cartModal);
		waitForWebElementToAppear(viewCartButton);
		clickButton(viewCartButton);
	}
}









