package data;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import AutomationExerciseDemo.resources.ExtentReporterNG;
import tests.BaseTest;

public class Listeners extends BaseTest implements ITestListener {
	
		ExtentTest test;
		ExtentReports extent = ExtentReporterNG.getReportObject();
		ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>(); 
		@Override
		public void onTestStart(ITestResult result) {
			test = extent.createTest(result.getMethod().getMethodName());
			extentTest.set(test);
		}

		@Override
		public void onTestSuccess(ITestResult result) {
			extentTest.get().log(Status.PASS, "Test Passed");
		
		}
		@SuppressWarnings("unchecked")
		@Override
		public void onTestFailure(ITestResult result) {
		    extentTest.get().fail(result.getThrowable());

		    ThreadLocal<WebDriver> testDriver = null;

		    try {
		        Class<?> currentClass = result.getTestClass().getRealClass();

		        while (currentClass != null) {
		            try {
		                java.lang.reflect.Field driverField = currentClass.getDeclaredField("driver");
		                driverField.setAccessible(true);
		                Object fieldObj = driverField.get(result.getInstance());

		                if (fieldObj instanceof ThreadLocal) {
		                    testDriver = (ThreadLocal<WebDriver>) fieldObj;
		                } else {
		                    System.out.println("driver field exists but not ThreadLocal<WebDriver>");
		                }
		                break; 
		            } catch (NoSuchFieldException e) {
		                currentClass = currentClass.getSuperclass();  
		            }
		        }

		    } catch (Exception e) {
		        System.out.println(" Failed to access driver field:");
		        e.printStackTrace();
		    }

		    if (testDriver != null) {
		        try {
		            String filePath = getScreenshot(result.getMethod().getMethodName(), testDriver);
		            extentTest.get().addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
		        } catch (IOException e) {
		            System.out.println("Failed to take screenshot:");
		            e.printStackTrace();
		        }
		    } else {
		        System.out.println("WebDriver not found for test method: " + result.getMethod().getMethodName());
		    }
		}


		@Override
		public void onTestSkipped(ITestResult result) {
			// TODO Auto-generated method stub	
		}

		@Override
		public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onStart(ITestContext context) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFinish(ITestContext context) {
			// TODO Auto-generated method stub
			extent.flush();
			
		}
		
}
