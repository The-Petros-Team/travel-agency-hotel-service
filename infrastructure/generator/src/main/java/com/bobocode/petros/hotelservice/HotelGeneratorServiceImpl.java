package com.bobocode.petros.hotelservice;

import com.boboode.petros.hotelservice.adapter.HotelGeneratorAdapter;
import com.boboode.petros.hotelservice.entity.Hotel;
import com.boboode.petros.hotelservice.entity.ClientHotelRequest;
import com.boboode.petros.hotelservice.entity.Price;
import com.boboode.petros.hotelservice.entity.enumeration.Currency;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class HotelGeneratorServiceImpl implements HotelGeneratorAdapter {
    @Override
    public List<Hotel> generateHotelsByCharacterization(ClientHotelRequest characterization) {
        return IntStream.generate(() -> ThreadLocalRandom.current().nextInt(10, 100))
                .limit(6)
                .mapToObj(n -> Hotel.builder()
                        .hotelName(String.format("s% Hotel", characterization.city()))
                        .startDate(characterization.startDate())
                        .endDate(characterization.endDate())
                        .price(new Price(ThreadLocalRandom.current().nextLong(10, 1000), Currency.getRandomCurrency()))
                        .build())
                .collect(Collectors.toList());
    }
}
