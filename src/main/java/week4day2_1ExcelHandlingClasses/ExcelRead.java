package week4day2_1ExcelHandlingClasses;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {
	
	public static void main(String[] args) throws IOException {
		
		XSSFWorkbook excelWB = new XSSFWorkbook("C:\\Sathya\\TestLeaf\\API Testing\\apiworkspaceEclipse\\"
				+ "SelBootCamp\\src\\main\\java\\week4day2_2ExcelApachePOI\\excelData\\week4day2Data.xlsx"); 
		
		XSSFSheet excelSheet = excelWB.getSheet("Sheet1"); 
		
		XSSFRow row = excelSheet.getRow(1); 
		
		XSSFCell cell = row.getCell(0); 
		
		System.out.println(cell.getStringCellValue()); 
		
		excelWB.close(); 
		
		
	}

}
