package util;

import constants.General_Constants;
import org.testng.annotations.DataProvider;

import java.io.IOException;

public class ExcelDataProvider implements General_Constants {

    @DataProvider(name = "testData")
    public  Object[][] getData() throws IOException {
        Object data[][] =  TestData(ExcelPath,SheetName);
        return data;
    }

    public  Object[][] TestData(String Excelpath , String sheetName) throws IOException {

        ExcelUtils excel = new ExcelUtils(Excelpath,sheetName);
        int RowCount =excel.getRowCount();
        int ColCount = excel.getColCount(RowCount);
        Object data[][] = new Object[RowCount-1][ColCount];
        for (int i = 1; i <RowCount ; i++) {
            for (int j = 0; j <ColCount ; j++) {
                String CellData= excel.getCellStringData(i,j);
                data[i-1][j] =CellData;
            }
            
        }

     return data;
    }
}
