package com.bobocode.petros.hotelservice.usecase;

import com.boboode.petros.hotelservice.adapter.HotelGeneratorAdapter;
import com.boboode.petros.hotelservice.entity.Hotel;
import com.boboode.petros.hotelservice.entity.ClientHotelRequest;
import com.boboode.petros.hotelservice.usecase.GetHotelsUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetHotelsUseCaseImpl implements GetHotelsUseCase {
    private final HotelGeneratorAdapter adapter;

    @Override
    public List<Hotel> getHotelListByCharacterization(ClientHotelRequest characterization) {
        return adapter.generateHotelsByCharacterization(characterization);
    }
}
