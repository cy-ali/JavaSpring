package com.company.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @RequestMapping("/home")
    public String getRequestMapping() {
        return "home";
    }

    @RequestMapping("/index")
    public String getRequestMapping2() {
        return "index";
    }

    @GetMapping("/spring")
    public String getMapping() {
        return "spring";
    }


    @GetMapping("/spring-boot")
    public String getMapping1() {
        return "spring-boot";
    }

    @GetMapping("/post-mapping")
    public String getMapping2() {
        return "home";
    }

    @PostMapping("/post-mapping")
    public String postMapping() {
        return "post-mapping";
    }

//    @PostMapping("/spring")
//    public String postMapping2() {
//        return "spring";
//    }

    @GetMapping("home/{name}")
    public String pathVariableEx(@PathVariable String name) {
        System.out.println("name = " + name);
        return "home";
    }

    @GetMapping("/home/{name}/{email}")
    public String pathVariableEx2(@PathVariable String name, @PathVariable String email) {
        System.out.println("name = " + name + " email = " + email);
        return "home";
    }

    @GetMapping("/home/course")
    public String requestParamEx(@RequestParam("firstname") String firstname, @RequestParam("lastname") String lastname) {
        System.out.println("name = " + firstname + " " + lastname);
        return "home";
    }

    @GetMapping("/home/query")
    public String requestParamEx(@RequestParam(value = "name", required = false, defaultValue = "default name") String name) {
        System.out.println("name = " + name);
        return "home";
    }
}
