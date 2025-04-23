package tests;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


import AutomationExerciseDemo.pageobjects.HomePage;

public class BaseTest {
	
	public HomePage homePage;
    protected static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return driver.get();
    }
    
    @BeforeTest
    public void launchApplication() throws IOException {
        if (driver.get() == null) {
            driver.set(new ChromeDriver());
            getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            getDriver().manage().window().maximize();
        }
        homePage = new HomePage(getDriver());
        homePage.goToUrl();
    }
    
    @AfterTest
    public void tearDown() {
        if (driver.get() != null) {
            getDriver().quit();
            driver.remove();
        }
    }
    
    public String getScreenshot(String testCaseName,ThreadLocal<WebDriver> driver2) throws IOException
	{
    	TakesScreenshot ts = (TakesScreenshot) driver2.get();
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
		FileUtils.copyFile(source, file);
		return file.getAbsolutePath();	
		
	}

}







