package com.teamftp.opendatajam1.model.converter;

import com.teamftp.opendatajam1.model.Coordinates;
import com.teamftp.opendatajam1.model.bristolapi.BristolApiModel;
import com.teamftp.opendatajam1.model.busrant.BusRantData;
import com.teamftp.opendatajam1.model.busrant.ScheduledArrivalTime;

import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.List;

public class BristolToBusRant {

    public BusRantData convert(BristolApiModel bam) {
        return BusRantData.builder()
                .stopName("")
                .routeNumber("")
                .scheduledArrivalTimes(convertScheduledArrivalTimes(bam))
                .build();
    }

    private List<ScheduledArrivalTime> convertScheduledArrivalTimes(BristolApiModel bam) {
        return Arrays.asList(
                ScheduledArrivalTime.builder()
                        .actualArrival(toLong(bam.getBusTimes().getActualArrival()))
                        .estimatedArrival(toLong(bam.getBusTimes().getEstimatedArrival()))
                        .geoLocation(Coordinates.builder()
                                .latitude(54.27)
                                .longitude(17.01)
                                .build())
                        .feedback(Feedback.builder()
                                .comment("")
                                .rating(4.9)
                                .build())
                        .build()
        );

    }

    private long toLong(OffsetDateTime offsetDateTime) {
        return offsetDateTime.toInstant().toEpochMilli();
    }

}
