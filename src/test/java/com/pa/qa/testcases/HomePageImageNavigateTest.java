package com.pa.qa.testcases;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pa.qa.base.TestBase;
import com.pa.qa.pages.*;
import com.pa.qa.reportlistener.CaptureScreenShot;
import com.pa.qa.util.Constants;
import com.relevantcodes.extentreports.LogStatus;

public class HomePageImageNavigateTest 
{

    HomePage HomePage;
    SingleItemAddPage SingleItemAddPage;
    
    @BeforeTest
    public void setUp()
    {
        TestBase.intialization();
        System.out.println("HomePageImageNavigateTest");
    }
     
    @Test(priority=2)
    public void HomePageNavigateTest()
    {
    System.out.println("Started HomePageImageNavigateTest");
    Constants.test =  Constants.extent.startTest("HomePageNavigateTest");
    	HomePage=new HomePage();
    	HomePage=HomePage.verifyNewArrivals();
    	SingleItemAddPage=HomePage.verifyNewArrivalsNavigation();	
    }
     
    @AfterMethod
    public void getResult(ITestResult result) throws IOException
    {
    	System.out.println("End HomePageImageNavigateTest");
        if(result.getStatus() == ITestResult.FAILURE)
        {
            String screenShotPath = CaptureScreenShot.captureScreen( Constants.driver, "ScreenName");
            Constants.test.log(LogStatus.FAIL, result.getThrowable());
            Constants.test.log(LogStatus.FAIL, "Snapshot below: " +  Constants.test.addScreenCapture(screenShotPath));
        }
        Constants.extent.endTest(Constants.test);
   	  
    }
     
         
    @AfterTest
    public void tearDown()
    {
    	Constants.driver.quit();
    	 Constants.extent.close();
    }
}