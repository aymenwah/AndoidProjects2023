package com.example.apiproject;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ListView listView;

    List<Currency> Data = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bt=findViewById(R.id.bt);


        listView = findViewById(R.id.listView);
        ArrayAdapter<Currency> adapter = new ArrayAdapter<>(MainActivity.this,
                android.R.layout.simple_list_item_1, Data);
        listView.setAdapter(adapter);

        ApiService apiService = RetrofitClient.getRetrofitInstance().create(ApiService.class);
        Call<CurrencyResponse> call = apiService.getCurrencies();

  bt.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
          call.enqueue(new Callback<CurrencyResponse>() {
              @Override
              public void onResponse(Call<CurrencyResponse> call, Response<CurrencyResponse> response) {
                  if (response.isSuccessful()) {
                      CurrencyResponse currencyresponse = response.body();
                      for(Currency c : currencyresponse.getCurrencies())
                      {
                          Data.add(c);

                      }

                      adapter.notifyDataSetChanged();



                  } else {
                      // Handle the error
                      Log.e("API Error", "Error: " + response.code());
                  }
              }

              @Override
              public void onFailure(Call<CurrencyResponse> call, Throwable t) {
                  // Handle the failure
                  Log.e("API Failure", "Error: " + t.getMessage());
              }
          });
      }
  });
    }
}
