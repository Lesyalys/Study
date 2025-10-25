package java8;

import org.apache.poi.xwpf.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.util.Units;
import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WordExporter {

    public static boolean exportTableToWord(JTable table, String tableName) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Сохранить таблицу как Word документ");
        
        // Name file
        String defaultFileName = tableName + "_" + 
            new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date()) + ".docx";
        fileChooser.setSelectedFile(new File(defaultFileName));
        
        int userSelection = fileChooser.showSaveDialog(null);
        
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            // add docx
            if (!fileToSave.getName().toLowerCase().endsWith(".docx")) {
                fileToSave = new File(fileToSave.getAbsolutePath() + ".docx");
            }
            
            return createWordDocument(table, tableName, fileToSave);
        }
        return false;
    }
    
    public static boolean exportTableToExcel(JTable table, String tableName) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Сохранить таблицу как Excel документ");
        
        // Name file
        String defaultFileName = tableName + "_" + 
            new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date()) + ".xlsx";
        fileChooser.setSelectedFile(new File(defaultFileName));
        
        int userSelection = fileChooser.showSaveDialog(null);
        
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            // add xlsx
            if (!fileToSave.getName().toLowerCase().endsWith(".xlsx")) {
                fileToSave = new File(fileToSave.getAbsolutePath() + ".xlsx");
            }
            
            return createExcelDocument(table, tableName, fileToSave);
        }
        return false;
    }
    
    private static boolean createWordDocument(JTable table, String tableName, File file) {
        try (XWPFDocument document = new XWPFDocument();
             FileOutputStream out = new FileOutputStream(file)) {
            
            createTitle(document, "Table: " + tableName);
            createExportInfo(document);
            createWordTable(document, table);
            
            document.write(out);
            
            JOptionPane.showMessageDialog(null, 
                "Таблица успешно экспортирована в:\n" + file.getAbsolutePath(),
                "Экспорт завершен", 
                JOptionPane.INFORMATION_MESSAGE);
            return true;
            
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                "Ошибка при экспорте: " + e.getMessage(),
                "Ошибка экспорта",
                JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return false;
        }
    }
    
    private static boolean createExcelDocument(JTable table, String tableName, File file) {
        try (XSSFWorkbook workbook = new XSSFWorkbook();
             FileOutputStream out = new FileOutputStream(file)) {
            
            Sheet sheet = workbook.createSheet(tableName);
            
            
            TableModel model = table.getModel();
            int rowCount = model.getRowCount();
            int colCount = model.getColumnCount();
            
            // Заголовки
            Row headerRow = sheet.createRow(0);
            for (int col = 0; col < colCount; col++) {
                Cell cell = headerRow.createCell(col);
                cell.setCellValue(model.getColumnName(col));
                sheet.autoSizeColumn(col);
            }
            
            // Данные
            for (int row = 0; row < rowCount; row++) {
                Row dataRow = sheet.createRow(row + 1);
                for (int col = 0; col < colCount; col++) {
                    Cell cell = dataRow.createCell(col);
                    Object value = model.getValueAt(row, col);
                    if (value != null) {
                        cell.setCellValue(value.toString());
                    }
                }
            }
            
            // Авто-размер колонок
            for (int col = 0; col < colCount; col++) {
                sheet.autoSizeColumn(col);
            }
            
            workbook.write(out);
            
            JOptionPane.showMessageDialog(null, 
                "Таблица успешно экспортирована в:\n" + file.getAbsolutePath(),
                "Экспорт завершен", 
                JOptionPane.INFORMATION_MESSAGE);
            return true;
            
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                "Ошибка при экспорте: " + e.getMessage(),
                "Ошибка экспорта",
                JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return false;
        }
    }
    
    private static void createTitle(XWPFDocument document, String title) {
        XWPFParagraph titleParagraph = document.createParagraph();
        titleParagraph.setAlignment(ParagraphAlignment.CENTER);
        
        XWPFRun titleRun = titleParagraph.createRun();
        titleRun.setText(title);
        titleRun.setBold(true);
        titleRun.setFontSize(16);
        titleRun.setFontFamily("Arial");
        
        // empty str
        document.createParagraph().createRun().addBreak();
    }
    
    private static void createExportInfo(XWPFDocument document) {
        XWPFParagraph infoParagraph = document.createParagraph();
        
        XWPFRun infoRun = infoParagraph.createRun();
        infoRun.setText("Дата экспорта: " + 
            new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(new Date()));
        infoRun.setFontSize(10);
        infoRun.setItalic(true);
        infoRun.setFontFamily("Arial");

        document.createParagraph().createRun().addBreak();
    }
    
    private static void createWordTable(XWPFDocument document, JTable table) {
        TableModel model = table.getModel();
        int rowCount = model.getRowCount();
        int colCount = model.getColumnCount();
        
        XWPFTable wordTable = document.createTable(rowCount + 1, colCount); // +1 для заголовков
        
        XWPFTableRow headerRow = wordTable.getRow(0);
        headerRow.setCantSplitRow(true); // Не разрывать строку между страницами
        
        for (int col = 0; col < colCount; col++) {
            String header = model.getColumnName(col);
            setCellValue(headerRow.getCell(col), header, true);
        }
        
        // Данные таблицы
        for (int row = 0; row < rowCount; row++) {
            XWPFTableRow dataRow = wordTable.getRow(row + 1);
            for (int col = 0; col < colCount; col++) {
                Object value = model.getValueAt(row, col);
                String cellValue = (value != null) ? value.toString() : "";
                setCellValue(dataRow.getCell(col), cellValue, false);
            }
        }
        
    }
    
    private static void setCellValue(XWPFTableCell cell, String value, boolean isHeader) {
        // clear text
        for (int i = cell.getParagraphs().size() - 1; i >= 0; i--) {
            cell.removeParagraph(i);
        }
        
        XWPFParagraph paragraph = cell.addParagraph();
        XWPFRun run = paragraph.createRun();
        run.setText(value != null ? value : "");
        run.setFontSize(10);
        run.setFontFamily("Arial");
        
        if (isHeader) {
            run.setBold(true);
            cell.setColor("D3D3D3");
        }
        
        paragraph.setAlignment(ParagraphAlignment.CENTER);
    }
}