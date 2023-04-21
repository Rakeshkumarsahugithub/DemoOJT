package april3;


 

 import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

 public class AdvanceReports {
	WebDriver driver;
	ExtentReports report;
	ExtentTest test;
	@BeforeTest
	public void generateReport()
	{
	report = new ExtentReports("./ExtentReports/Demo.html");
	}
	@BeforeMethod
	public void setUp()
	{
	 driver = new ChromeDriver();
		driver.manage().window().maximize();
	driver.get("http://google.com");	
		
	}
	@Test
	public void testcase1()
	{
		test = report.startTest("Pass Test");
		String Expected_title = "Google";
		String Actual_Title = driver.getTitle();
		if(Expected_title.equalsIgnoreCase(Actual_Title))
		{
			
			test.log(LogStatus.PASS,"Title is matching:::"+ Expected_title+"     " +Actual_Title);
		}
		else
		{
			test.log(LogStatus.FAIL,"Title is not matching:::"+ Expected_title+"     " +Actual_Title);
		}}
		@Test
		public void testcase2()
		{
			test = report.startTest("Fail Test");
			test.assignAuthor("Rakesh");
			test.assignCategory("Functional");
			String Expected_Title = "Gmail";
			String Actual_Title = driver.getTitle();
			if(Expected_Title.equalsIgnoreCase(Actual_Title))
			{test.log(LogStatus.PASS,"Title is matching:::"+Expected_Title+"     "+ Actual_Title);
			
			}
			else
			{
				test.log(LogStatus.FAIL,"Title is not matching:::"+"       "+ Actual_Title);
			}}
			@AfterMethod
			public void teardown()
			{
				report.endTest(test);
				report.flush();
				driver.quit();
			}
			
		
		}
		

 