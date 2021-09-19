package week4day2ExcelHandlingClasses;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReadAllRowsFirstColumn {
	
	public static void main(String[] args) throws IOException {
		
		XSSFWorkbook excelWB = new XSSFWorkbook("C:\\Sathya\\TestLeaf\\API Testing\\apiworkspaceEclipse\\"
				+ "SelBootCamp\\src\\main\\java\\week4day2ExcelApachePOI\\excelData\\week4day2Data.xlsx"); 
		
		XSSFSheet excelSheet = excelWB.getSheet("Sheet1"); 
		
		/*		for (int i = 1; i <= 3; i++) {
		XSSFRow row = excelSheet.getRow(1); 
		XSSFCell cell = row.getCell(0); 
		System.out.println(cell.getStringCellValue()); 
		}
	*/	
//		The above 3 rows of code can be written in one line. 
		for (int i = 1; i <= 3; i++) {
			System.out.println(excelSheet.getRow(1).getCell(0).getStringCellValue()); 
						
			}
		
		excelWB.close(); 
		
		
	}

}
