package com.example.themovizz.Api.Services;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.themovizz.Api.Clients.MovieApiClient;
import com.example.themovizz.Api.Responces.MovieResponse;
import com.example.themovizz.Api.models.Movie;
import com.example.themovizz.Api.models.SingleMovie;
import com.example.themovizz.Utils.MovieDetailsResultCallback;
import com.example.themovizz.Utils.MovieListResultCallback;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MoviesService {
    private MovieApiClient movieApiClient;


    public MoviesService() {
        movieApiClient = new MovieApiClient();
    }

    public void getSingleMovieResults(int movieId, MovieDetailsResultCallback callback)  {
            movieApiClient.getMovieDetails(movieId, new Callback<SingleMovie>() {
                @Override
                public void onResponse(Call<SingleMovie> call, Response<SingleMovie> response) {
                    // Handle the response
                    if (response.isSuccessful()) {
                        SingleMovie movieDetailsResponse = response.body();
                        if (movieDetailsResponse != null) {
                            // Handle the successful response
                            // Log the response details

                            callback.onMovieDetailsReceived(movieDetailsResponse);
                            Log.d("MovieDetailsTitleName", movieDetailsResponse.getVideos().getResults().get(0).getKey());

                        }
                    } else {
                        // Log error details
                        String errorBody = response.errorBody() != null ? response.errorBody().toString() : "Unknown error";
                        callback.onError("Error: " + response.code() + ", " + errorBody);
                    }
                }

                @Override
                public void onFailure(Call<SingleMovie> call, Throwable t) {
                    // Handle the failure
                }
            });
    }


    public void getMoviesResults(MovieListResultCallback callback) {

            movieApiClient.getMovies(new Callback<MovieResponse>() {
                @Override
                public void onResponse(@NonNull Call<MovieResponse> call, @NonNull Response<MovieResponse> response) {
                    if (response.isSuccessful()) {
                        MovieResponse movieResponse = response.body();
                        if (movieResponse != null) {
                            // Handle the successful response
                            // Log the response details
                            List<Movie> movies = movieResponse.getResults();
                            callback.onMoviesReceived(movies);
                        }
                    } else {
                        // Log error details
                        String errorBody = response.errorBody() != null ? response.errorBody().toString() : "Unknown error";
                        callback.onError("Error: " + response.code() + ", " + errorBody);
                    }
                }

                @Override
                public void onFailure(Call<MovieResponse> call, Throwable t) {
                    // Log failure details
                    callback.onError("Failure: " + t.getMessage());
                }
            });
    }
}

