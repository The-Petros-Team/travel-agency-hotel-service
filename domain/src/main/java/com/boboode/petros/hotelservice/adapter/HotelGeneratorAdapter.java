package com.boboode.petros.hotelservice.adapter;

import com.boboode.petros.hotelservice.entity.Hotel;
import com.boboode.petros.hotelservice.entity.ClientHotelRequest;

import java.util.List;

public interface HotelGeneratorAdapter {

    List<Hotel> generateHotelsByCharacterization(ClientHotelRequest characterization);

}
