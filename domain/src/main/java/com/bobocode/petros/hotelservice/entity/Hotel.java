package com.bobocode.petros.hotelservice.entity;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class Hotel {
    private String hotelName;
    private LocalDate startDate;
    private LocalDate endDate;
    private Price price;
}
