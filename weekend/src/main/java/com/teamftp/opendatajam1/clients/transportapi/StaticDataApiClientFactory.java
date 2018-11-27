package com.teamftp.opendatajam1.clients.transportapi;

import com.teamftp.opendatajam1.AppConfiguration;
import com.teamftp.opendatajam1.clients.BaseApiClientFactory;
import io.swagger.client.api.StaticDataApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

/**
 * https://portal-bristol.api.urbanthings.io/scripts/swagger-ui/dist/index.html
 */
@Service
class StaticDataApiClientFactory extends BaseApiClientFactory<StaticDataApi> {
    @Autowired
    protected StaticDataApiClientFactory(AppConfiguration appConfiguration) {
        super(appConfiguration, StaticDataApi.class);
    }

    @Override
    @Bean("StaticDataApi")
    public StaticDataApi getInstance() {
        return super.getInstance();
    }
}
