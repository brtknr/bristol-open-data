package com.teamftp.opendatajam1.clients.highwaysapi;

import io.swagger.client.ApiException;
import io.swagger.client.api.HighwaysDataApi;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Ignore("the endpoint is not working")
@RunWith(SpringRunner.class)
@SpringBootTest
public class HighwaysDataApiClientFactoryTest {
    @Autowired
    HighwaysDataApi highwaysDataApi;

    @Test
    public void foo() throws ApiException {
        // given

        // when
        Object vms = highwaysDataApi.dynamicDatexIIStatus("vms");

        // then
        int foo = 1 + 1;

    }
}