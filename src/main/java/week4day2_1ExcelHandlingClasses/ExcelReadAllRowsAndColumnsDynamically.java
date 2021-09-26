package week4day2_1ExcelHandlingClasses;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReadAllRowsAndColumnsDynamically {

	public static void main(String[] args) throws IOException {

		XSSFWorkbook excelWB = new XSSFWorkbook("C:\\Sathya\\TestLeaf\\API Testing\\apiworkspaceEclipse\\"
				+ "SelBootCamp\\src\\main\\java\\week4day2_2ExcelApachePOI\\excelData\\week4day2Data.xlsx");

		XSSFSheet excelSheet = excelWB.getSheet("Sheet1");

		// we can dynamically get the count of the number of rows
		// This method will always skip the first row considering it as Header row
		int nbrOfRows = excelSheet.getLastRowNum();
		System.out.println(nbrOfRows);
		/*
		 * //An alternative, if we do not have a header row is to use the below method
		 * int nbrOfAllRows = excelSheet.getPhysicalNumberOfRows();
		 * System.out.println(nbrOfAllRows);
		 */

		// getting cells for each row. Note: The cell count will give the count not
		// index.
		int nbrOfCells = excelSheet.getRow(0).getLastCellNum();
		System.out.println("# of cells: " + nbrOfCells);

		for (int i = 1; i <= nbrOfRows; i++) {
			// to dynamically get columns if column differs put the above two lines of code
			// in first loop
			int nbrOfCellsDynamic = excelSheet.getRow(i).getLastCellNum();
			System.out.println("# of cells: " + nbrOfCellsDynamic);

			for (int j = 0; j < nbrOfCellsDynamic; j++) {
//			try catch block added to handle an empty/no value cell, check last row 8th column
				try {
					String cellType = excelSheet.getRow(i).getCell(j).getCellType().name(); 
					if (cellType.equalsIgnoreCase("STRING")) {
						String cellStringValue = excelSheet.getRow(i).getCell(j).getStringCellValue();
						System.out.print(cellStringValue + "     ");
					} else if (cellType.equalsIgnoreCase("NUMERIC")) {
						double cellNumericValue = excelSheet.getRow(i).getCell(j).getNumericCellValue();
						System.out.print(cellNumericValue + "     ");
					}
				} catch (Exception e) {
					System.out.print("empty" + "     ");
				}
			}
			System.out.println();
		}

		excelWB.close();

	}

}
