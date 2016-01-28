package com.example.marlen.project_jedi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class activity_provesIntent2 extends AppCompatActivity {

    TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proves_intent2);
        textResult = (TextView)findViewById(R.id.textResultat);
        Bundle bundle = getIntent().getExtras();
        String result = bundle.getString("textIni");
        textResult.setText(result);
    }
}
