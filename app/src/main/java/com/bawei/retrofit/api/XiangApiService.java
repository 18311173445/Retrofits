package com.bawei.retrofit.api;

import com.bawei.retrofit.bean.Xiang;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface XiangApiService {

    @GET("small/commodity/v1/findCommodityDetailsById")
    Call<Xiang> xiang(@Query("commodityId") String commodityId);
}
