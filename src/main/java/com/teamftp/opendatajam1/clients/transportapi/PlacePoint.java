package com.teamftp.opendatajam1.clients.transportapi;

public enum PlacePoint {
    PLACE(0),
    ROAD(1),
    TRANSIT_STOP(2),
    POSTCODE(3),
    LAT_LNG(4),
    LOCALITY(5),
    POI(6),
    TRANSIT_STOP_TRAM(100),
    TRANSIT_STOP_SUBWAY(101),
    TRANSIT_STOP_RAIL(102),
    TRANSIT_STOP_BUS(103),
    TRANSIT_STOP_FERRY(104),
    TRANSIT_STOP_CABLE_CAR(105),
    TRANSIT_STOP_GONDOLA(106),
    TRANSIT_STOP_FUNICULAR(107),
    TRANSIT_STOP_AIR(108),
    CYCLE_HIRE_DOCK(111),
    CAR_PARKING_SPACE(112);

    private final int value;

    PlacePoint(final int newValue) {
        value = newValue;
    }

    public int getValue() {
        return value;
    }
}
