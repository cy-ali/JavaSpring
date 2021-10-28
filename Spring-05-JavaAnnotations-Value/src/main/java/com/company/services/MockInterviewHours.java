package com.company.services;

import com.company.interfaces.ExtraSession;
import org.springframework.stereotype.Component;

@Component
public class MockInterviewHours implements ExtraSession {
    @Override
    public int getHours() {
        return 9;
    }
}
