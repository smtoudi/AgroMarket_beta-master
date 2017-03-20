package com.example.slawomirmakurat.agromarket.dateBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

/**
 * Created by Demon on 20.03.2017.
 */

public class LoginDataBaseAdapter {

    static final String DATABASE_NAME = "login_database";
    static final int DB_VERSION = 1;
    public static final int NAME_COLUMN = 1;
    static  final String DATABASE_CREATE = "create table "+ "LOGIN" + "( " + "ID"+ " integer primary key autoincrement," + "USERNAME text ,PASSWORD text)";

    public SQLiteDatabase db;
    private final Context context;
    private DataBaseHelper dbHelper;

    public LoginDataBaseAdapter(Context context) {
        this.context = context;
        dbHelper = new DataBaseHelper(context, DATABASE_NAME, null, DB_VERSION);
    }
    public LoginDataBaseAdapter open() throws SQLException {
        db= dbHelper.getWritableDatabase();
        return this;
    }
    public void close() {
        db.close();
    }
    public SQLiteDatabase getDataBaseInstance() {
        return db;
    }
    public void insertEntry(String userName, String password){
        ContentValues newValues = new ContentValues();
        newValues.put("USERNAME", userName);
        newValues.put("PASSWORD",password);
        db.insert("LOGIN",null,newValues);
        Toast.makeText(context, "DODANO UZYTKOWNIKA", Toast.LENGTH_LONG).show();
    }
    public int deleteEntry (String userName) {
        String where = "USERNAME=?";
        int numberOfEntriesDeleted = db.delete("LOGIN", where, new String[]{userName});
        return numberOfEntriesDeleted;
    }
    public String getSingleEntry (String userName) {
        Cursor cursor = db.query("LOGIN", null, " USERNAME=?", new String[]{userName},null,null,null);
        if (cursor.getCount()<1) {
            cursor.close();
            return "NOT EXISTS";
        }
        cursor.moveToFirst();
        String password = cursor.getString(cursor.getColumnIndex("PASSWORD"));
        cursor.close();
        return password;
    }
    public void updateEntry ( String userName, String password)  {
        ContentValues updatedValues = new ContentValues();
        updatedValues.put("USERNAME", userName);
        updatedValues.put("PASSWORD", password);
        String where = "USERNAME=?";
        db.update("LOGIN", updatedValues, where, new String[]{userName});
    }
}
