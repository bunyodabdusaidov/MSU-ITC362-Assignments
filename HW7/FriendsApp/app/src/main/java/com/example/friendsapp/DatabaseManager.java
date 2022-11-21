package com.example.friendsapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class DatabaseManager extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "friendsDB";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_FRIENDS = "friends";
    private static final String ID = "id";
    private static final String FIRST_NAME = "firstname";
    private static final String LAST_NAME = "lastname";
    private static final String EMAIL = "email";

    public DatabaseManager(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // build sql create statement
        String sqlCreate = "create table " + TABLE_FRIENDS + "( " + ID;
        sqlCreate += " integer primary key autoincrement, " + FIRST_NAME;
        sqlCreate += " text, " + LAST_NAME + " text, " + EMAIL + " text )";
        db.execSQL(sqlCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // drop old table if it exists
        db.execSQL("drop table if exists " + TABLE_FRIENDS);
        // re-create table
        onCreate(db);
    }

    public void insert(Friends friend) {
        SQLiteDatabase db = this.getWritableDatabase();
        String sqlInsert = "insert into " + TABLE_FRIENDS;
        sqlInsert += " values(null, '" + friend.getFirstName();
        sqlInsert += "', '" + friend.getLastName();
        sqlInsert += "', '" + friend.getEmail() + "' )";

        db.execSQL(sqlInsert);
        db.close();
    }

    public void deleteById(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        String sqlDelete = "delete from " + TABLE_FRIENDS;
        sqlDelete += " where " + ID + " = " + id;

        db.execSQL(sqlDelete);
        db.close();
    }

    public void updateById(int id, String firstName, String lastName, String email) {
        SQLiteDatabase db = this.getWritableDatabase();
        String sqlUpdate = "update " + TABLE_FRIENDS;
        sqlUpdate += " set " + FIRST_NAME + " = '" + firstName + "', ";
        sqlUpdate += LAST_NAME + " = '" + lastName + "', ";
        sqlUpdate += EMAIL + " = '" + email + "'";
        sqlUpdate += " where " + ID + " = " + id;

        db.execSQL(sqlUpdate);
        db.close();
    }

    public ArrayList<Friends> selectAll() {
        String sqlQuery = "select * from " + TABLE_FRIENDS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sqlQuery, null);

        ArrayList<Friends> friends = new ArrayList<>();
        while (cursor.moveToNext()) {
            Friends currentFriend = new Friends(Integer.parseInt(cursor.getString(0)),
                    cursor.getString(1), cursor.getString(2),
                    cursor.getString(3));
            friends.add(currentFriend);
        }
        db.close();
        return friends;
    }

    public Friends selectById(int id) {
        String sqlQuery = "select * from " + TABLE_FRIENDS;
        sqlQuery += " where " + ID + " = " + id;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sqlQuery, null);

        Friends friend = null;
        if (cursor.moveToFirst())
            friend = new Friends(Integer.parseInt(cursor.getString(0)),
                    cursor.getString(1), cursor.getString(2),
                    cursor.getString(3));
        return friend;
    }
}
