package com.csLtd;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeesManagerApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(EmployeesManagerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
    }

}
