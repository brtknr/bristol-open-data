package com.teamftp.opendatajam1;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@ConfigurationProperties
@Component
public class AppConfiguration {
    private String apiKey;

    public String getApiVersion() {
        return "2.0";
    }

    public double getBristolLatitude() {
        return 51.454514;
    }

    public double getBristolLongitude() {
        return -2.587910;
    }
}
