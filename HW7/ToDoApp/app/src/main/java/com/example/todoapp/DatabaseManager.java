package com.example.todoapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseManager extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "tasksDB";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_TASKS = "Task";
    private static final String ID = "id";
    private static final String TASK = "task";

    public DatabaseManager(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // build sql create statement
        String sqlCreate = "create table " + TABLE_TASKS + "( " + ID;
        sqlCreate += " integer primary key autoincrement, " + TASK + " text )";
        db.execSQL(sqlCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // drop old table if it exists
        db.execSQL("drop table if exists " + TABLE_TASKS);
        // re-create table
        onCreate(db);
    }

    public void insert(Task friend) {
        SQLiteDatabase db = this.getWritableDatabase();
        String sqlInsert = "insert into " + TABLE_TASKS;
        sqlInsert += " values(null, '" + friend.getTask() + "' )";

        db.execSQL(sqlInsert);
        db.close();
    }

    public void deleteById(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        String sqlDelete = "delete from " + TABLE_TASKS;
        sqlDelete += " where " + ID + " = " + id;

        db.execSQL(sqlDelete);
        db.close();
    }

    public ArrayList<Task> selectAll() {
        String sqlQuery = "select * from " + TABLE_TASKS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sqlQuery, null);

        ArrayList<Task> task = new ArrayList<>();
        while (cursor.moveToNext()) {
            Task currentTask = new Task(Integer.parseInt(cursor.getString(0)),
                    cursor.getString(1));
            task.add(currentTask);
        }
        db.close();
        return task;
    }

    public Task selectById(int id) {
        String sqlQuery = "select * from " + TABLE_TASKS;
        sqlQuery += " where " + ID + " = " + id;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sqlQuery, null);

        Task task = null;
        if (cursor.moveToFirst())
            task = new Task(Integer.parseInt(cursor.getString(0)),
                    cursor.getString(1));
        return task;
    }
}
