package com.teamftp.opendatajam1.clients.transportapi;

public enum ResourceTrendType {
    STATIC(0),
    FILLING(1),
    EMPTYING(2);

    private final int value;

    ResourceTrendType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
