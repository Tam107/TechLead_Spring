package com.techlead.service.core4;

import com.techlead.model.core4.Employee;
import com.techlead.model.core4.Shift;
import com.techlead.model.core4.WorkingDay;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public interface CoreJava4Service {
    Workbook getWorkbook(InputStream is, String excelPath) throws IOException;

    boolean isRowEmpty(Row row);

    Object getCellValue(Cell cell);

    int getTotalAmountColumn(Sheet sheet);

    Map<Integer, List<Integer>> getColDayRange(Sheet sheet, int totalSalaryColumn);

    Map<String, Double> shiftsRate(Sheet sheet, int totalSalaryColumn, int employeeRow);

    Shift getShift(Sheet sheet, Map<String, Double> shiftsRate, int colIndex, int employeeRow);

    WorkingDay getWorkingDay(Sheet sheet, Map<String, Double> shiftsRate, int day, List<Integer> colIndexRange, int employeeRow);

    Employee getEmployee(Sheet sheet, Map<String, Double> shiftsRate, Map<Integer, List<Integer>> colDayRange, int employeeRow, int totalSalaryColumn);

    List<Employee> readTimesheet(String filePath) throws IOException;
}
