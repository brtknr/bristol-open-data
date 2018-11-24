package com.teamftp.opendatajam1.model.bristolapi;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class BusLine {

    private String name;

    private List<BusStop> stops  = new ArrayList<>();

    private List<Bus> operatingBuses  = new ArrayList<>();

    private BusStop previousStop;

    private BusStop nextStop;
    
    private List<String> usersFeedback = new ArrayList<>();
}
