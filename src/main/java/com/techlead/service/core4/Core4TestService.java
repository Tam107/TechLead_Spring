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

public interface Core4TestService {


    Workbook getWorkbook(InputStream is, String excelPath) throws IOException;

    boolean isRowEmpty(Row row);

    Object getCellValue(Cell cell);

    int getTotalAmountColumn(Sheet sheet);

    Map<Integer, List<Integer>> getColDayRange(Sheet sheet, int totalSalaryColumn);

    Map<String, Double> shiftRate(Sheet sheet, int totalSalaryColumn, int employeeRow);

    Shift getShift(Sheet sheet, Map<String, Double> shiftRate, int colIndex, int employeeRow);

    WorkingDay getWorkingDay(Sheet sheet, Map<String, Double> shiftRate, int day, List<Integer> colIndexRange, int employeeRow);

    Employee getEmployee(Sheet sheet, Map<String, Double> shiftRate, Map<Integer, List<Integer>> colDayRange, int employeeRow, int totalSalaryColumn);

    List<Employee> readTimeSheet(String filePath) throws IOException;
}
