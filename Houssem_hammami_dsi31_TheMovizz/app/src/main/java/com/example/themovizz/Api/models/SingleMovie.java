package com.example.themovizz.Api.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SingleMovie {

    @SerializedName("adult")
    private boolean adult;

    @SerializedName("backdrop_path")
    private String backdropPath;

    @SerializedName("belongs_to_collection")
    private BelongsToCollection belongsToCollection;

    @SerializedName("budget")
    private int budget;

    @SerializedName("genres")
    private List<Genre> genres;

    @SerializedName("homepage")
    private String homepage;

    @SerializedName("id")
    private int id;

    @SerializedName("imdb_id")
    private String imdbId;

    @SerializedName("original_language")
    private String originalLanguage;

    @SerializedName("original_title")
    private String originalTitle;

    @SerializedName("overview")
    private String overview;

    @SerializedName("popularity")
    private double popularity;

    @SerializedName("poster_path")
    private String posterPath;

    @SerializedName("production_companies")
    private List<ProductionCompany> productionCompanies;

    @SerializedName("production_countries")
    private List<ProductionCountry> productionCountries;

    @SerializedName("release_date")
    private String releaseDate;

    @SerializedName("revenue")
    private long revenue;

    @SerializedName("runtime")
    private int runtime;

    @SerializedName("spoken_languages")
    private List<SpokenLanguage> spokenLanguages;

    @SerializedName("status")
    private String status;

    @SerializedName("tagline")
    private String tagline;

    @SerializedName("title")
    private String title;

    @SerializedName("video")
    private boolean video;

    @SerializedName("vote_average")
    private double voteAverage;

    @SerializedName("vote_count")
    private int voteCount;

    @SerializedName("videos")
    private Videos videos;

    public boolean isAdult() {
        return adult;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public BelongsToCollection getBelongsToCollection() {
        return belongsToCollection;
    }

    public int getBudget() {
        return budget;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public String getHomepage() {
        return homepage;
    }

    public int getId() {
        return id;
    }

    public String getImdbId() {
        return imdbId;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public String getOverview() {
        return overview;
    }

    public double getPopularity() {
        return popularity;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public List<ProductionCompany> getProductionCompanies() {
        return productionCompanies;
    }

    public List<ProductionCountry> getProductionCountries() {
        return productionCountries;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public long getRevenue() {
        return revenue;
    }

    public int getRuntime() {
        return runtime;
    }

    public List<SpokenLanguage> getSpokenLanguages() {
        return spokenLanguages;
    }

    public String getStatus() {
        return status;
    }

    public String getTagline() {
        return tagline;
    }

    public String getTitle() {
        return title;
    }

    public boolean isVideo() {
        return video;
    }

    public double getVoteAverage() {
        return voteAverage;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public Videos getVideos() {
        return videos;
    }

    // Inner classes for nested structures

    public static class BelongsToCollection {
        @SerializedName("id")
        private int id;

        @SerializedName("name")
        private String name;

        @SerializedName("poster_path")
        private String posterPath;

        @SerializedName("backdrop_path")
        private String backdropPath;

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getPosterPath() {
            return posterPath;
        }

        public String getBackdropPath() {
            return backdropPath;
        }
    }

    public static class Genre {
        @SerializedName("id")
        private int id;

        @SerializedName("name")
        private String name;

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }

    public static class ProductionCompany {
        @SerializedName("id")
        private int id;

        @SerializedName("logo_path")
        private String logoPath;

        @SerializedName("name")
        private String name;

        @SerializedName("origin_country")
        private String originCountry;

        public int getId() {
            return id;
        }

        public String getLogoPath() {
            return logoPath;
        }

        public String getName() {
            return name;
        }

        public String getOriginCountry() {
            return originCountry;
        }
    }

    public class ProductionCountry {

        @SerializedName("iso_3166_1")
        private String iso31661;

        @SerializedName("name")
        private String name;

        public String getIso31661() {
            return iso31661;
        }

        public String getName() {
            return name;
        }
    }

    public class SpokenLanguage {

        @SerializedName("english_name")
        private String englishName;

        @SerializedName("iso_639_1")
        private String iso6391;

        @SerializedName("name")
        private String name;

        public String getEnglishName() {
            return englishName;
        }

        public String getIso6391() {
            return iso6391;
        }

        public String getName() {
            return name;
        }
    }

    public class Videos {

        @SerializedName("results")
        private List<VideoResult> results;

        public List<VideoResult> getResults() {
            return results;
        }
    }

    public class VideoResult {

        @SerializedName("iso_639_1")
        private String iso639_1;

        @SerializedName("iso_3166_1")
        private String iso3166_1;

        private String name;
        private String key;

        @SerializedName("published_at")
        private String publishedAt;

        private String site;
        private int size;
        private String type;

        @SerializedName("official")
        private boolean isOfficial;

        private String id;

        public String getIso639_1() {
            return iso639_1;
        }

        public String getIso3166_1() {
            return iso3166_1;
        }

        public String getName() {
            return name;
        }

        public String getKey() {
            return key;
        }

        public String getPublishedAt() {
            return publishedAt;
        }

        public String getSite() {
            return site;
        }

        public int getSize() {
            return size;
        }

        public String getType() {
            return type;
        }

        public boolean isOfficial() {
            return isOfficial;
        }

        public String getId() {
            return id;
        }
    }

}

