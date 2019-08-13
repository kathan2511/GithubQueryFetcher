package com.intkhabahmed.githubquery;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.intkhabahmed.githubquery.network.ApiClient;
import com.intkhabahmed.githubquery.network.WebService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private EditText searchBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        searchBox = findViewById(R.id.search_box);

        final ProgressBar progressBar = findViewById(R.id.progress_bar);

        Button searchBtn = findViewById(R.id.search_btn);
        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                String query = searchBox.getText().toString();
                if (TextUtils.isEmpty(query)) {
                    Toast.makeText(MainActivity.this, "Enter the query", Toast.LENGTH_LONG).show();
                } else {
                    ApiClient.getClient().create(WebService.class)
                            .getRepositories(query, Constants.sortBy).enqueue(new Callback<String>() {
                        @Override
                        public void onResponse(@NonNull Call<String> call, @NonNull Response<String> response) {
                            //String result = response.body();
                            progressBar.setVisibility(View.INVISIBLE);
                            Gson gson = new Gson();
                            Result result = gson.fromJson(response.body(), new TypeToken<Result>(){}.getType());
                            ResultFragment fragment = new ResultFragment();
                            Bundle bundle = new Bundle();
                            bundle.putString("result", result.toString());
                            bundle.putString("url", response.raw().request().url().toString());
                            fragment.setArguments(bundle);
                            getSupportFragmentManager().beginTransaction()
                                    .replace(R.id.result_fragment, fragment)
                                    .commit();
                        }

                        @Override
                        public void onFailure(@NonNull Call<String> call, @NonNull Throwable t) {
                            Log.v("Failed", t.getMessage());
                        }
                    });
                }
            }
        });
    }
}
