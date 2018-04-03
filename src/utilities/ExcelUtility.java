package utilities;


import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

public class ExcelUtility {

    private static XSSFWorkbook ExcelWBook;
    private static XSSFSheet ExcelWSheet;

    public static void setExcelFile(String path, String sheetName) throws Exception {
        try{
            // Open the Excel file
            FileInputStream ExcelFile = new FileInputStream(path);

            // Access the excel data sheet
            ExcelWBook = new XSSFWorkbook(ExcelFile);
            ExcelWSheet = ExcelWBook.getSheet(sheetName);
        } catch (Exception e) {
            throw (e);
        }
    }

    public static String[][] getTestData(String tebleName) {
        String[][] testData = null;

        try {
            XSSFCell[] boumdaryCells = findCells(tableName);
            XSSFCell startCell = boundaryCells[0];

            XSSFCell endCell = boumdaryCells[1];

            int startRow = startCell.getRowIndex() + 1;
            int endRow = endCell.getRowIndex() - 1;
            int startColl = startCell.getColumnIndex() + 1;
            int endColl = endCell.getColumnIndex() - 1;

            testData = new String[endRow - startRow +1][endColl - startColl +1];

            for (int i = startRow; i < endRow+1; i++) {
                for (int j = startColl; i < endColl+1; j++) {
                    testData[i-startRow][j-startColl] = ExcelWSheet.getRow(i).getCell(j).getStringCellValue();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return testData
    }

    public static void XSSFCell[] findCells(String tableName) {
        String pos = "begin";
        XSSFCell[] cells = new XSSFCell[2];

        for (Row row : ExcelWSheet) {
            for (Cell cell : row) {
                if (tableName.equals(cell.getStringCellValue())) {
                    if (pos.equalsIgnoreCase("begin")) {
                        cells[0] = (XSSFCell) cell;
                        pos = "end";
                    } else {
                        cells[1] = (XSSFCell) cell;
                    }
                }
            }
        }
        return cells;
}
