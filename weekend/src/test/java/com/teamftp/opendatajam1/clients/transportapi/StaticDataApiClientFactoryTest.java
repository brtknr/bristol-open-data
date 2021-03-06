package com.teamftp.opendatajam1.clients.transportapi;

import com.teamftp.opendatajam1.AppConfiguration;
import io.swagger.client.ApiException;
import io.swagger.client.api.StaticDataApi;
import io.swagger.client.model.APIResponsePlacePointList;
import io.swagger.client.model.PlacePoint;
import io.swagger.client.model.PlacePointList;
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

    @Autowired
    AppConfiguration appConfiguration;

    @Test
    public void fetches_placesList() throws ApiException {
        // given

        // when
        APIResponsePlacePointList queryResult = staticDataApi.placesList("Preston", "2.0", "foo", 1d, 1d, "UK", 100);

        // then
        List<PlacePoint> placePointList = queryResult.getData().getPlacePoints();
        Assert.assertFalse(placePointList.isEmpty());
    }

    @Test
    public void nulls_for_optional_parameters() throws ApiException {
        // given

        // when
        APIResponsePlacePointList passage = staticDataApi.placesList("Passage", "2.0", null, appConfiguration.getBristolLatitude(), appConfiguration.getBristolLongitude(), null, null);

        // then
        PlacePointList data = passage.getData();
        Assert.assertEquals(9, data.getPlacePoints().size());
    }

    public void methods() {
//        staticDataApi.agenciesGet();
//        staticDataApi.importSourcesGet();
//        staticDataApi.placePointsGet();
//        staticDataApi.placesList();
//        staticDataApi.routesInfoCallingAtStop();
//        staticDataApi.routesInfoLineName();
//        staticDataApi.routesInfoSource();
//        staticDataApi.stopCallsGet();
//        staticDataApi.stopsGet();
//        staticDataApi.tripGroupsByCalendar();
//        staticDataApi.tripsGet();
    }
}