package com.example.themovizz.Api;

import com.example.themovizz.Api.Responces.MovieResponse;
import com.example.themovizz.Api.models.SingleMovie;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MovieApiService {
    @GET("discover/movie")
    Call<MovieResponse> getMovies(
            @Query("include_adult") boolean includeAdult,
            @Query("include_video") boolean includeVideo,
            @Query("language") String language,
            @Query("page") int page,
            @Query("sort_by") String sortBy
    );

    @GET("movie/{id}")
    Call<SingleMovie> getMovieDetails(
            @Path("id") int movieId,
            @Query("append_to_response") String appendToResponse,
            @Query("language") String language
    );
}
