package com.company.interfaces.carpetPrices;

import com.company.enums.City;

import java.math.BigDecimal;

public interface Carpet {
    BigDecimal getSqFtPrice(City city);
}
