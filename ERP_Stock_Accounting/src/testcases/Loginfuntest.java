package testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import libraries.Login;
import utils.Apputils;
import utils.XLutils;
public class Loginfuntest extends Apputils{
	
	String file="C:\\Users\\DELL\\Desktop\\Selenium programs\\ERP_Stock_Accounting\\ERP Stcock Live Project.xlsx";
	String tssheet="Test Steps";
	String tcsheet="Test Screnarios";
	@Test
	public void logintest() throws IOException
	{
		int tc=XLutils.rowcount(file, tcsheet);
		int ts=XLutils.rowcount(file, tssheet);
		String email,pwd,exe,tcid,tsid,key,sres,cres;
		Login l=new Login();
		boolean b=false;
		for(int i=1;i<tc;i++)
		{
			exe=XLutils.getstringcelldata(file, tcsheet, i, 3);
			if(exe.equalsIgnoreCase("y")){
			tcid=XLutils.getstringcelldata(file, tcsheet, i, 0);
			for(int j=1;j<ts;j++)
			{
				tsid=XLutils.getstringcelldata(file, tssheet, j, 0);
				if(tcid.equals(tsid))
				{
					key=XLutils.getstringcelldata(file, tssheet, j, 3);
					switch (key.toLowerCase()) {
					case "login":
						email=XLutils.getstringcelldata(file, tssheet, j, 4);
						pwd=XLutils.getstringcelldata(file, tssheet, j, 5);
						
						l.login(email, pwd);
						b=l.isLoginSuccessful();
						break;
					case "logout":
						b=l.logout();
						break;
						
					case "invalid":
						email=XLutils.getstringcelldata(file, tssheet, j, 4);
						pwd=XLutils.getstringcelldata(file, tssheet, j, 5);
					
						l.login(email, pwd);
						b=l.isErrMsgDisplayed();
						break;
					case "empty":
						email=XLutils.getstringcelldata(file, tssheet, j, 4);
						pwd=XLutils.getstringcelldata(file, tssheet, j, 5);
						l.login(email, pwd);
						b=l.isemptymsgdisplayed();
						break;
						
					case "newreg":
						break;
					case "reset":
						b=l.isresetworking();
						break;
					case "changepwd":
						break;
				
					}
					if(b)
					{
						sres="pass";
						XLutils.setcelldata(file, tssheet, j, 9, sres);
						XLutils.fillgreencolor(file, tssheet, j, 9);
						} else
						{
							sres="fail";
							XLutils.setcelldata(file, tssheet, j, 9, sres);
							XLutils.fillredcolor(file, tssheet, j, 9);
									
						}
					cres=XLutils.getstringcelldata(file, tcsheet, i, 4);
					if(!cres.equalsIgnoreCase("fail"))
					{
						XLutils.setcelldata(file, tcsheet, i, 4, sres);
					}
					XLutils.getstringcelldata(file, tcsheet, i, 4);
					if(cres.equalsIgnoreCase("pass"))
					{
						XLutils.fillgreencolor(file, tcsheet, i, 4);
					}else
					{
						
						XLutils.fillredcolor(file, tcsheet, i, 4);
					}
					}
				}
			
			} else
			{
				XLutils.setcelldata(file, tcsheet, i, 4, "blocked");
				XLutils.fillredcolor(file, tcsheet, i, 4);
				
			}
		}
	}	
}

	

