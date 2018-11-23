package com.teamftp.opendatajam1.clients.transportapi;

import com.teamftp.opendatajam1.AppConfiguration;
import com.teamftp.opendatajam1.clients.BaseApiClientFactory;
import io.swagger.client.api.AdvancePlanningApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
class AdvancePlanningApiFactory extends BaseApiClientFactory<AdvancePlanningApi> {
    @Autowired
    protected AdvancePlanningApiFactory(AppConfiguration appConfiguration) {
        super(appConfiguration, AdvancePlanningApi.class);
    }

    @Override
    @Bean("AdvancePlanningApi")
    public AdvancePlanningApi getInstance() {
        return super.getInstance();
    }
}
