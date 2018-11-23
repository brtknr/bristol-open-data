package com.teamftp.opendatajam1.clients.highwaysapi;

import io.swagger.client.ApiException;
import io.swagger.client.api.DisruptionsApi;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Ignore("the endpoint is not working")
@RunWith(SpringRunner.class)
@SpringBootTest
public class DisruptionsApiFactoryTest {
    @Autowired
    DisruptionsApi disruptionsApi;

    @Test
    public void foo() throws ApiException {
        // given

        // when
        Object o = disruptionsApi.disruptionsDatexIIAccidents();

        // then
    }
}