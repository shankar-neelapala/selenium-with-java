package datadriventesting;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingDataIntoExcel {

	public static void main(String[] args) throws IOException {
		
		FileOutputStream file = new FileOutputStream(System.getProperty("user.dir")+"\\testdata\\myfile.xlsx");
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		
		XSSFSheet sheet = workbook.createSheet("Data");
		
		//creating static data, you can create data dynamically also using for loops
		XSSFRow row0 = sheet.createRow(0);		
		row0.createCell(0).setCellValue("ronaldoo");
		row0.createCell(1).setCellValue(7);
		row0.createCell(2).setCellValue("portugal");
		
		XSSFRow row1 = sheet.createRow(1);		
		row1.createCell(0).setCellValue("messi");
		row1.createCell(1).setCellValue(10);
		row1.createCell(2).setCellValue("argentina");
		
		XSSFRow row2 = sheet.createRow(2);		
		row2.createCell(0).setCellValue("neymar");
		row2.createCell(1).setCellValue(11);
		row2.createCell(2).setCellValue("brazil");
		
		workbook.write(file);
		System.out.println("file is created...");
		workbook.close();
		file.close();
	}

}
