package com.csLtd;

import com.csLtd.controller.EmployeeController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeesManagerApplication implements CommandLineRunner {
    final EmployeeController employeeController;

    @Autowired
    public EmployeesManagerApplication(EmployeeController employeeController) {
        this.employeeController = employeeController;
    }

    public static void main(String[] args) {
        SpringApplication.run(EmployeesManagerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        employeeController.findAllEmployeesAndSendToView();
    }

}
