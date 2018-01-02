package com.pa.qa.util;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;

import com.pa.qa.pages.HomePage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Constants {
	public static int PAGE_LOAD_TIMEOUT=40;
	public static int IMPLICIT_WAIT=20;
	public static final String Path_TestData="C://Users//yogesha//Desktop//New folder (5)//PA//src//main//resources//testdata.xlsx";
	public static ExtentReports extent;
	public static ExtentTest test;
	public static WebDriver driver;
	
	public static String TestResult_Path; 
	
}
