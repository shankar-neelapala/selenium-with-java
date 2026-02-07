package datadriventesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingDataFromExcel {

	public static void main(String[] args) {
		
		try {
			
			FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\testdata\\demo.xlsx");
			//open workbook
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			//get the sheet based on name or index
			XSSFSheet sheet = workbook.getSheet("Sheet1");
			//XSSFSheet sheet = workbook.getSheetAt(0);
			
			int noOfRows = sheet.getLastRowNum();//last row index (0-based)
			int noOfCols = sheet.getRow(0).getLastCellNum();//total cell count (1-based)
			
			System.out.println(noOfRows);//5	
			System.out.println(noOfCols);//3	
			
			for(int r = 0; r <= noOfRows; r++) {
				
				XSSFRow row = sheet.getRow(r);//get the entire row
				for(int c = 0; c < noOfCols; c++) {
					System.out.print(row.getCell(c)+"		");
				}
				System.out.println();
			}
			
			workbook.close();
			file.close();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
