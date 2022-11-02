package com.bobocode.petros.hotelservice.usecase;

import com.bobocode.petros.hotelservice.entity.Hotel;
import com.bobocode.petros.hotelservice.entity.ClientHotelRequest;

import java.util.List;

public interface GetHotelsUseCase {
    List<Hotel> getHotelListByCharacterization(ClientHotelRequest characterization);
}
