package com.company;

import com.company.repository.DepartmentRepository;
import com.company.repository.EmployeeRepository;
import com.company.repository.RegionRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
@AllArgsConstructor
public class Spring09OrmDerivedQueriesApplication {


    RegionRepository regionRepository;
    DepartmentRepository departmentRepository;
    EmployeeRepository employeeRepository;

    public static void main(String[] args) {
        SpringApplication.run(Spring09OrmDerivedQueriesApplication.class, args);
    }

    @PostConstruct
    public void testRegions() {
        System.out.println("-------Regions Start-------");
        System.out.println("findAllByCountry(Canada) = " + regionRepository.findRegionByCountry("Canada"));
        System.out.println("regionRepository.findDistinctByCountry(Canada) = " + regionRepository.findDistinctByCountry("Canada"));
        System.out.println("regionRepository.findAllByCountryContains(United) = " + regionRepository.findAllByCountryContains("United"));
        System.out.println("regionRepository.findByCountryContainsOrderBy(United) = " + regionRepository.findByCountryContainsOrderByCountry("United"));
        System.out.println("regionRepository.findTop2ByCountry(Canada) = " + regionRepository.findTop2ByCountry("Canada"));
        System.out.println("-------Regions End-------");

    }

    @PostConstruct
    public void testDepartments() {

        System.out.println("---------Department start------------");

        System.out.println("findByDepartment: " + departmentRepository.findByDepartment("Toys"));
        System.out.println("findByDivision: " + departmentRepository.findByDivision("Outdoors"));
        System.out.println("findByDivisionEndingWith: " + departmentRepository.findByDivisionEndsWith("ics"));
        System.out.println("findDistinctTop3ByDivisionContains: " + departmentRepository.findDistinctTop3ByDivisionContains("Hea"));

        System.out.println("---------Department End------------");

    }

    @PostConstruct
    public void testEmployees() {

        System.out.println("---------Employee start------------");

        System.out.println(employeeRepository.findByEmailIsNull());


        System.out.println("---------Employee End------------");

    }

}
