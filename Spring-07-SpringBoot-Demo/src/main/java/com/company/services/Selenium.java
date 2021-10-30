package com.company.services;

import com.company.interfaces.Course;
import org.springframework.stereotype.Component;

@Component
public class Selenium implements Course {
    @Override
    public int getTeachingHours() {
        return 10;
    }
}
