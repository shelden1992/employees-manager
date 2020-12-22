package com.csLtd.view;

import com.csLtd.model.Employee;
import com.csLtd.service.FormatterService;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static java.util.Objects.nonNull;

/**
 * Created by Shelupets Denys on 22.12.2020.
 */
@Scope("prototype")
@Component
@PropertySource("classpath:value.properties")
public class ExelView implements View {
    private final Logger LOG = LoggerFactory.getLogger(ExelView.class);
    private final DecimalFormat decimalFormat = new DecimalFormat("###,###.##");
    private final FormatterService formatterService;
    private final AtomicInteger numberRows = new AtomicInteger(2);
    @Value("${file.save.path}")
    private String path;

    public ExelView(FormatterService formatterService) {
        this.formatterService = formatterService;
    }

    public int getNumberRows() {
        return numberRows.get() - 2;
    }

    @Override
    public void outAllEmployees(List<Employee> employeeList) {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Employees");
            sheet.setColumnWidth(0, 9000);
            sheet.setColumnWidth(1, 10000);
            sheet.setColumnWidth(2, 9000);
            sheet.setColumnWidth(3, 9000);
            Row header = sheet.createRow(0);

            CellStyle headerStyle = workbook.createCellStyle();
            headerStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
            headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

            XSSFFont font = ((XSSFWorkbook) workbook).createFont();
            font.setFontName("Arial");
            font.setFontHeightInPoints((short) 16);
            font.setBold(true);
            headerStyle.setFont(font);

            Cell headerCell = header.createCell(0);
            headerCell.setCellValue("ФИО");
            headerCell.setCellStyle(headerStyle);

            headerCell = header.createCell(1);
            headerCell.setCellValue("Название компании");
            headerCell.setCellStyle(headerStyle);

            headerCell = header.createCell(2);
            headerCell.setCellValue("Зарплата");
            headerCell.setCellStyle(headerStyle);

            headerCell = header.createCell(3);
            headerCell.setCellValue("Название департамента");
            headerCell.setCellStyle(headerStyle);

            employeeList.forEach(employee -> {
                        CellStyle style = workbook.createCellStyle();
                        style.setWrapText(true);
                        Row row = sheet.createRow(numberRows.getAndIncrement());
                        Cell cell = row.createCell(0);
                        cell.setCellValue(employee.getLastName() + " " + employee.getFirstName() + " " + " " + (nonNull(employee.getMiddleName()) ? employee.getMiddleName() : ""));
                        cell.setCellStyle(style);

                        cell = row.createCell(1);
                        cell.setCellValue(employee.getDepartment().getCompany().getCompanyName());
                        cell.setCellStyle(style);

                        cell = row.createCell(2);
                        cell.setCellValue(decimalFormat.format(employee.getSalary() / 100.0));
                        cell.setCellStyle(style);

                        cell = row.createCell(3);
                        cell.setCellValue(employee.getDepartment().getDepartmentName());
                        cell.setCellStyle(style);
                    }
            );
            CellStyle style = workbook.createCellStyle();
            style.setWrapText(true);
            Row row = sheet.createRow(numberRows.get() + 1);

            Cell cell = row.createCell(1);
            cell.setCellValue(formatterService.getFormattedStringCompanyNameAndCountEmployees(employeeList));
            cell.setCellStyle(style);

            cell = row.createCell(2);
            cell.setCellValue("Общая сумма по зарплатам: " + decimalFormat.format(formatterService.getSum(employeeList) / 100.0));
            cell.setCellStyle(style);

            cell = row.createCell(3);
            cell.setCellValue("");
            cell.setCellStyle(style);

            try (FileOutputStream outputStream = new FileOutputStream(new File(path).getAbsolutePath())) {
                workbook.write(outputStream);
                LOG.debug("Wrote " + (numberRows.get() - 2) + " items");
            } catch (IOException e) {
                LOG.error(e.getMessage(), e);
            }
        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
        }
    }
}
