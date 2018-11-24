package com.teamftp.opendatajam1.model.bristolapi;

import com.teamftp.opendatajam1.model.Coordinates;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AwaitingPeople {

    private long busId;

    private Coordinates coordinates;

    private BusTimes busTimes;

}
