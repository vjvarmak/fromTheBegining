package com.App.Network.API;

import com.App.Home.TabLayout.Membership.MembershipData;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MembershipAPI {

    @GET("posts")
    Call<List<MembershipData>> getMembershipAPI();
}
