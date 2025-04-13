package Com_Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_Data_Provider {
	
private XSSFWorkbook wb;
	
	public  Excel_Data_Provider() throws Exception {
		String Excel_path=System.getProperty("user.dir")+"\\Excel_TestData\\Excel_Login_Credentials.xlsx";
		//FOSROC_Automation/Excel_TestData/Excel_FSRC.xlsx
		File f=new File(Excel_path);
		FileInputStream file=new FileInputStream(f);
		wb=new XSSFWorkbook(file);
	}
	
/*
	 public ExcelDataProvider() throws IOException {
	        
	        String excelPath = System.getProperty("user.dir") + File.separator + "Excel_TestData" + File.separator + "login_credential.xlsx";
	        
	        File file = new File(excelPath);

	       
	        try (FileInputStream fis = new FileInputStream(file)) {
	            wb = new XSSFWorkbook(fis);  
	        } catch (IOException e) {
	           
	            e.printStackTrace();
	            throw e;  
	        }
	    }
	*/
	
	public  String getStringdata(String sheetname,int rownum,int cellnum) {
		return wb.getSheet(sheetname).getRow(rownum).getCell(cellnum).getStringCellValue();
		
}
	
	public String getStringdata2(String sheetname, int rownum, int cellnum) {
	    Cell cell = wb.getSheet(sheetname).getRow(rownum).getCell(cellnum);
	    if (cell == null) {
	        return "";  // Return empty if cell is null
	    }
	    switch (cell.getCellType()) {
	        case STRING:
	            return cell.getStringCellValue();
	        case NUMERIC:
	            return String.valueOf((int) cell.getNumericCellValue());
	        case BOOLEAN:
	            return String.valueOf(cell.getBooleanCellValue());
	        default:
	            return "";
	    }
	}


	public  String get_Date(String sheetname,int rownum,int cellnum) {
		Date date= wb.getSheet(sheetname).getRow(rownum).getCell(cellnum).getDateCellValue();
		DateFormat simple = new SimpleDateFormat("dd/MM/yyyy");
		return simple.format(date);
	}
	
	public String getNumericdata(String sheetname,int rownum,int cellnum) {
		 Double d=wb.getSheet(sheetname).getRow(rownum).getCell(cellnum).getNumericCellValue();
		/* String pin= String.valueOf(d);//1234.0
		 //return pin.replaceAll(".0","");//1234
		int dotindex=pin.lastIndexOf(".");
		return pin.substring(0, dotindex); */
		return String.format("%.0f", d);	
	}
	
    public String getCombinedData(String sheetname, int rownum, int stringCell, int numericCell) {
        // Get the string and numeric data
        String stringData = getStringdata(sheetname, rownum, stringCell);
        String numericData = getNumericdata(sheetname, rownum, numericCell);

        // Combine both string and numeric data
        return stringData + " " + numericData;
    }

	}
	

	

