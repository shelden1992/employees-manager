//package com.csLtd.service;
//
//import com.csLtd.model.Employee;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Map;
//import java.util.stream.Collectors;
//
///**
// * Created by Shelupets Denys on 22.12.2020.
// */
//@Service
//public class FormatterService {
//    public long getSum(List<Employee> employeeList) {
//        return employeeList.stream().mapToLong(Employee::getSalary).sum();
//    }
//
//    private Map<String, Long> getCompanyNameAndCountEmployees(List<Employee> employeeList) {
//        return employeeList.stream().collect(Collectors.groupingBy(employee -> employee.getDepartment().getCompany().getCompanyName(), Collectors.counting()));
//    }
//
//    public String getFormattedStringCompanyNameAndCountEmployees(List<Employee> employeeList) {
//        StringBuffer stringBuffer = new StringBuffer();
//        getCompanyNameAndCountEmployees(employeeList).forEach((name, countEmployee) -> {
//            stringBuffer.append(String.format("В компании: %s, сотрудников: %s", name, countEmployee + "\n"));
//        });
//        return stringBuffer.toString();
//    }
//}
