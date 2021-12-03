package com.company.repository;

import com.company.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("SELECT e FROM Employee e where e.email='dtrail8@tamu.edu'")
    Employee getEmployeeDetail();

    @Query("SELECT e.salary FROM Employee e where e.email='dtrail8@tamu.edu'")
    Integer getEmloyeeSalary();

    @Query("SELECT e FROM Employee e WHERE e.email=?1")
    Optional<Employee> getEmployeeByEmail(String email);

    @Query("select e from Employee e where e.email=?1 and e.salary=?2")
    Optional<Employee> getEmployeeByEmailAndSalary(String email, Integer salary);

    @Query("select e from Employee e where e.salary=:salary")
    Employee getEmployeeBySalary(@Param("salary") int salary);

    @Query("select e from Employee e where e.salary=:salary or e.firstName=:name")
    Employee getEmployeeByFirstnameOrSalary(@Param("name") String firstName, @Param("salary") Integer salary);

    @Query("select e from Employee e where e.salary <>:salary")
    List<Employee> getEmployeeBySalaryNotEqual(@Param("salary") int salary);

    @Query("select e from Employee e where e.firstName like %:pattern")
    List<Employee> getEmployeeByFirstNameLike(@Param("pattern") String pattern);

    @Query("select e from Employee e where e.salary < :salary")
    List<Employee> getEmployeeBySalaryLessThan(@Param("salary") int salary);

    //Greater Than
    @Query("SELECT e FROM Employee e WHERE e.salary > ?1")
    List<Employee> getEmployeeBySalaryGreaterThan(Integer salary);

    //Between
    @Query("SELECT e FROM Employee e WHERE e.salary BETWEEN ?1 AND ?2")
    List<Employee> getEmployeeBySalaryBetween(int salary1, int salary2);

    //Before
    @Query("SELECT e FROM Employee e WHERE e.hireDate > ?1")
    List<Employee> getEmployeeByHireDateBefore(LocalDate date);

    //Null
    @Query("SELECT e FROM Employee e WHERE e.email IS NULL")
    List<Employee> getEmployeeByEmailIsNull();

    //Not Null
    @Query("SELECT e FROM Employee e WHERE e.email IS NOT NULL")
    List<Employee> getEmployeeByEmailIsNotNull();

    //Sort Salary in ascending order
    @Query("SELECT e FROM Employee e ORDER BY e.salary")
    List<Employee> getEmployeeBySalaryOrderByAsc();

    //Sort Salary in descending order
    @Query("SELECT e FROM Employee e ORDER BY e.salary DESC ")
    List<Employee> getEmployeeBySalaryOrderByDesc();

    //Native Query
    @Query(value = "SELECT * FROM employees WHERE salary = ?1", nativeQuery = true)
    List<Employee> readEmployeeBySalary(int salary);

    @Modifying
    @Transactional
    @Query("UPDATE Employee e SET e.email ='admin@email.com' WHERE e.id=:id")
    void updateEmployeeJPQL(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE employees SET email='admin@email.com' WHERE id=:id", nativeQuery = true)
    void updateEmployeeNativeQuery(@Param("id") Integer id);

    //Named Query
    List<Employee> retrieveEmployeeSalaryGreaterThan(Integer salary);

}
