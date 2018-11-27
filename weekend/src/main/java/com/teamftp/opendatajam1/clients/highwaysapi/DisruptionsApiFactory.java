package com.teamftp.opendatajam1.clients.highwaysapi;

import com.teamftp.opendatajam1.AppConfiguration;
import com.teamftp.opendatajam1.clients.BaseApiClientFactory;
import io.swagger.client.api.DisruptionsApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class DisruptionsApiFactory extends BaseApiClientFactory<DisruptionsApi> {
    @Autowired
    DisruptionsApiFactory(AppConfiguration appConfiguration) {
        super(appConfiguration, DisruptionsApi.class);
    }

    @Override
    @Bean("DisruptionsApi")
    public DisruptionsApi getInstance() {
        return super.getInstance();
    }
}
