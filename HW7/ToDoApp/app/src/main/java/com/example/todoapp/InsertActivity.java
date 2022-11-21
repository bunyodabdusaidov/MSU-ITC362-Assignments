package com.example.todoapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class InsertActivity extends AppCompatActivity {
    private DatabaseManager dbManager;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dbManager = new DatabaseManager(this);
        setContentView(R.layout.activity_insert);
    }

    public void insert(View v) {
        // Retrieve first name, last name, and email
        EditText taskEditText = (EditText) findViewById(R.id.input_TASK);
        String task = taskEditText.getText().toString();

        // insert new friend in database

        Task newTask = new Task(0, task);
        dbManager.insert(newTask);
        Toast.makeText(this, "Task added", Toast.LENGTH_SHORT).show();

        // clear data
        taskEditText.setText("");

    }

    public void goBack(View v) {
        this.finish();
    }
}
