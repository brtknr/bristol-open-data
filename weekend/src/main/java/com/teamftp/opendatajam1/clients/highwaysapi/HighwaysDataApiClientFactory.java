package com.teamftp.opendatajam1.clients.highwaysapi;

import com.teamftp.opendatajam1.AppConfiguration;
import com.teamftp.opendatajam1.clients.BaseApiClientFactory;
import io.swagger.client.api.HighwaysDataApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class HighwaysDataApiClientFactory extends BaseApiClientFactory<HighwaysDataApi> {
    @Autowired
    protected HighwaysDataApiClientFactory(AppConfiguration appConfiguration) {
        super(appConfiguration, HighwaysDataApi.class);
    }

    @Override
    @Bean("HighwaysDataApi")
    public HighwaysDataApi getInstance() {
        return super.getInstance();
    }
}
