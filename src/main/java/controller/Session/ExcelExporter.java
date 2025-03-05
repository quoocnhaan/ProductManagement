/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.Session;

/**
 *
 * @author PC
 */
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import model.Product;

public class ExcelExporter {

    public static void exportProductsToExcel(List<Product> products, String filePath) {
        // Create a new workbook and sheet
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Products");

        // Create a header row
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("ID");
        headerRow.createCell(1).setCellValue("Name");
        headerRow.createCell(2).setCellValue("Code");
        headerRow.createCell(3).setCellValue("Brand");
        headerRow.createCell(4).setCellValue("Discount");
        headerRow.createCell(5).setCellValue("Gender");
        headerRow.createCell(6).setCellValue("Price");
        headerRow.createCell(7).setCellValue("Description");
        headerRow.createCell(8).setCellValue("Quantity");
        headerRow.createCell(9).setCellValue("Product Status");
        headerRow.createCell(10).setCellValue("Type");

        // Fill in the product data
// Fill in the product data
        int rowNum = 1;
        for (Product product : products) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(product.getId());
            row.createCell(1).setCellValue(product.getName());
            row.createCell(2).setCellValue(product.getCode());

            // Writing Brand name (or you can write Brand ID with product.getBrand().getId())
            row.createCell(3).setCellValue(product.getBrand().getName());

            row.createCell(4).setCellValue(product.getDiscount());

            String genderStr = "";
            int gender = product.getGender();

            if (gender == 1) {
                genderStr = "Men";
            } else if (gender == 2) {
                genderStr = "Women";
            } else if (gender == 3) {
                genderStr = "Unisex";
            }
            row.createCell(5).setCellValue(genderStr);
            row.createCell(6).setCellValue(product.getPrice());
            row.createCell(7).setCellValue(product.getDescription());
            row.createCell(8).setCellValue(product.getAmount());
            row.createCell(9).setCellValue(product.getProductStatus() ? "In-Stock" : "Out-of-Stock");

            String typeStr = "";
            int type = product.getType();

            if (gender == 1) {
                typeStr = "10ml";
            } else if (gender == 2) {
                typeStr = "20ml";
            } else if (gender == 3) {
                typeStr = "30ml";
            } else if (gender == 4) {
                typeStr = "Full";
            }
            row.createCell(10).setCellValue(typeStr);

        }

        // Resize all columns to fit the content
        for (int i = 0; i < 11; i++) {
            sheet.autoSizeColumn(i);
        }

        // Write the output to a file
        try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
            workbook.write(fileOut);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Close the workbook
        try {
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
