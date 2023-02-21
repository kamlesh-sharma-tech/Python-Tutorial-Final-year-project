package com.android.pythontutorial.activities;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface apiset {
    @FormUrlEncoded
    @POST("register.php")
    Call<RegisterResponse> register(
            @Field("name") String name,
            @Field("email") String email,
            @Field("mobile") String mobile,
            @Field("password") String password
    );

    @FormUrlEncoded
    @POST("login.php")
    Call<responsemodel> verifyUser(@Field("email") String email,
                                   @Field("password") String password);

    @GET("fetch.php")
    Call<FetchUserResponse> fetchAllUsers();
}
