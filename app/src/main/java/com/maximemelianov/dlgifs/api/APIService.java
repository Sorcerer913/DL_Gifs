package com.maximemelianov.dlgifs.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIService {
    @GET(APIConfig.RANDOM)
    Call<ResponseData> getRandomPost(@Query(APIConfig.JSON) String jsonEnabled);
}
