package com.teamftp.opendatajam1.model.bristolapi;

import com.teamftp.opendatajam1.model.Coordinates;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class BusStop {

    private String name;

    private Coordinates coordinates;

    private List<BusLine> busLines;
}
