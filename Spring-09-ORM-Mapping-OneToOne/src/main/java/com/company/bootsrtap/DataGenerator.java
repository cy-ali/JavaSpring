package com.company.bootsrtap;

import com.company.entity.Department;
import com.company.entity.Employee;
import com.company.entity.Region;
import com.company.enums.Gender;
import com.company.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataGenerator implements CommandLineRunner {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public void run(String... args) throws Exception {
        Employee e1 = new Employee("Berrie", "Manueau", "bmanueau0@dion.ne.jp", LocalDate.of(2006, 4, 20), Gender.F, 154864);
        Employee e2 = new Employee("Aeriell", "McNee", "amcnee1@google.es", LocalDate.of(2009, 1, 26), Gender.F, 56752);
        Employee e3 = new Employee("Sydney", "Symonds", "ssymonds2@hhs.gov", LocalDate.of(2010, 5, 17), Gender.F, 95313);
        Employee e4 = new Employee("Avrom", "Rowantree", null, LocalDate.of(2014, 8, 2), Gender.M, 119674);
        Employee e5 = new Employee("Feliks", "Morffew", "fmorffew4@a8.net", LocalDate.of(2003, 1, 14), Gender.M, 55307);

        Department d1 = new Department("Clothing", "Home");
        Department d2 = new Department("Furniture", "Home");
        Department d3 = new Department("Sports", "Outdoors");
        Department d4 = new Department("Children Clothing", "Kids");
        Department d5 = new Department("Toys", "Kids");

        Region r1 = new Region("SouthWest", "US");
        Region r2 = new Region("NorthEast", "US");
        Region r3 = new Region("NorthWest", "US");
        Region r4 = new Region("East Asia", "Asia");
        Region r5 = new Region("Quebec", "Canada");

        e1.setDepartment(d1);
        e2.setDepartment(d2);
        e3.setDepartment(d3);
        e4.setDepartment(d4);
        e5.setDepartment(d5);

        e1.setRegion(r1);
        e2.setRegion(r2);
        e3.setRegion(r3);
        e4.setRegion(r4);
        e5.setRegion(r5);

        employeeRepository.save(e1);
        employeeRepository.save(e2);
        employeeRepository.save(e3);
        employeeRepository.save(e4);
        employeeRepository.save(e5);
    }
}
