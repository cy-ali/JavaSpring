package com.company.services;

import com.company.interfaces.Course;
import com.company.interfaces.ExtraSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Arrays;

@Component
public class Java implements Course {

    private ExtraSession extraSession;

    @Autowired
    public Java(@Qualifier("officeHours") ExtraSession extraSession) {
        this.extraSession = extraSession;
    }

    @Override
    public void getTeachingHours() {
        System.out.println("Weekly teaching hours : " + (40 + extraSession.getHours()));
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("Executing post construct");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("Executing pre destroy");
    }
}
