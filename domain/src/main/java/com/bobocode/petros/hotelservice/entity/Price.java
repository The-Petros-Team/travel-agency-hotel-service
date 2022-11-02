package com.bobocode.petros.hotelservice.entity;

import com.bobocode.petros.hotelservice.entity.enumeration.Currency;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Price {
    private Long value;
    private Currency currency;
}
