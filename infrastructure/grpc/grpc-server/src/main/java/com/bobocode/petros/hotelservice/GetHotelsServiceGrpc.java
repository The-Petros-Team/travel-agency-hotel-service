package com.bobocode.petros.hotelservice;

import com.bobocode.petros.hotelservice.proto.*;
import com.bobocode.petros.hotelservice.entity.Hotel;
import com.bobocode.petros.hotelservice.entity.ClientHotelRequest;
import com.bobocode.petros.hotelservice.usecase.GetHotelsUseCase;
import com.google.protobuf.Timestamp;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.stream.Collectors;

@GrpcService
@Service
@RequiredArgsConstructor
public class GetHotelsServiceGrpc extends HotelServiceGrpc.HotelServiceImplBase {
    private final GetHotelsUseCase getHotelsUseCase;

    @Override
    public void getHotels(HotelRequest request, StreamObserver<MultipleHotelResponse> responseObserver) {
        var hotelsResponse = MultipleHotelResponse.newBuilder().addAllHotels(getHotelsUseCase.getHotelListByCharacterization(toHotelCharacterization(request))
                        .stream()
                        .map(this::toHotelResponse)
                        .collect(Collectors.toList()))
                .build();
        responseObserver.onNext(hotelsResponse);
        responseObserver.onCompleted();
    }

    private HotelResponse toHotelResponse(Hotel hotel) {
        return HotelResponse.newBuilder()
                .setHotel(hotel.getHotelName())
                .setStartDate(Timestamp.newBuilder()
                        .setSeconds(hotel.getStartDate().toEpochDay())
                        .build())
                .setEndDate(Timestamp.newBuilder()
                        .setSeconds(hotel.getEndDate().toEpochDay())
                        .build())
                .setPrice(Price.newBuilder()
                        .setPrice(hotel.getPrice().getValue())
                        .setCurrency(hotel.getPrice().getCurrency().name())
                        .build())
                .build();
    }

    private ClientHotelRequest toHotelCharacterization(HotelRequest request) {
        return ClientHotelRequest.builder()
                .country(request.getCountry())
                .city(request.getCity())
                .startDate(LocalDateTime.ofEpochSecond(request.getStartDate().getSeconds(), request.getStartDate().getNanos(), ZoneOffset.UTC).toLocalDate())
                .endDate(LocalDateTime.ofEpochSecond(request.getEndDate().getSeconds(), request.getEndDate().getNanos(), ZoneOffset.UTC).toLocalDate())
                .build();
    }
}

