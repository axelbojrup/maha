package com.example.MahaCheckout.domain;

import lombok.Getter;

@Getter
public enum WatchEnum {

    ROLEX("001", "Rolex", 100),
    MICHAEL_KORS("002", "Michael Kors", 80),
    SWATCH("003", "Swatch", 50),
    CASIO("004", "Casio", 30),
    UNKNOWN("000", "Unknown", 0);

    private String id;
    private String name;
    private long unitPrice;

    WatchEnum(String id, String name, long unitPrice){
        this.id = id;
        this.name = name;
        this.unitPrice = unitPrice;
    }

    public static WatchEnum toDomain(String watchId) {
        switch (watchId) {
            case "001":
                return ROLEX;
            case "002":
                return MICHAEL_KORS;
            case "003":
                return SWATCH;
            case "004":
                return CASIO;
            default:
                return UNKNOWN;
        }
    }
}
