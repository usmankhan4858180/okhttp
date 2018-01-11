package com.example.okhttp;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
/**
 * Created by DEll1 on 1/12/2018.
 */

public class MainActivity extends AppCompatActivity {

    String str ="Failed";
    TextView tv;
    private static final String TAG =MainActivity.class.getName();


    @Subscribe(threadMode = ThreadMode.POSTING)
    void test(CustomEvent customEvent) {

        System.out.println("Failed");
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EventBus.getDefault().register(this);

        Button button = (Button) findViewById(R.id.btn);
        TextView tv = (TextView) findViewById(R.id.tv);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                OkHttpClient client = new OkHttpClient();
                Request req = new Request.Builder()
                        .get()
                        .url("http://xkq4g.mocklab.io/booksharingapp")
                        .build();

                client.newCall(req).enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        EventBus.getDefault().post(new CustomEvent());
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {

                        Log.i(TAG,response.body().string());


                    }
                });
            }
        });


    }
}
