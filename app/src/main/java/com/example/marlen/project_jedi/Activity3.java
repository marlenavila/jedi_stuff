package com.example.marlen.project_jedi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class Activity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.v("I'm here", "start");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v("I'm here", "resume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v("I'm here", "resume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v("I'm here", "stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v("I'm here", "destroy");
    }
}
