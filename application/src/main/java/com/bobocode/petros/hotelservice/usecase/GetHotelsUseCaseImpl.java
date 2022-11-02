package com.bobocode.petros.hotelservice.usecase;

import com.bobocode.petros.hotelservice.adapter.HotelGeneratorAdapter;
import com.bobocode.petros.hotelservice.entity.ClientHotelRequest;
import com.bobocode.petros.hotelservice.entity.Hotel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GetHotelsUseCaseImpl implements GetHotelsUseCase {
    private final HotelGeneratorAdapter adapter;

    @Override
    public List<Hotel> getHotelListByCharacterization(ClientHotelRequest characterization) {
        return adapter.generateHotelsByCharacterization(characterization);
    }
}
