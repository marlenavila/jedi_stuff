package com.example.marlen.project_jedi;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TV extends AppCompatActivity implements View.OnClickListener {

    TextView resultat;
    Button bt0, bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9, btsum, btrest, btmult, btdiv;
    Button btdec, btig;
    String s, op;
    Double num1, num2, res;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.settings, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menusettings:
                Intent intent = new Intent(getApplicationContext(), Activity2.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tv);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        resultat = (TextView)findViewById(R.id.result);
        bt0 = (Button) findViewById(R.id.b_0);
        bt1 = (Button) findViewById(R.id.b_1);
        bt2 = (Button) findViewById(R.id.b_2);
        bt3 = (Button) findViewById(R.id.b_3);
        bt4 = (Button) findViewById(R.id.b_4);
        bt5 = (Button) findViewById(R.id.b_5);
        bt6 = (Button) findViewById(R.id.b_6);
        bt7 = (Button) findViewById(R.id.b_7);
        bt8 = (Button) findViewById(R.id.b_8);
        bt9 = (Button) findViewById(R.id.b_9);
        btsum = (Button) findViewById(R.id.b_sum);
        btrest = (Button) findViewById(R.id.b_rest);
        btmult = (Button) findViewById(R.id.b_mult);
        btdiv = (Button) findViewById(R.id.b_div);
        btdec = (Button) findViewById(R.id.b_dec);
        btig = (Button) findViewById(R.id.b_igual);

       /* View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setBackgroundColor(Color.BLUE);
            }
        };
        boton.setOnClickListener(listener);*/
        //Amb implement:
        bt0.setOnClickListener(this);
        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);
        bt4.setOnClickListener(this);
        bt5.setOnClickListener(this);
        bt6.setOnClickListener(this);
        bt7.setOnClickListener(this);
        bt8.setOnClickListener(this);
        bt9.setOnClickListener(this);
        btsum.setOnClickListener(this);
        btrest.setOnClickListener(this);
        btmult.setOnClickListener(this);
        btdiv.setOnClickListener(this);
        btdec.setOnClickListener(this);
        btig.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        s = (String)resultat.getText();
        switch (v.getId()){
            case R.id.b_0:
                s += "0";
                resultat.setText(s);
                break;
            case R.id.b_1:
                s += "1";
                resultat.setText(s);
                break;
            case R.id.b_2:
                s += "2";
                resultat.setText(s);
                break;
            case R.id.b_3:
                s += "3";
                resultat.setText(s);
                break;
            case R.id.b_4:
                s += "4";
                resultat.setText(s);
                break;
            case R.id.b_5:
                s += "5";
                resultat.setText(s);
                break;
            case R.id.b_6:
                s += "6";
                resultat.setText(s);
                break;
            case R.id.b_7:
                s += "7";
                resultat.setText(s);
                break;
            case R.id.b_8:
                s += "8";
                resultat.setText(s);
                break;
            case R.id.b_9:
                s += "9";
                resultat.setText(s);
                break;
            case R.id.b_sum:
                op = "+";
                num1 = Double.parseDouble((String)resultat.getText());
                s += "+";
                resultat.setText(s);
                break;
            case R.id.b_rest:
                op = "-";
                num1 = Double.parseDouble((String)resultat.getText());
                s += "-";
                resultat.setText(s);
                break;
            case R.id.b_mult:
                op = "x";
                num1 = Double.parseDouble((String)resultat.getText());
                s += "x";
                resultat.setText(s);
                break;
            case R.id.b_div:
                op = "/";
                num1 = Double.parseDouble((String)resultat.getText());
                s += "/";
                resultat.setText(s);
                break;
            case R.id.b_dec:
                s += ".";
                resultat.setText(s);
                break;
            case R.id.b_igual:
                s += "=";
                num2 = Double.parseDouble((String)resultat.getText());
                if(op.equals("+")){
                    res = num1+num2;
                }
                else if(op.equals("-")){
                    res = num1-num2;
                }
                else if(op.equals("x")){
                    res = num1*num2;
                }
                else{
                    res = num1/num2;
                }
                resultat.setText(s);
                break;

        }
    }
}
