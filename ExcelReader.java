package utils;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ExcelReader {

    public static Map<String, String> getPetDetails(String testCaseName, String filePath) {
        Map<String, String> petDetails = new HashMap<>();
        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                if (row.getRowNum() == 0) continue; // Skip header row

                String currentTestCaseName = row.getCell(0).getStringCellValue();
                if (currentTestCaseName.equals(testCaseName)) {
                    petDetails.put("Pet ID", row.getCell(1).getStringCellValue());
                    petDetails.put("Pet Name", row.getCell(2).getStringCellValue());
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return petDetails;
    }
}

