package utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDB {

    private static Workbook workbook;
    private static Sheet sheet;

    public static void setExcelFile(String excelFilePath, String sheetName) throws IOException {
        FileInputStream fis = new FileInputStream(excelFilePath);
        workbook = new XSSFWorkbook(fis);
        sheet = workbook.getSheet(sheetName);
    }

    public static String getCellData(int rowNumber, int columnNumber) {
        Row row = sheet.getRow(rowNumber);
        Cell cell = row.getCell(columnNumber);
        
        return cell.getStringCellValue().toString();
    }
}
