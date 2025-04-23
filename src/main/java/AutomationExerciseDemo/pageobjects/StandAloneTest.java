package AutomationExerciseDemo.pageobjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class StandAloneTest {

	public static void main(String[] args) throws InterruptedException {
		
		 WebDriver driver = new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
	     driver.manage().window().maximize();
		 driver.get("https://www.automationexercise.com/");
		 //login
		 driver.findElement(By.cssSelector("a[href='/login']")).click();
		 Assert.assertEquals(driver.getCurrentUrl(), "https://www.automationexercise.com/login");
		 driver.findElement(By.cssSelector("input[placeholder='Email Address']")).sendKeys("esraa.glal93@gmail.com");
		 driver.findElement(By.cssSelector("input[data-qa='login-password']")).sendKeys("Israa#123");
		 driver.findElement(By.cssSelector("button[data-qa='login-button']")).click();
		 
		 //navigate to products page
		 
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 WebElement productsLink = wait.until(ExpectedConditions.refreshed(
		     ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/products']")))); // TEST
		 productsLink.click(); //test
		 Assert.assertEquals(driver.getCurrentUrl(), "https://www.automationexercise.com/products"); // page
		 
		 WebElement product = driver.findElement(By.xpath("//a[@href='/product_details/1']")); // page 
		 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", product); //page
		 
		 wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[@href='/product_details/1']")))).click(); // page
		 Assert.assertEquals(driver.getCurrentUrl(), "https://www.automationexercise.com/product_details/1"); // page
		 
		 // change quantity
		 WebElement quantityInput = driver.findElement(By.id("quantity")); //page
		 quantityInput.clear(); //page
		 quantityInput.sendKeys("3");  //page & test
		 driver.findElement(By.xpath("//button[normalize-space()='Add to cart']")).click(); // PAGE
		 
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cartModal"))); //page 
		 wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".modal-content .modal-body p a")))).click(); //page
		 
		 //validate that the product in the cart
		 List <WebElement> cartProducts = driver.findElements(By.cssSelector("#cart_info_table tbody tr h4 a"));		
		 Boolean match = cartProducts.stream().anyMatch(cartProduct-> cartProduct.getText().equalsIgnoreCase("Blue Top"));
		 Assert.assertTrue(match);
		 
		 //Checkout
		 driver.findElement(By.cssSelector("a.check_out")).click();
		 Assert.assertEquals(driver.getCurrentUrl(), "https://www.automationexercise.com/checkout");
		 
		 WebElement checkout = driver.findElement(By.xpath("//a[@href='/payment']"));
		 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkout);
		 
		 driver.findElement(By.name("message")).sendKeys("This is a test message for automation");
		 wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[@href='/payment']")))).click();
		 Assert.assertEquals(driver.getCurrentUrl(), "https://www.automationexercise.com/payment");
		 
		 //Payment page
		 driver.findElement(By.name("name_on_card")).sendKeys("israa galal");
		 driver.findElement(By.name("card_number")).sendKeys("1234567891234567");
		 driver.findElement(By.name("cvc")).sendKeys("375");
		 driver.findElement(By.name("expiry_month")).sendKeys("08");
		 driver.findElement(By.name("expiry_year")).sendKeys("2029");
		 driver.findElement(By.id("submit")).click();
		 String confirmMessage = driver.findElement(By.cssSelector("div[class='col-sm-9 col-sm-offset-1'] p")).getText();
		 Assert.assertTrue(confirmMessage.equalsIgnoreCase("Congratulations! Your order has been confirmed!"));
		 driver.findElement(By.cssSelector("a[data-qa='continue-button']")).click();
		 Assert.assertEquals(driver.getCurrentUrl(), "https://www.automationexercise.com/");
		 driver.close();

		 
		 
		 

		
	 
	}

}
