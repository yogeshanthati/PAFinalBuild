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
import com.pa.qa.pages.HomePage;
import com.pa.qa.reportlistener.CaptureScreenShot;
import com.pa.qa.util.Constants;
import com.relevantcodes.extentreports.LogStatus;
public class HomePageTestCase 
{

    HomePage HomePage;
    @BeforeTest
    public void setUp()
    {
        TestBase.intialization();
        System.out.println("HomePageTestCase");
    }
     
    @Test
    public void HomePageTest()
    {
    System.out.println("Started HomePageTestCase");
    Constants.test =  Constants.extent.startTest("HomePageTest");
    	HomePage=new HomePage();
    	HomePage=HomePage.VerifyHomePageSlides();
    	HomePage=HomePage.verifyNewArrivals();
    }
     
    @AfterMethod
    public void getResult(ITestResult result) throws IOException
    {
    	System.out.println("End HomePageTestCase");
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