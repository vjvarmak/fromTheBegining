package com.App.Network.API;

import com.App.Home.TabLayout.Account.AccountData;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface AccountAPI {

    @GET("posts")
    Call<List<AccountData>> getAccountAPI();

    @POST("posts")
    Call<AccountData> createPost(@Body String xyz);
}

