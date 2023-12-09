package com.example.themovizz.Utils;

import com.example.themovizz.Api.models.SingleMovie;

public interface MovieDetailsResultCallback {
    void onMovieDetailsReceived(SingleMovie movie);

    void onError(String errorMessage);
}
