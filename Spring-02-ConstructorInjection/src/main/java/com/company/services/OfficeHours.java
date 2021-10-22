package com.company.services;

import com.company.interfaces.ExtraSessions;

public class OfficeHours implements ExtraSessions {
    @Override
    public int getHours() {
        return 5;
    }
}
