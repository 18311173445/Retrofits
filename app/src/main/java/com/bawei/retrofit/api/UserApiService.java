package com.bawei.retrofit.api;

import com.bawei.retrofit.bean.Show;
import com.bawei.retrofit.bean.Shows;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface UserApiService {
    @GET ("small/commodity/v1/commodityList")
    Call<Show> Show();
}
