package libraries;

import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import utils.Apputils;

public class Login extends Apputils{
	@BeforeTest
	
	public void login(String email, String pwd)
	{
		driver.findElement(By.id("btnreset")).click();
		driver.findElement(By.id("username")).sendKeys(email);
		driver.findElement(By.id("password")).sendKeys(pwd);
		driver.findElement(By.id("btnsubmit")).click();
		
	}
	@AfterTest
	public boolean logout()
	{
		
		driver.findElement(By.id("logout")).click();
		driver.findElement(By.xpath("//*[starts-with(@class,'ajs-button')]")).click();
		if(driver.findElement(By.partialLinkText("Register")).isDisplayed())
		{
			return true;
		} else
		{
			return false;
		}
	}
	
	
	public boolean isLoginSuccessful()
	{
		if(driver.findElement(By.id("logout")).isDisplayed())
		{
			return true;
		} else
		{
			return false;
		}
	}
	
	
	public boolean isErrMsgDisplayed()
	
	{
		
		
		if(driver.findElement(By.xpath("//*[contains(@class,'ewError')]")).getText().contains("Incorrect"))
		{
			return true;
		}else
		{
			return false;
		}
	}
public boolean isemptymsgdisplayed()
	
	{
		
		
		if(driver.findElement(By.className("text-danger")).isDisplayed())
		{
			return true;
		}else
		{
			return false;
		}
	}
public boolean isresetworking()
{
	driver.findElement(By.id("btnreset")).click();
	if(driver.findElement(By.id("username")).getText().isEmpty())
	{
		return true;
	}else
	{
		return false;
	}
}
	
	

}
