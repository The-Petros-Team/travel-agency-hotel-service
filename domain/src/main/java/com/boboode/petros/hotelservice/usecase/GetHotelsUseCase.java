package com.boboode.petros.hotelservice.usecase;

import com.boboode.petros.hotelservice.entity.Hotel;
import com.boboode.petros.hotelservice.entity.HotelCharacterization;

import java.util.List;

public interface GetHotelsUseCase {
    List<Hotel> getHotelListByCharacterization(HotelCharacterization characterization);
}
