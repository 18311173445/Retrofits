package com.bawei.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.bawei.retrofit.adapter.ShowAdapter;
import com.bawei.retrofit.api.Api;
import com.bawei.retrofit.api.UserApiService;
import com.bawei.retrofit.bean.Show;
import com.bawei.retrofit.bean.Shows;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView main_recycle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        main_recycle = findViewById(R.id.main_recycle);
        try {
            show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void show() throws IOException {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        UserApiService userApiService = retrofit.create(UserApiService.class);
        Call<Show> show = userApiService.Show();

        show.enqueue(new Callback<Show>() {
            @Override
            public void onResponse(Call<Show> call, Response<Show> response) {
                Show body = response.body();
                ShowAdapter adapter = new ShowAdapter(body, MainActivity.this);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
                linearLayoutManager.setOrientation(OrientationHelper.VERTICAL);
                main_recycle.setLayoutManager(linearLayoutManager);
                main_recycle.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<Show> call, Throwable t) {

            }
        });
    }
}
