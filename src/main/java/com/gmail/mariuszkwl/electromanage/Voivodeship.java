package com.gmail.mariuszkwl.electromanage;

public enum Voivodeship {
    DS("dolnośląskie"), KP("kujawsko-pomorskie"), LU("lubelskie"), LB("lubuskie"),
    LD("łódzkie"), MA("małopolskie"), MZ("mazowieckie"), OP("opolskie"),
    PK("podkarpackie"), PD("podlaskie"), PM("pomorskie"), SL("śląskie"),
    SK("świętokrzyskie"), WN("warmińsko-mazurskie"), WP("wielkopolskie"),
    ZP("zachodniopomorskie");

    final private String label;

    Voivodeship(String label) {
        this.label = label;
    }

    public static Voivodeship findByLabel(String byLabel) {
        for (Voivodeship v : Voivodeship.values()) {
            if (v.label.equalsIgnoreCase(byLabel)) {
                return v;
            }
        }
        return null;
    }
}
