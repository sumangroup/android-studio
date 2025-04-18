package com.example.databaseexample1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    //1. create the variable of db_name and tables
    private static final String DB_NAME="userdb";
    private static final String TABLE="users";
    public DatabaseHelper(@Nullable Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+TABLE+"(id INTEGER PRIMARY KEY,name TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE);
        onCreate(db);
    }

    public void insert(String name){
        ContentValues cv=new ContentValues();
        cv.put("name",name);
        getWritableDatabase().insert(TABLE,null,cv);
    }
    public Cursor getAllData(){
        return getReadableDatabase().rawQuery("SELECT * FROM "+TABLE,null);
    }

    public void update(int id,String name){
        ContentValues cv=new ContentValues();
        cv.put("name",name);
        getWritableDatabase().update(TABLE,cv,"id=?",new String[]{String.valueOf(id)});
    }

    public void delete(int id){
        getWritableDatabase().delete(TABLE,"id=?",new String[]{String.valueOf(id)});
    }
}
