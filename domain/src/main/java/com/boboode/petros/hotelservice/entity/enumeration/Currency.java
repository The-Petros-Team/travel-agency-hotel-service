package com.boboode.petros.hotelservice.entity.enumeration;

import java.util.concurrent.ThreadLocalRandom;

public enum Currency {
    USD,
    EUR,
    DKK,
    PLN,
    GBP,
    BTC;

    public static Currency getRandomCurrency() {
        return values()[ThreadLocalRandom.current().nextInt(values().length)];
    }
}
