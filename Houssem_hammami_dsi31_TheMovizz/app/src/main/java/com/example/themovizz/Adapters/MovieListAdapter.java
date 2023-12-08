package com.example.themovizz.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.themovizz.R;
import com.example.themovizz.Api.models.Movie;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MovieViewHolder> {

    private List<Movie> movies;
    private Context context;

    public MovieListAdapter(Context context, List<Movie> movies) {
        this.context = context;
        this.movies = movies;
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        Movie movie = movies.get(position);

        // Load movie data into views
        holder.movieTitleTextView.setText(movie.getTitle());

        // Load movie poster using an image loading library (e.g., Picasso, Glide)
        // For simplicity, we use a placeholder image here
        String baseUrl = "https://image.tmdb.org/t/p/w500/";
        String posterPath = movie.getPosterPath(); // Assuming this is the image file name
        String fullUrl = baseUrl + posterPath;

        Picasso.get().load(fullUrl)
                .into(holder.moviePosterImageView);
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public static class MovieViewHolder extends RecyclerView.ViewHolder {
        ImageView moviePosterImageView;
        TextView movieTitleTextView;

        public MovieViewHolder(View itemView) {
            super(itemView);
            moviePosterImageView = itemView.findViewById(R.id.moviePosterImageView);
            movieTitleTextView = itemView.findViewById(R.id.movieTitleTextView);
        }
    }
}

