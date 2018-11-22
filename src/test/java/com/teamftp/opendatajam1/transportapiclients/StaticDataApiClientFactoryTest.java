package com.teamftp.opendatajam1.transportapiclients;

import io.swagger.client.ApiException;
import io.swagger.client.api.StaticDataApi;
import io.swagger.client.model.APIResponsePlacePointList;
import io.swagger.client.model.PlacePoint;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StaticDataApiClientFactoryTest {
    @Autowired
    StaticDataApi staticDataApi;

    @Test
    public void fetches_placesList() throws ApiException {
        // given

        // when
        APIResponsePlacePointList queryResult = staticDataApi.placesList("Preston", "2.0", "foo", 1d, 1d, "UK", 100);

        // then
        List<PlacePoint> placePointList = queryResult.getData().getPlacePoints();
        Assert.assertFalse(placePointList.isEmpty());
    }
}