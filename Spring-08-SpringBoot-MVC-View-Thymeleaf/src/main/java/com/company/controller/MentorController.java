package com.company.controller;

import com.company.enums.Gender;
import com.company.model.Mentor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/mentor")
public class MentorController {
    @GetMapping("/list")
    public String showTable(Model model) {
        List<Mentor> mentorList = new ArrayList<>();
        mentorList.add(new Mentor(1, "John", "Doe", 45, Gender.MALE));
        mentorList.add(new Mentor(2, "Joe", "David", 33, Gender.MALE));
        mentorList.add(new Mentor(3, "Jane", "Selene", 45, Gender.FEMALE));
        model.addAttribute("mentors", mentorList);

        return "/mentor/mentor-list";
    }
}
