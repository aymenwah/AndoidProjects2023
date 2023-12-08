package com.example.themovizz.Utils;

import com.example.themovizz.Api.models.Movie;

import java.util.List;


public interface MovieListResultCallback {
    void onMoviesReceived(List<Movie> movies);
    void onError(String errorMessage);
}

