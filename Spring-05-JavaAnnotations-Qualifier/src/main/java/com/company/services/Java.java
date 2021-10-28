package com.company.services;

import com.company.interfaces.Course;
import com.company.interfaces.ExtraSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Java implements Course {

    //Field Injection
//    @Autowired
//    @Qualifier("officeHours")
    private ExtraSession extraSession;

    //Constructor Injection
    @Autowired
    public Java(@Qualifier("officeHours") ExtraSession extraSession) {
        this.extraSession = extraSession;
    }

    //Setter Injection
//    @Autowired
//    public void setExtraSession(ExtraSession extraSession) {
//        this.extraSession = extraSession;
//    }

    @Override
    public void getTeachingHours() {
        System.out.println("Weekly teaching hours : " + (40 + extraSession.getHours()));
    }
}
