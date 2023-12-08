package com.example.themovizz.Api.Clients;

import com.example.themovizz.Api.MovieApiService;
import com.example.themovizz.Api.Responces.MovieResponse;
import com.example.themovizz.Api.models.SingleMovie;

import retrofit2.Call;
import retrofit2.Callback;

public class MovieApiClient {
    private MovieApiService movieApiService;
    private String authToken = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIxZmZmMTk1ZWYzZGMzMDM4NzE1M2UwOGU0Yjk0NzI4NCIsInN1YiI6IjY1NWZjM2M0ODNlZTY3MDFmNWY2NTNhMyIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.zLc0V7Xy5x_Ert0LRY2HVssDsTFKvH53jl1yyPh8JqU";

    public MovieApiClient() {
        movieApiService = RetrofitClient.getMovieApiService(authToken);
    }

    public MovieApiClient instance() {
        return new MovieApiClient();
    }

    public void getMovies(Callback<MovieResponse> callback) {
        Call<MovieResponse> call = movieApiService.getMovies(false, false, "en-US", 1, "popularity.desc");
        call.enqueue(callback);
    }

    public void getMovieDetails(int movieId, Callback<SingleMovie> callback) {
        Call<SingleMovie> call = movieApiService.getMovieDetails(movieId, "videos", "en-US");
        call.enqueue(callback);
    }
}
