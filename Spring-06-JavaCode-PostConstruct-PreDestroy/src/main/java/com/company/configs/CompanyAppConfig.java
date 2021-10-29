package com.company.configs;

import com.company.interfaces.ExtraSession;
import com.company.services.Java;
import com.company.services.OfficeHours;
import com.company.services.Selenium;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.company")
@PropertySource("classpath:application.properties")
public class CompanyAppConfig {

    @Bean
    public Java java() {
        return new Java(extraSession());
    }

    @Bean
    public Selenium selenium() {
        return new Selenium();
    }

    public ExtraSession extraSession() {
        return new OfficeHours();
    }
}