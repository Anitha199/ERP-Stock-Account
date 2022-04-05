package utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class Apputils {
	
	public static WebDriver driver;
	public static String url="http://orangehrm.qedgetech.com/webapp/dashboard.php";
	@BeforeSuite
	public static void launchapp()
	{
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(url);
		
	}
	@AfterSuite
	public static void closeapp()
	{
		driver.close();
		
	}

}


