//package com.csLtd.controller;
//
//import com.csLtd.model.Employee;
//import com.csLtd.service.employee.EmployeeService;
//import com.csLtd.view.ExelView;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.List;
//
//import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
//
//@SpringBootTest
//@RunWith(SpringRunner.class)
//class EmployeeControllerTest {
//    @Autowired
//    EmployeeController employeeController;
//    @Autowired
//    ExelView view;
//    @Autowired
//    EmployeeService employeeService;
//
//    @BeforeEach
//    void setUp() {
//    }
//
//    @Test
//    void shouldReturnNumberRowsEqualsCountAllEmployees() {
//        List<Employee> all = employeeService.findAll();
//        view.outAllEmployees(all);
//        assertThat(all.size()).isEqualTo(view.getNumberRows());
//    }
//}