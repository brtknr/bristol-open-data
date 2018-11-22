package com.teamftp.opendatajam1.transportapiclients;

import com.teamftp.opendatajam1.AppConfiguration;
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
    AdvancePlanningApi getInstance() {
        return super.getInstance();
    }
}
