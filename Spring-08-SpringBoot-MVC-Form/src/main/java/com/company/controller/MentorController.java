package com.company.controller;

import com.company.model.Mentor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/mentor")
public class MentorController {

    @GetMapping("/register")
    public String showForm(Model model) {
        model.addAttribute("mentor", new Mentor());

        List<String> batchList = Arrays.asList("B7", "B8", "B10", "B11", "B12", "B13", "EU1", "EU2", "EU3", "EU4", "EU5");
        model.addAttribute("batchList", batchList);
        return "mentor/mentor-register";
    }

    @PostMapping("/confirm")
    public String submitForm(@ModelAttribute("mentor") Mentor mentorForm) {

        System.out.println("mentor = " + mentorForm);
        return "/mentor/mentor-confirmation";
    }

}
