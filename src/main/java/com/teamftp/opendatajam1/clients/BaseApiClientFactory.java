package com.teamftp.opendatajam1.clients;

import com.google.common.base.Strings;
import com.teamftp.opendatajam1.AppConfiguration;
import io.swagger.client.ApiClient;
import lombok.SneakyThrows;

import java.lang.reflect.Method;

public class BaseApiClientFactory<T> {
    private T dataApi;

    @SneakyThrows
    protected BaseApiClientFactory(AppConfiguration appConfiguration, Class<T> clazz) {
        String apiKey = appConfiguration.getApiKey();

        if (Strings.isNullOrEmpty(apiKey)) throw new Exception("Provide the api key in application.properties");

        dataApi = createDataApi(apiKey, clazz);
    }

    public T getInstance() {
        return dataApi;
    }

    @SneakyThrows
    private T createDataApi(String apiKey, Class<T> clazz) {
        ApiClient apiClient = new ApiClient();
        apiClient.addDefaultHeader("X-Api-Key", apiKey);

        T dataApi = clazz.newInstance();
        Method method = clazz.getDeclaredMethod("setApiClient", apiClient.getClass());
        method.invoke(dataApi, apiClient);

        return dataApi;
    }
}
