package com.example.swisstool;

public enum HomeOptions {
    ALPHABET_VIEWER("Alphabet Viewer"),
    STRESS_TAPPER("Stress Tapper"),
    BIRTHSTONES("BirthStones"),
    ANIMAL_HOUSE("Animal House");

    private String name;

    HomeOptions(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
