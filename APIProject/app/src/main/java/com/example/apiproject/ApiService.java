package com.example.apiproject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("v2/currencies")
    Call<CurrencyResponse> getCurrencies();
}

