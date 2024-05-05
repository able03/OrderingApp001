package com.example.orderingapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper
{

    private Context context;
    private static final String DB_NAME = "Order.db";
    private static final int DB_VER = 1;

    private static final String TABLE_ACCOUNTS = "accounts",
                                COLUMN_ID = "id",
                                COLUMN_NAME = "name",
                                COLUMN_ADDRESS = "address",
                                COLUMN_EMAIL = "email",
                                COLUMN_BIRTHDATE = "birthdate",
                                COLUMN_PHONE = "phone",
                                COLUMN_USERNAME = "username",
                                COLUMN_PASSWORD  = "password",
                                COLUMN_PIN = "pin",
                                COLUMN_USER_TYPE = "user_type";

    private static final String CREATE_TABLE_ACCOUNTS = "CREATE TABLE "+TABLE_ACCOUNTS+"(" +
            COLUMN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT," +
            COLUMN_NAME+" VARCHAR," +
            COLUMN_ADDRESS+" VARCHAR," +
            COLUMN_EMAIL+" VARCHAR," +
            COLUMN_BIRTHDATE+" VARCHAR," +
            COLUMN_PHONE+" VARCHAR," +
            COLUMN_USERNAME+" VARCHAR," +
            COLUMN_PASSWORD+" VARCHAR," +
            COLUMN_PIN+" VARCHAR UNIQUE)";

    private static final String DROP_TABLE_ACCOUNTS = "DROP TABLE IF EXISTS "+TABLE_ACCOUNTS;

    public DBHelper(@Nullable Context context)
    {
        super(context, DB_NAME, null, DB_VER);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(CREATE_TABLE_ACCOUNTS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL(DROP_TABLE_ACCOUNTS);
    }


    public boolean addAccount(String name, String address, String email, String birthdate,
                              String phone, String username, String password, String pin)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values =  new ContentValues();
        values.put(COLUMN_NAME, name);
        values.put(COLUMN_ADDRESS, address);
        values.put(COLUMN_EMAIL, email);
        values.put(COLUMN_BIRTHDATE, birthdate);
        values.put(COLUMN_PHONE, phone);
        values.put(COLUMN_USERNAME, username);
        values.put(COLUMN_PASSWORD, password);
        values.put(COLUMN_PIN, pin);;


        long rowsAffected = db.insert(TABLE_ACCOUNTS, null, values);

        if(rowsAffected != -1)
        {
            return true;
        }
        return false;
    }

    public Cursor findAccount(String username, String password)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM "+TABLE_ACCOUNTS+" WHERE "+COLUMN_USERNAME+ " = '"+username+"' AND "+COLUMN_PASSWORD+ " = '"+password+"'", null);
    }

    public Cursor findAccount(String pin)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM "+TABLE_ACCOUNTS+ " WHERE "+COLUMN_PIN+ " = '"+pin+"'", null);
    }




}
