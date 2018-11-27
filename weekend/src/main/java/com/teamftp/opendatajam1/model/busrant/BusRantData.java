package com.teamftp.opendatajam1.model.busrant;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * route_number_1:
 * stop_name_1: {
 * scheduled_arrivale_time_1: {
 * timestamp: long
 * estimated_arrival: long,
 * actual_arrival: long,
 * feedback: document,
 * geolocation: coordinates
 * },
 * scheduled_arrivale_time_2: { ... },
 * ...
 * },
 * stop_name_2: { ... },
 * ...
 * route_number_2: { ... },
 * ...
 */

@Data
@Builder
public class BusRantData {

    private String routeNumber;

    private String stopName;

    private List<ScheduledArrivalTime> scheduledArrivalTimes;

}
