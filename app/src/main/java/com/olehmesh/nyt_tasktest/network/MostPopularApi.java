package com.olehmesh.nyt_tasktest.network;

import com.olehmesh.nyt_tasktest.models.RequestAll;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MostPopularApi {
    @GET("{type}/all-sections/30.json?api-key=0edb5ad3ba1442ecabf3b0cc72e2921e")
    Single<RequestAll> getData(@Path("type") String type);

}