package com.teamftp.opendatajam1.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Coordinates {

    private final double latitude;

    private final double longitude;

}
