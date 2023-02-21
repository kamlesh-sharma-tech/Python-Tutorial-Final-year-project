package com.android.pythontutorial.activities;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FetchUserResponse {
    @SerializedName("users")
    List<User> userList;

    public FetchUserResponse(List<User> userList) {
        this.userList = userList;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
