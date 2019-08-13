package com.intkhabahmed.githubquery.network;

import com.intkhabahmed.githubquery.Result;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WebService {
    @GET("search/repositories")
    Call<String> getRepositories(@Query("q") String query, @Query("sort") String sortBy);
}
