package april3;

 import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Property_File{
	 WebDriver driver;
	Properties con;
	@BeforeTest
	public void setup()throws Throwable
	{
		con = new Properties();
		con.load(new FileInputStream("OR.properties"));
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(con.getProperty("Url"));
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	@Test
	public void varifyLogin()
	{
		driver.findElement(By.xpath(con.getProperty("ObjReset"))).click();
		driver.findElement(By.xpath(con.getProperty("Objuser"))).sendKeys(con.getProperty("Enteruser"));
		driver.findElement(By.xpath(con.getProperty("Objpass"))).sendKeys(con.getProperty("Enterpass"));
	    driver.findElement(By.xpath(con.getProperty("ObjLoginbtn"))).click();
	    String Expected_title = "Dashboard « Stock Accounting";
     	String Actual_title = driver.getTitle();
    	if (Expected_title.equalsIgnoreCase(Actual_title))
	{
		Reporter.log("Login success::"+Expected_title+"    "+Actual_title);
	}
	
	else
	{
		Reporter.log("Login fail::"+Expected_title+"    "+Actual_title);
		
	}
	}
	@AfterTest
	public void teardown()
	{
		driver.quit();
	
	
	}
}
