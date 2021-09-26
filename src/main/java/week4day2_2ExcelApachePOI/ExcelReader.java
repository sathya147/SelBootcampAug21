package week4day2_2ExcelApachePOI;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	public static String[][] readData(String excelName) throws IOException {

		System.out.println("in excel reader: " +excelName);
		
		XSSFWorkbook excelWB = new XSSFWorkbook("C:\\Sathya\\TestLeaf\\API Testing\\apiworkspaceEclipse\\"
				+ "SelBootCamp\\src\\main\\java\\week4day2_2ExcelApachePOI\\excelData\\" + excelName + ".xlsx");

		XSSFSheet excelSheet = excelWB.getSheet("Sheet1");

		// Getting count of rows.  This method will always skip the first row considering it as Header row
		int nbrOfRows = excelSheet.getLastRowNum();
		System.out.println(nbrOfRows);

		// getting cells for each row. Note: The cell count will give the count not index.
		int nbrOfCells = excelSheet.getRow(0).getLastCellNum();
		System.out.println("# of cells: " + nbrOfCells);

		String[][] dataToPass = new String[nbrOfRows][nbrOfCells]; 
		
		for (int i = 1; i <= nbrOfRows; i++) {
			for (int j = 0; j < nbrOfCells; j++) {
						String cellStringValue = excelSheet.getRow(i).getCell(j).getStringCellValue();
						dataToPass[i-1][j] = cellStringValue;  //here we have i-1 since while filling into Object array, need to start from index 0
//						System.out.print(cellStringValue + "     ");
					} 
			System.out.println();
		}
		
		//for some reason, using Object[][] did not pass the excel file name into the excel reader
/*		for (int i = 1; i <= nbrOfRows; i++) {
			for (int j = 0; j < nbrOfCells; j++) {
//			try catch block added to handle an empty/no value cell, check last row 8th column
				try {
					String cellType = excelSheet.getRow(i).getCell(j).getCellType().name(); 
					if (cellType.equalsIgnoreCase("STRING")) {
						String cellStringValue = excelSheet.getRow(i).getCell(j).getStringCellValue();
						dataToPass[i-1][j] = cellStringValue;  //here we have i-1 since while filling into Object array, need to start from index 0
//						System.out.print(cellStringValue + "     ");
					} 
					else if (cellType.equalsIgnoreCase("NUMERIC")) {
						double cellNumericValue = excelSheet.getRow(i).getCell(j).getNumericCellValue(); 
						dataToPass[i-1][j] = cellNumericValue; 
//						System.out.print(cellNumericValue + "     ");
					}
				} catch (Exception e) {
					System.out.print("empty" + "     ");
				}
			}
			System.out.println();
		}
*/
		excelWB.close(); 
	
		System.out.println("###########     This is the Excel handling class      ##############");
		
		return dataToPass; 
	}

}
