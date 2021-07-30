package com.myfirst.fragmentgithubrecyclerview;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {
    @GET("users/{user}/repos")
    Call<List<ResponseGitHub>> callApi(@Path("user") String user);
}
