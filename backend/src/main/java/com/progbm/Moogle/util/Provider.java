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

    /**
     * 이름을 받아서 Provider 반환. default 는 NETFLIX
     * @param name
     * @return
     */
    public static Provider getProvider(String name) {
        Provider[] values = Provider.values();
        for (Provider provider : values) {
            if (provider.name.equals(name)) {
                return provider;
            }
        }
        return Provider.NETFLIX;
    }
}
