package package1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelUtil {

	public static Object[][] LoginData;
	   
    public static org.apache.poi.ss.usermodel.Row Row;
    public static Cell cell;
   // public static String FilePath = "C:\\Users\\admin\\Desktop\\DataSheet.xls";
    //public static String SheetName1 = "Login";
    
  //  public static String SheetName2 = System.getProperty("testdatasheetName");
    public static org.apache.poi.ss.usermodel.Sheet Sheet;
	//static final String filepath=".\\testdata\\testdata.xlsx";
	 public static Object[][] ShipmentData;
	 //public static HSSFSheet Sheet;
	
//	 public static String getsheet(){
//		 String shname = System.getProperty("testdatasheetName");
//		 return shname;
//	 }
	 
	// String sdata=Excelutil.getsheet()
	// SheetName2=sdata;
	static final String filepath="D:\\Learning_protractor\\NCR-Automation\\pawanTestRail\\exefiles\\Book3.xlsx";
	 public static XSSFWorkbook WBook = null;
	   public static org.apache.poi.ss.usermodel.Sheet WSheet= null;
	
	public static String readData(String sheetName, int rowNum, int cellNum) throws InvalidFormatException, FileNotFoundException, IOException 
	{
		String value=null;
		
		
		
        try{
//        	   File file = new File(filepath);
//        	 FileInputStream fis = new FileInputStream(file);
//        	WBook = new XSSFWorkbook(fis);
        	//HSSFSheet wb=HSSFWorkbook.createSheet();
		Workbook wb=WorkbookFactory.create(new FileInputStream(new File(filepath)));
		value=wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
		
		}
		
		
			catch(EncryptedDocumentException e){
				e.printStackTrace();
			}
		
		
		return value;
		
	}
	
	 @DataProvider
     public static Object[][] getShipmentData() throws Exception{

         Sheet = DataSheet(System.getProperty("Sheet2"));
        // System.out.println(Sheet);
         int rowCount = Sheet.getLastRowNum();
         System.out.println(rowCount);
         int colCount = Sheet.getRow(0).getLastCellNum();
         System.out.println(colCount);

         ShipmentData = new Object[rowCount][colCount];

         for (int rCnt=1; rCnt<=rowCount;rCnt++){
             for (int cCnt=0; cCnt<colCount;cCnt++){
                 ShipmentData[rCnt-1][cCnt] =getCellData(System.getProperty("Sheet2"), rCnt, cCnt);
                 System.out.println(ShipmentData[rCnt-1][cCnt]);
             }
         }

         return ShipmentData;        
 }
	

	 
	 public static org.apache.poi.ss.usermodel.Sheet DataSheet(String SheetName){
	      //  File file = new File("D:\\Learning_protractor\\NCR-Automation\\pawanTestRail\\exefiles\\Book3.xlsx");
	        try {
	           // FileInputStream fis = new FileInputStream(file);
	        	Workbook wb=WorkbookFactory.create(new FileInputStream(new File(filepath)));
	         //   WBook = new XSSFWorkbook(fis);
	            WSheet =  wb.getSheet(SheetName);  
	            System.out.println(WSheet);
	        } catch (Exception e) {         
	            e.printStackTrace();
	        }
	        return WSheet;      
	    }       	 
	
	
	
	 public static String getCellData(String Sheet, int row, int col){

	        try {

	            int index = WBook.getSheetIndex(Sheet);


	            WSheet = WBook.getSheetAt(index);
	            Row = WSheet.getRow(row);
	            if (Row == null)
	            	  
	            return "";

	            cell = Row.getCell(col);
	            if (cell == null)
	            return "";

	            switch (cell.getCellType())
	            {
	            case  Cell.CELL_TYPE_STRING:
	            return cell.getStringCellValue();               

	            case  Cell.CELL_TYPE_BOOLEAN:
	            return String.valueOf(cell.getBooleanCellValue());          

	            case  Cell.CELL_TYPE_BLANK:
	            return "";      

	            case  Cell.CELL_TYPE_ERROR:
	            return cell.getStringCellValue();           

	            case  Cell.CELL_TYPE_NUMERIC:
	            return String.valueOf(cell.getNumericCellValue());          

	            default:
	            return "Cell not found";        

	            }
	        }
	            catch (Exception e) {
	            e.printStackTrace();
	            return "row " + row + " or column " + col+ " does not exist in xls";
	            }

	    }
}
