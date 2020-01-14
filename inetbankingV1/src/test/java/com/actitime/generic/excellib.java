package com.actitime.generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * 
 * @author Chetan Sharma
 *
 */
public class excellib {
	
	String filepath;
	
	public excellib(String filepath)
	{
		this.filepath =filepath;
	}
	
	
	public String readData(String sheetname,int row, int cell) 
	{
		String value = null;
		try {
			
			FileInputStream fis = new FileInputStream(new File(filepath));
			Workbook wb = WorkbookFactory.create(fis);
			Cell c1= wb.getSheet(sheetname).getRow(row).getCell(cell);
			switch(c1.getCellType())
			{
			case STRING:
			value = c1.getStringCellValue();
			break;
			
			case NUMERIC:
			if(DateUtil.isCellDateFormatted(c1))	
			{
				SimpleDateFormat sdf = new SimpleDateFormat("MMM DD YYYY");
				value = sdf.format(c1.getDateCellValue());
			}
			else 
			{
			long longvalue = (long) c1.getNumericCellValue();
			value= Long.toString(longvalue);
			}
			break;
			
			case BOOLEAN:
			boolean value1 = c1.getBooleanCellValue();	
			value = Boolean.toString(value1);
			break;
			
			default:
			System.out.println("Cell format not match");	
			break;
			
			}
		}
		
		catch(EncryptedDocumentException e)
		{
			e.printStackTrace();
		}
		
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		return value;
	}
	
	

}
