package com.example.marlen.project_jedi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v("log_tag","tag_verbose");
        Log.d("log_tag","tag_debug");
        Log.e("log_tag","tag_error");
        Log.wtf("log_tag","tag_wtf");
        Log.i("log_tag","tag_information");
        Log.w("log_tag","tag_warning");
    }
}
