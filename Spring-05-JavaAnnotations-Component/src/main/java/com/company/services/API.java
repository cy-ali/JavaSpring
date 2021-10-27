package com.company.services;

import com.company.interfaces.Course;
import org.springframework.stereotype.Component;

@Component
public class API implements Course {
    @Override
    public void getTeachingHours() {
        System.out.println("Weekly teaching hours : 7");
    }
}
