package com.wilson.retrofit_analysis;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    private Button btnGet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnGet = (Button) findViewById(R.id.btn_get);
        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("https://api.github.com/") // 设置网络请求的公共Url地址
                        .addConverterFactory(GsonConverterFactory.create()) // 设置数据解析器
                        .addCallAdapterFactory(RxJavaCallAdapterFactory.create()) // 支持RxJava平台
                        .build();
                GitHubService getRequestInterface = retrofit.create(GitHubService.class);


                Call<List<Repo>> microKibaco = getRequestInterface.listRepos("MicroKibaco");
                microKibaco.enqueue(new Callback<List<Repo>>() {
                    @Override
                    public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {

                        Log.d(LOG_TAG,call.toString());
                    }

                    @Override
                    public void onFailure(Call<List<Repo>> call, Throwable t) {

                    }
                });


            }
        });

    }

}
