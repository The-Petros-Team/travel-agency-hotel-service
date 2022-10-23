package com.boboode.petros.hotelservice.entity;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public record ClientHotelRequest(String country, String city, LocalDate startDate, LocalDate endDate) {
}
