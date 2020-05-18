package package1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Hyperlink;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtilities { 
	
	static final String filepath=".\\exefiles\\Book3.xlsx";
	//                            .\\testdata\\testdata.xlsx
	//ExcelUtilities e1=new ExcelUtilities();
	//ExcelUtilities.readdata();
	
	public static String readData(String sheetName, int rowNum, int cellNum) 
	{
		
		String value=null;
		
		try{
			
		Workbook wb=WorkbookFactory.create(new FileInputStream(new File(filepath)));
		//System.out.println(wb.getActiveSheetIndex());
		//System.out.println(wb.getSheet(sheetName));
		value=wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
		//value=admin
		//ExcelUtilities.readData("Sheet1", 2, 1);
		
		}
		
		
			catch(EncryptedDocumentException e){
				e.printStackTrace();
			}
			catch(InvalidFormatException e){
				e.printStackTrace();
			}
			catch(FileNotFoundException e){
				e.printStackTrace();
			}
			catch(IOException e){
				e.printStackTrace();
			}
		
		
		return value;
		
	}
	

}
