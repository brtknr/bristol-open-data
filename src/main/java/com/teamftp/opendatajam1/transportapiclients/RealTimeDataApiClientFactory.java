package com.teamftp.opendatajam1.transportapiclients;

import com.teamftp.opendatajam1.AppConfiguration;
import io.swagger.client.api.RealTimeDataApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

/**
 * https://portal-bristol.api.urbanthings.io/scripts/swagger-ui/dist/index.html
 */
@Service
class RealTimeDataApiClientFactory extends BaseApiClientFactory<RealTimeDataApi> {
    @Autowired
    protected RealTimeDataApiClientFactory(AppConfiguration appConfiguration) {
        super(appConfiguration, RealTimeDataApi.class);
    }

    @Override
    @Bean("RealTimeDataApi")
    RealTimeDataApi getInstance() {
        return super.getInstance();
    }
}