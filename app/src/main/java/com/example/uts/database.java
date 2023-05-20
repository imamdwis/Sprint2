package com.example.uts;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class database extends SQLiteOpenHelper{
    public Database(@Nullable Context context, @Nullable String nama, @Nullable SQLiteDatabase.CursorFactory factory, int version){
        super(context,nama,factory, version);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase){
        String qry1 = "create table users (user name text,email text,password text)";
        sqLiteDatabase.execSQL(qry1);

    }
    @Override
    public void onUPgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public void register(String username,String email,String Password){
        ContentValues  cv =new ContentValues();
        cv.put("Username ", username);
        cv.put("emiil", email);
        cv.put("Password",Password);
        SQLiteDatabase db = getWritableDatabase();
        db.insert("User",null,cv);
        db.close();

    }
    public int Login(String username,String password){
        int resurt=0;
        String str[] = new String[2];
        str [0] = username;
        str [1;]password;
        SQLiteDatabase db =getReadableDatabase();
        Cursor c = db.rawQuery( " select * from users where usermane =? and password=?",str);
        if (c.moveToFirst()){
            resurt
        }
    }
}
