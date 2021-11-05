package com.company.controller;

import com.company.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/student")
public class StudentController {

    @GetMapping("/welcome")
    public String homePage(Model model) {


        model.addAttribute("name", "John");
        model.addAttribute("course", "Java Developer");
        model.addAttribute("subject", "Collections");

        Random random = new Random();
        int ID = random.nextInt(100);
        model.addAttribute("studentID", ID);

        List<Integer> numbers = new ArrayList<>(Arrays.asList(4, 5, 6, 10, 11));
        model.addAttribute("numbers", numbers);

        LocalDate birthdate = LocalDate.of(1988, 10, 10);
        model.addAttribute("birthday", birthdate);

        Student student = new Student(1, "Joe", "Allen");
        model.addAttribute(student);

        return "student/welcome";
    }

    @GetMapping("/register")
    public String homePage2() {


        return "student/register";
    }

}
