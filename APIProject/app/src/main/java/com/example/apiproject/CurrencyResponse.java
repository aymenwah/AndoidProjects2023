package com.example.apiproject;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class CurrencyResponse {
    @SerializedName("data")
    private List<Currency> currencies;

    public List<Currency> getCurrencies() {
        return currencies;
    }


}
