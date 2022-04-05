package libraries;

import org.openqa.selenium.By;

import utils.Apputils;

public class Stock_Items extends Apputils {
	public void stockitems()
	{
		driver.findElement(By.linkText("Stock Items ")).click();
	}

}
