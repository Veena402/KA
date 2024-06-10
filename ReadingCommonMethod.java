package stepDefinitions;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

public class ReadingCommonMethod {

    public static String createJsonBody(String id, String name) {
        String flag = null;
        try {
            flag = "{\n" +
                    "    \"id\":" + id + ",\n" +
                    "    \"category\":{\n" +
                    "        \"id\":0,\n" +
                    "        \"name\":\"string\"\n" +
                    "    },\n" +
                    "    \"name\":\"" + name + "\",\n" +
                    "    \"PhotoUrls\":[\n" +
                    "        \"string\"\n" +
                    "    ],\n" +
                    "    \"tags\":[\n" +
                    "        {\n" +
                    "            \"id\":0,\n" +
                    "            \"name\":\"string\"\n" +
                    "        }\n" +
                    "    ],\n" +
                    "    \"status\":\"available\"\n" +
                    "}";


        } catch (Exception e) {
            System.out.println(e);
        }

        return flag;
    }

    public static String readingXLFileAsPerTestData(String testcaseName, String colName) {
        String data = null;
        try {
            String xlFile = "C:/Users/akshatan/Desktop/PetDetails.xlsx";
            FileInputStream myxlfile1 = new FileInputStream(xlFile);
            Workbook workbook = new XSSFWorkbook(myxlfile1);
            Sheet sheet = workbook.getSheet("PetDetails");
            int lastRow = sheet.getLastRowNum();

            for (int i = 0; i <= lastRow; i++) {
                Row row = sheet.getRow(i);
                Cell cell = row.getCell(0);
                String runTimeTestCaseName = cell.getStringCellValue();

                if (runTimeTestCaseName.equals(testcaseName)) {
                    int lastCellIndex = row.getLastCellNum();
                    Row headerRow = sheet.getRow(0);

                    for (int j = 0; j < lastCellIndex; j++) {
                        Cell headerCell = headerRow.getCell(j);
                        String headerCellValue = headerCell.getStringCellValue();

                        if (headerCellValue.equals(colName)) {
                            Cell dataCell = row.getCell(j);
                            if (dataCell != null) {
                                return dataCell.getStringCellValue();
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

