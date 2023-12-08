package com.example.themovizz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.themovizz.Adapters.MovieListAdapter;
import com.example.themovizz.Api.Services.MoviesService;
import com.example.themovizz.Utils.MovieDetailsResultCallback;
import com.example.themovizz.Utils.MovieListResultCallback;
import com.example.themovizz.Api.models.Movie;
import com.example.themovizz.Api.models.SingleMovie;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MovieListAdapter movieAdapter;
    private MoviesService movies_service;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        movies_service = new MoviesService();
        // get movies list
        movies_service.getMoviesResults(new MovieListResultCallback() {
            @Override
            public void onMoviesReceived(List<Movie> movies) {
                // Handle the received movies
                initMoviesList(movies);
            }

            @Override
            public void onError(String errorMessage) {
                // Handle the error
                Log.e("MovieApiClient", errorMessage);
            }
        });

        // get movie by id
        int movieId = 343611; // Replace with the actual movie ID
        movies_service.getSingleMovieResults(movieId, new MovieDetailsResultCallback() {
            @Override
            public void onMovieDetailsReceived(SingleMovie movie) {

            }

            @Override
            public void onError(String errorMessage) {
                // Handle the error
                Log.e("MovieApiClient", errorMessage);
            }
        });
    }



    public void initMoviesList(List<Movie> movies) {
        recyclerView = findViewById(R.id.recyclerView);
        movieAdapter = new MovieListAdapter(MainActivity.this, movies);
        recyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this, 3));
        recyclerView.setAdapter(movieAdapter);
    }

}