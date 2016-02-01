package com.example.marlen.project_jedi;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class activityLogin extends AppCompatActivity implements View.OnClickListener {

    Button btLogin, btNewUser;
    EditText user, password;
    DbHelper baseDades;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        user = (EditText) findViewById(R.id.addUser);
        password = (EditText) findViewById(R.id.addPassword);

        btLogin = (Button) findViewById(R.id.bt_login);
        btNewUser = (Button) findViewById(R.id.bt_newUser);

        btLogin.setOnClickListener(this);
        btNewUser.setOnClickListener(this);
        baseDades = new DbHelper(this);
    }

    public void addUser (View v){
        ContentValues values = new ContentValues();
        values.put(baseDades.CN_NAME,String.valueOf(user.getText()));
        values.put(baseDades.CN_PASS,String.valueOf(password.getText()));

        Cursor c = baseDades.getUser(user.getText().toString());
        if(c.moveToFirst())
            Toast.makeText(getApplicationContext(),"user already exists",Toast.LENGTH_SHORT).show();
        else{
            baseDades.createUser(values,"User");
            Toast.makeText(getApplicationContext(),"insertion done",Toast.LENGTH_SHORT).show();
            user.setText("");
            password.setText("");
        }
    }

    public void login (View v){
        /*ContentValues values = new ContentValues();
        values.put("userName",String.valueOf(user.getText()));
        values.put("pass",String.valueOf(password.getText()));*/ //Futur bundle per passar-li l'activity del profile amb la info

        Cursor c = baseDades.getUser(user.getText().toString());
        if(!c.moveToFirst())
            Toast.makeText(getApplicationContext(),"user not exists",Toast.LENGTH_SHORT).show();
        else{
            if(!password.getText().toString().equals(c.getString(c.getColumnIndex(baseDades.CN_PASS))))
                Toast.makeText(getApplicationContext(),"incorrect password",Toast.LENGTH_SHORT).show();
            else{ //entrar a l'activity del profile
                Intent intent = new Intent(getApplicationContext(),activity_provesIntent1.class);
                startActivity(intent);
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_login:
               login(v);
                break;
            case R.id.bt_newUser:
               addUser(v);
                break;
        }

    }
}
