package com.company.controller;

import com.company.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @GetMapping("/register")
    public String registerPage(Model model) {
        ArrayList<String> stateList = new ArrayList<>();
        stateList.add("Georgia");
        stateList.add("Hawaii");
        stateList.add("Arizona");
        stateList.add("New York");
        stateList.add("Montana");
        model.addAttribute("employee", new Employee());
        model.addAttribute("stateList", stateList);
        return "/employee/employee-register";
    }

    @PostMapping("/confirm")
    public String submitForm(@ModelAttribute("employee") Employee employee) {
        System.out.println("employee = " + employee);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        //convert String to LocalDate
        System.out.println("employee.getBirthday() = " + employee.getBirthday());
        LocalDate birthdayDate = LocalDate.parse(employee.getBirthday(), formatter);
        employee.setAge(Period.between(birthdayDate, LocalDate.now()).getYears());
        return "/employee/employee-confirmation";
    }

}
