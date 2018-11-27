package com.teamftp.opendatajam1.clients.transportapi;

import io.swagger.client.ApiException;
import io.swagger.client.api.RealTimeDataApi;
import io.swagger.client.model.APIResponseTransitStopRTIResponse;
import io.swagger.client.model.TransitStopRTIReport;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RealTimeDataApiClientFactoryTest {
    @Autowired
    RealTimeDataApi realTimeDataApi;

    @Test
    public void fetch_apiResponseTransitStopRTIResponse() throws ApiException {
        // given

        // when
        APIResponseTransitStopRTIResponse apiResponseTransitStopRTIResponse = realTimeDataApi.rTIReportGet("0100BRSTLTM0", "2.0", 100, 60);

        // then
        List<TransitStopRTIReport> rtiReports = apiResponseTransitStopRTIResponse.getData().getRtiReports();
        Assert.assertFalse(rtiReports.isEmpty());
    }

    @Test
    public void foo() {

    }
}