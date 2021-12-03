package com.company;

import com.company.repository.DepartmentRepository;
import com.company.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
@AllArgsConstructor
public class Spring09OrmMappingJpqlNamedQueriesApplication {

    EmployeeRepository employeeRepository;
    DepartmentRepository departmentRepository;

    public static void main(String[] args) {
        SpringApplication.run(Spring09OrmMappingJpqlNamedQueriesApplication.class, args);
    }

    @PostConstruct
    public void testEmployee() {
        System.out.println(employeeRepository.getEmployeeDetail());
        System.out.println(employeeRepository.getEmloyeeSalary());
        System.out.println(employeeRepository.getEmployeeByEmail("myakovlivf@ucsd.edu"));
        employeeRepository.updateEmployeeJPQL(1l);

        System.out.println(employeeRepository.retrieveEmployeeSalaryGreaterThan(100000));

        System.out.println(departmentRepository.findOzzyDepartment("Kids"));

        System.out.println(departmentRepository.countAllDepartments());

    }
}
