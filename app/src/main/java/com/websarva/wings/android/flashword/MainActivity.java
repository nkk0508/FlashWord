package com.websarva.wings.android.flashword;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

/**
 * Created by keita0508 on 2018/12/01.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onStartButtonClick(View v) {
        Intent intent = new Intent(this, FlashActivity.class);
        startActivity(intent);
    }
}