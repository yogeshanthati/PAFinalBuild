package com.pa.qa.testcases;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pa.qa.util.*;
import com.pa.qa.base.TestBase;
import 	com.pa.qa.pages.*;
import com.pa.qa.reportlistener.CaptureScreenShot;
import com.relevantcodes.extentreports.LogStatus;

public class LogInTest {
	MyAccountPageRegisterAndLogin MyAccountPageRegisterAndLogin	;
	MyAccountPage MyAccount;
	String sheetName="Login";
    @BeforeTest
	 public void setUP(){
			TestBase.intialization();
		       System.out.println("LogInTest");
	}
	@Test( dataProvider="getLogInTestData")
	public  void LogInToApp(String uname, String pwd){
		System.out.println("Started LogInTest");
		 Constants.test =  Constants.extent.startTest("LogInToApp");
		 MyAccountPageRegisterAndLogin=new MyAccountPageRegisterAndLogin();
		MyAccountPageRegisterAndLogin	=MyAccountPageRegisterAndLogin.LogIn(uname, pwd);			
	}
	
	 @AfterMethod
	    public void getResult(ITestResult result) throws IOException
	    {
		 System.out.println("End LogInTest");
	        if(result.getStatus() == ITestResult.FAILURE)
	        {
	            String screenShotPath = CaptureScreenShot.captureScreen( Constants.driver, "ScreenName");
	            Constants.test.log(LogStatus.FAIL, result.getThrowable());
	            Constants.test.log(LogStatus.FAIL, "Snapshot below: " +  Constants.test.addScreenCapture(screenShotPath));
	        }
	        Constants.extent.endTest( Constants.test);
	        
	       
	    }

	@AfterTest
	public void tearDown(){
		 Constants.driver.quit();
    	 Constants.extent.close();
    	 
	}
	  @DataProvider
		public Object[][] getLogInTestData(){
			Object data[][] = TestUtil.getTestData(sheetName);
			return (data);
		}
}
