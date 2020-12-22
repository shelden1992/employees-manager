package com.csLtd.service;

import com.csLtd.model.Company;
import com.csLtd.model.Department;
import com.csLtd.model.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@RunWith(SpringRunner.class)
class FormatterServiceTest {
    @Autowired
    private FormatterService formatterService;
    private ArrayList<Employee> employees;

    @BeforeEach
    void setUp() {
        Company it_develop = new Company(1, "IT_develop", "", "");
        Company game_develop = new Company(2, "Game_develop", "", "");
        Company develop = new Company(3, "Develop", "", "");
        Department hr = new Department(1, "HR", it_develop, "");
        Department engineer = new Department(2, "Engineer", game_develop, "");
        Department transport = new Department(3, "Transport", develop, "");
        employees = new ArrayList<>() {{
            add(new Employee(1, "Den", "Shel", null, 22, 1_000_000, hr));
            add(new Employee(2, "Valera", "Ivanov", null, 32, 2_000_000, engineer));
            add(new Employee(3, "Dima", "Malenovskiy", null, 27, 2_000_000, transport));
        }};
    }

    @Test
    void shouldReturnCorrectSumOfSalary() {
        assertThat(formatterService.getSum(employees)).isEqualTo(5_000_000);
    }

    @Test
    void shouldReturnFormatterString() {
        String expected1 = "В компании: Game_develop, сотрудников: 1\n";
        String expected2 = "В компании: IT_develop, сотрудников: 1\n";
        String expected3 = "В компании: Develop, сотрудников: 1\n";
        assertThat(formatterService.getFormattedStringCompanyNameAndCountEmployees(employees)).contains(expected1);
        assertThat(formatterService.getFormattedStringCompanyNameAndCountEmployees(employees)).contains(expected2);
        assertThat(formatterService.getFormattedStringCompanyNameAndCountEmployees(employees)).contains(expected3);
    }
}