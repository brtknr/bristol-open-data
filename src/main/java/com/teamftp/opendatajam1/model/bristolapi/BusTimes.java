package com.teamftp.opendatajam1.model.bristolapi;

import lombok.Builder;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
@Builder
public class BusTimes {

    private OffsetDateTime estimatedArrival;

    private OffsetDateTime actualArrival;

    private OffsetDateTime scheduledArrival;

}
