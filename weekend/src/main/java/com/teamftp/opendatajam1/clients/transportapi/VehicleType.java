package com.teamftp.opendatajam1.clients.transportapi;

public enum VehicleType {
    TRAM(0),
    SUBWAY(1),
    RAIL(2),
    BUS(3),
    FERRY(4),
    CABLE_CAR(5),
    GONDOLA(6),
    FUNICULAR(7),
    AIR(8),
    WALKING(9),
    CYCLE_OWNED(10),
    CYCLE_HIRED(11),
    CAR(12),
    COACH(13),
    ELECTRIC_VEHICLE(14),
    MULTIPLE(9000),
    UNSET(9999);

    private final int value;

    VehicleType(final int newValue) {
        value = newValue;
    }

    public int getValue() {
        return value;
    }
}
