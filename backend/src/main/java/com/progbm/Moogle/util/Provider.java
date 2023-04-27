package com.progbm.Moogle.util;

public enum Provider {
    APPLE("Apple TV", 2),
    NETFLIX("Netflix", 8),
    AMAZON("Amazon Prime Video", 9),
    WATCHA("Watcha", 97),
    YOUTUBE_PREMIUM("YouTube Premium", 188),
    DISNEY("Disney Plus", 390)
    ;

    public String name;
    public int providerId;

    Provider(String name, int providerId) {
        this.name = name;
        this.providerId = providerId;
    }
}
