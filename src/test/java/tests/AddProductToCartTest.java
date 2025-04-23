package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import AutomationExerciseDemo.pageobjects.CartPage;
import AutomationExerciseDemo.pageobjects.HomePage;
import AutomationExerciseDemo.pageobjects.ProductsPage;

public class AddProductToCartTest extends BaseTest{

	HomePage home ; 
	ProductsPage productPage;
	CartPage cartPage;
	String productName = "Blue Top";
	
	
	@Test()
	public void UserCanAddProductToCart() 
	{
		home = new HomePage(getDriver()); 
		home.openProductsPage();
		productPage = new ProductsPage(getDriver());
		productPage.checkIfOnProductPage("https://www.automationexercise.com/products");
		productPage.openProductDetails();
		productPage.verifyProductDetailsPage("https://www.automationexercise.com/product_details/1");
		productPage.changeProductQty("3");
		productPage.addProductToCart();
		cartPage = new CartPage(getDriver());
		cartPage.isOnCartPage("https://www.automationexercise.com/view_cart");
		Boolean match = cartPage.VerifyProductDisplay(productName);
		Assert.assertTrue(match);
	}
	
}


