package com.teamftp.opendatajam1.model.bristolapi;

import lombok.Builder;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
@Builder
public class Bus {

    private OffsetDateTime timestamp;

    private BusTimes busTimes;

    private BusLine route;

}
