package com.company;

import com.company.interfaces.Course;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CompanyApp {
    public static void main(String[] args) {
        ApplicationContext container = new ClassPathXmlApplicationContext("config.xml");
        Course java1 = container.getBean("java", Course.class);
        java1.getTeachingHours();
        Course selenium1 = container.getBean("selenium", Course.class);
        selenium1.getTeachingHours();
    }
}
