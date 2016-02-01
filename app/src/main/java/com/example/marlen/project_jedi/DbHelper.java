package com.example.marlen.project_jedi;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DbHelper extends SQLiteOpenHelper {

   /* @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db_helper);
    }*/

    public static String CN_NAME = "userName";

    public static String CN_PASS = "password";

    public static String CN_POINTS = "points";

    //Declaracion del nombre de la base de datos
    public static final int DATABASE_VERSION = 1;

    //Declaracion global de la version de la base de datos
    public static final String DATABASE_NAME = "user.sqlite";

    //Declaracion del nombre de la tabla
    public static final String USER_TABLE ="User";

    //sentencia global de creacion de la base de datos
    public static final String USER_TABLE_CREATE = "CREATE TABLE " + USER_TABLE + " ("
            + CN_NAME + " TEXT PRIMARY KEY UNIQUE,"
            + CN_PASS + " TEXT,"
            + CN_POINTS + " INTEGER);";

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(USER_TABLE_CREATE);
    }

    //obtener una lista de users
    public Cursor getAllUsers() {
        SQLiteDatabase db = this.getWritableDatabase();
        String[] columns = {"name"};
        Cursor c = db.query(
                USER_TABLE,  // The table to query
                columns,                                // The columns to return
                null,                                   // The columns for the WHERE clause
                null,                                   // The values for the WHERE clause
                null,                                   // don't group the rows
                null,                                   // don't filter by row groups
                null                                    // The sort order
        );
        return c;
    }

    public Cursor getUser(String userName) {
        SQLiteDatabase db = this.getWritableDatabase();
        String[] columns = {CN_NAME,CN_PASS};
        String[] where = {userName};
        Cursor c = db.query(
                USER_TABLE,  // The table to query
                columns,                                    // The columns to return
                "userName=?",                                   // The columns for the WHERE clause
                where,                                      // The values for the WHERE clause
                null,                                       // don't group the rows
                null,                                       // don't filter by row groups
                null                                        // The sort order
        );
        return c;
    }

    public void createUser (ContentValues values, String tableName) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(
                tableName,
                null,
                values);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
