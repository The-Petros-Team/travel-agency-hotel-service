package com.bobocode.petros.hotelservice.adapter;

import com.bobocode.petros.hotelservice.entity.ClientHotelRequest;
import com.bobocode.petros.hotelservice.entity.Hotel;

import java.util.List;

public interface HotelGeneratorAdapter {

    List<Hotel> generateHotelsByCharacterization(ClientHotelRequest characterization);

}
