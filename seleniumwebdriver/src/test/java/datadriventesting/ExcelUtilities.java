package datadriventesting;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilities {

	private static FileInputStream fin;
	private static FileOutputStream fout;
	private static XSSFWorkbook wb;
	private static XSSFSheet sheet;
	private static XSSFRow row;
	private static XSSFCell cell;
	private static CellStyle style;
	
	public static int getRowsCount(String filePath, String sheetName) throws IOException {
		fin = new FileInputStream(filePath);
		wb = new XSSFWorkbook(fin);
		sheet = wb.getSheet(sheetName);
		
		int r = sheet.getLastRowNum();
		fin.close();
		wb.close();
		return r;
	}
	
	public static int getColumnsCount(String filePath, String sheetName) throws IOException {
		fin = new FileInputStream(filePath);
		wb = new XSSFWorkbook(fin);
		sheet = wb.getSheet(sheetName);
		
		int c = sheet.getRow(0).getLastCellNum();
		fin.close();
		wb.close();
		return c;
	}
	
	public static String getCellValue(String filePath, String sheetName, int r, int c) throws IOException{
		fin = new FileInputStream(filePath);
		wb = new XSSFWorkbook(fin);
		sheet = wb.getSheet(sheetName);
		DataFormatter formatter = new DataFormatter();
		String data = formatter.formatCellValue(sheet.getRow(r).getCell(c));
		//String data = sheet.getRow(r).getCell(c).toString();
		fin.close();
		wb.close();
		return data;
	}
	
	public static void setCellValue(String filePath, String sheetName, int r, int c, String data) throws IOException{
		fin = new FileInputStream(filePath);
		wb = new XSSFWorkbook(fin);
		sheet = wb.getSheet(sheetName);
		
		row = sheet.getRow(r);
		cell = row.createCell(c);
		cell.setCellValue(data);
		
		fout = new FileOutputStream(filePath);
		wb.write(fout);
		fin.close();
		fout.close();
		wb.close();
	}
	
	public static void fillGreenColor(String filePath, String sheetName, int r, int c) throws IOException {
		fin = new FileInputStream(filePath);
		wb = new XSSFWorkbook(fin);
		sheet = wb.getSheet(sheetName);		
		row = sheet.getRow(r);
		cell = row.createCell(c);
		
		style = wb.createCellStyle();
		//apply green back ground color
		style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		//apply style to cell
		cell.setCellStyle(style);
		
		fout = new FileOutputStream(filePath);
		wb.write(fout);
		fin.close();
		fout.close();
		wb.close();
		
	}
	
	public static void fillRedColor(String filePath, String sheetName, int r, int c) throws IOException {
		fin = new FileInputStream(filePath);
		wb = new XSSFWorkbook(fin);
		sheet = wb.getSheet(sheetName);		
		row = sheet.getRow(r);
		cell = row.createCell(c);
		
		style = wb.createCellStyle();
		//apply green back ground color
		style.setFillForegroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		//apply style to cell
		cell.setCellStyle(style);
		
		fout = new FileOutputStream(filePath);
		wb.write(fout);
		fin.close();
		fout.close();
		wb.close();
		
	}
}
