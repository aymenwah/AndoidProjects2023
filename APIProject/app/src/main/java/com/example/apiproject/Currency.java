package com.example.apiproject;

import com.google.gson.annotations.SerializedName;

public class Currency {
    @SerializedName("id")
    private String id;

    @SerializedName("name")
    private String name;

    @SerializedName("min_size")
    private String minSize;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getMinSize() {
        return minSize;
    }

    @Override
    public String toString() {
        return "   Currency" +

                ", name=" + name + '\'' +
                id;
    }
}
