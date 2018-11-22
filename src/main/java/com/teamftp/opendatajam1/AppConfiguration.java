package com.teamftp.opendatajam1;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@ConfigurationProperties
@Component
public class AppConfiguration {
    private String apiKey;
}
