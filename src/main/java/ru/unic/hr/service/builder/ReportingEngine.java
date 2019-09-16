package ru.unic.hr.service.builder;

import org.apache.poi.common.usermodel.HyperlinkType;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import ru.unic.hr.model.Item;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * Created by BritikovMI on 16.09.2019.
 */
public class ReportingEngine {
    public static Workbook getXLSXWorkbookItemsReport(List<Item> items){
        Workbook workbook = new HSSFWorkbook();

        Sheet sheet = workbook.createSheet("Report List");
        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("ID");
        header.createCell(1).setCellValue("NAME");
        header.createCell(2).setCellValue("ЗАРПЛАТА");
        header.createCell(3).setCellValue("ССЫЛКА");
        int rowNum = 1;
        for (Item item : items) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(item.getId());
            row.createCell(1).setCellValue(item.getName());
            row.createCell(2).setCellValue(item.getSalary() != null ? item.getSalary().getFrom().toString() : "");

            Cell cell = newHyperlinkCell(workbook, row, 3, item.getAlternateUrl());
            cell.setCellValue("URL");
        }

        return workbook;
    }


        public static void main(String[]args) throws IOException {
            try (Workbook wb = new XSSFWorkbook()) { //or new HSSFWorkbook();

                Sheet sheet = wb.createSheet();
                Row row = sheet.createRow(0);
                Cell cell = newHyperlinkCell(wb, row, 0, "cv");
                cell.setCellValue("URL Link");

                try (FileOutputStream out = new FileOutputStream("hyperinks.xlsx")) {
                    wb.write(out);
                }
            }
        }

    private static Cell newHyperlinkCell(Workbook wb,Row row, Integer celladdress, String cellValue){
        CreationHelper createHelper = wb.getCreationHelper();

        //cell style for hyperlinks
        //by default hyperlinks are blue and underlined
        CellStyle hlink_style = wb.createCellStyle();
        Font hlink_font = wb.createFont();
        hlink_font.setUnderline(Font.U_SINGLE);
        hlink_font.setColor(IndexedColors.BLUE.getIndex());
        hlink_style.setFont(hlink_font);

        Cell cell;
        //URL
        cell = row.createCell(celladdress);

        Hyperlink link = createHelper.createHyperlink(HyperlinkType.URL);
        link.setAddress(cellValue);
        cell.setHyperlink(link);
        cell.setCellStyle(hlink_style);

        return cell;
    }
}
