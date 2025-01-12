package org.learning.Money;

public enum Note {

    TEN_RUPEE(10),
    TWENTY_RUPEE(20),
    FIFTY_RUPEE(50),
    HUNDRED_RUPEE(100),
    TWO_HUNDRED_RUPEE(200);

    private final int value;

    Note(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
