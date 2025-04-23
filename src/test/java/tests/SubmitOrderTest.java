package tests;

import java.io.IOException;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import AutomationExerciseDemo.pageobjects.CartPage;
import AutomationExerciseDemo.pageobjects.ConfirmationPage;
import AutomationExerciseDemo.pageobjects.PaymentPage;

public class SubmitOrderTest extends BaseTest {
	
	CartPage cartPage;
	PaymentPage paymentPage;
	ConfirmationPage confirmationPage ;
	
	

	@Test()
	public void submitOrder() throws IOException, InterruptedException
	{
		cartPage = new CartPage(getDriver());
		cartPage.goToCheckout();
		cartPage.isOnCheckoutPage("https://www.automationexercise.com/checkout");
		cartPage.addNotesToOrder("This is a test message for automation");
		cartPage.goToPayment();
		paymentPage = new PaymentPage(getDriver());
		paymentPage.isOnPaymentPage("https://www.automationexercise.com/payment");
		paymentPage.confirmOrder("israa galal","1234567890123456","283","12","2029");
		Thread.sleep(3000);
		confirmationPage = new ConfirmationPage(getDriver());
		String confirmMessage = confirmationPage.getConfirmationMessage();
		AssertJUnit.assertTrue(confirmMessage.equalsIgnoreCase("Congratulations! Your order has been confirmed!"));
			
	}

}
