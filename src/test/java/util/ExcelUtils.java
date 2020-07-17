package util;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.IOException;


public class ExcelUtils  {

    static XSSFWorkbook workbook;
    static XSSFSheet sheet;

    public ExcelUtils(String Excelpath ,String sheetName) throws IOException {
        workbook= new XSSFWorkbook(Excelpath);
        sheet = workbook.getSheet(sheetName);

    }
    public static int getRowCount() throws IOException {
        int rowCount = 0;
         rowCount    =  sheet.getPhysicalNumberOfRows();
         return rowCount;
    }
    public static int getColCount(int rowNum) throws IOException {
        int ColCount = 0;
         ColCount =  sheet.getRow(0).getPhysicalNumberOfCells();
         return  ColCount;
    }
    public static String getCellStringData(int rowNum,int colNum) throws IOException {
        return  sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
    }
    public static double getCellNumericData(int rowNum,int colNum) throws IOException {
       return sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
    }
}
