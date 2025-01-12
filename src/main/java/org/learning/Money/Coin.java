package org.learning.Money;

public enum Coin {

    ONE_RUPEE(1),
    TWO_RUPEE(2),
    FIVE_RUPEE(5),
    TEN_RUPEE(10),
    TWENTY_RUPEE(20);

    private final int value;

    Coin(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
