package com.teamftp.opendatajam1.model.converter;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Feedback {

    private String comment;

    private double rating;

}
