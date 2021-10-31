package com.company.calculator;

import com.company.enums.City;
import com.company.interfaces.carpetPrices.Carpet;
import com.company.interfaces.floorTypes.Floor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class Calculator {

    @Qualifier("carpetVA")
    @Autowired
    private Carpet carpet;

    @Qualifier("kitchen")
    @Autowired
    private Floor floor;

    public String getTotalCarpetCost(City city) {

        BigDecimal cost = carpet.getSqFtPrice(city).multiply(floor.getArea());
        if (cost.compareTo(BigDecimal.ZERO) == 0) {
            throw new IllegalArgumentException("This city does not exist");
        }
        return "Total Cost for Carpet : " + cost;
    }

}
