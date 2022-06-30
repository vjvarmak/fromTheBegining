package com.App.Home.TabLayout.Account;

import com.google.gson.annotations.SerializedName;

public class AccountData {
    @SerializedName("userId")
    String userId;
    @SerializedName("id")
    String Id;
    @SerializedName("title")
    String title;
    @SerializedName("body")
    String body;

    public AccountData(String userId, String id, String title, String body) {
        this.userId = userId;
        Id = id;
        this.title = title;
        this.body = body;
    }


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }



}
