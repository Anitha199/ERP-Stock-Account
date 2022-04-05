package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.collections4.Get;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLutils {
	
	public static FileInputStream fi;
	public static Workbook wb;
	public static Sheet s;
	public static Row row;
	public static  Cell cell;
	public static FileOutputStream fo;
	public static int r;
	public static CellStyle cs;
	public static int rowcount(String xlfile,String sheet ) throws IOException
	{
		
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi); 
		s=wb.getSheet(sheet);
		r=s.getLastRowNum();
		wb.close();
		fi.close();
		return r;
		}
	
	public static short columncount(String xlfile, String sheet, int r1) throws IOException
	{
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi); 
		s=wb.getSheet(sheet);
		row=s.getRow(r1);
		Short c=row.getLastCellNum();
		wb.close();
		fi.close();
		return c;
	}
	public static String getstringcelldata(String xlfile,String sheet,int r1,int c1) throws IOException
	{
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi); 
		s=wb.getSheet(sheet);
		row=s.getRow(r1);
		String data;
		try {
			cell=row.getCell(c1);
			data=cell.getStringCellValue();
		} catch (Exception e) {
			data="";
			System.out.println("No data found");
		}
		wb.close();
		fi.close();
		return data;
	}
	public static double getNumericcelldata(String xlfile,String sheet,int r1,int c1) throws IOException
	{
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi); 
		s=wb.getSheet(sheet);
		row=s.getRow(r1);
		double data;
		try {
			cell=row.getCell(c1);
			data=cell.getNumericCellValue();
		} catch (Exception e) {
			data=0.0;
			System.out.println("No data found");
		}
		wb.close();
		fi.close();
		return data;
	}
	public static boolean getbooleancelldata(String xlfile,String sheet,int r1,int c1) throws IOException
	{
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi); 
		s=wb.getSheet(sheet);
		row=s.getRow(r1);
		boolean data;
		try {
			cell=row.getCell(c1);
			data=cell.getBooleanCellValue();
		} catch (Exception e) {
			data=false;
		
		}
		wb.close();
		fi.close();
		return data;
	}
	public static void setcelldata(String xlfile,String sheet,int r1,int c1,String data) throws IOException
	{
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi); 
		s=wb.getSheet(sheet);
		row=s.getRow(r1);
		cell=row.createCell(c1);
		cell.setCellValue(data);
		fo= new FileOutputStream(xlfile);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();
		
	}
	public static void fillgreencolor(String xlfile,String sheet,int r1,int c1) throws IOException
	{
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi); 
		s=wb.getSheet(sheet);
		row=s.getRow(r1);
		cell=row.getCell(c1);
		cs=wb.createCellStyle();
		cs.setFillForegroundColor(IndexedColors.BRIGHT_GREEN.getIndex());
		cs.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		cell.setCellStyle(cs);
		fo= new FileOutputStream(xlfile);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();
		
	}
	public static void fillredcolor(String xlfile,String sheet,int r1,int c1) throws IOException
	{
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi); 
		s=wb.getSheet(sheet);
		row=s.getRow(r1);
		cell=row.getCell(c1);
		cs=wb.createCellStyle();
		cs.setFillForegroundColor(IndexedColors.RED.getIndex());
		cs.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		cell.setCellStyle(cs);
		fo= new FileOutputStream(xlfile);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();
		
	}

}
