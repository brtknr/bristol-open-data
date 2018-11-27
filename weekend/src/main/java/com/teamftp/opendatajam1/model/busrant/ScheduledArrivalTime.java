package com.teamftp.opendatajam1.model.busrant;

import com.teamftp.opendatajam1.model.Coordinates;
import com.teamftp.opendatajam1.model.converter.Feedback;
import lombok.Builder;
import lombok.Data;

/**
    *  scheduled_arrivale_time_1: {
    *            timestamp: long
    *            estimated_arrival: long,
    *            actual_arrival: long,
    *            feedback: document,
    *            geolocation: coordinates
    *        },
 */
@Data
@Builder
public class ScheduledArrivalTime {

    private Long timestamp;

    private Long estimatedArrival;

    private Long actualArrival;

    private Feedback feedback;

    private Coordinates geoLocation;

}
