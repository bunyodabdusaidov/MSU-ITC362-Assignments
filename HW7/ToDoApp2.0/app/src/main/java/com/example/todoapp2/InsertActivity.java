package com.example.todoapp2;

import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class InsertActivity extends AppCompatActivity {
    DatePicker simpleDatePicker;
    private DatabaseManager dbManager;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dbManager = new DatabaseManager(this);
        setContentView(R.layout.activity_insert);
        simpleDatePicker = (DatePicker) findViewById(R.id.simpleDatePicker);
    }

    public void insert(View v) {
        // Retrieve task and deadline
        EditText taskEditText = (EditText) findViewById(R.id.input_task);
        String task = taskEditText.getText().toString();
        String deadline = simpleDatePicker.getMonth() + "-";
        deadline += simpleDatePicker.getDayOfMonth() + "-";
        deadline += simpleDatePicker.getYear();

        // insert new task in database

        Task newTask = new Task(0, task, deadline);
        Toast.makeText(this, newTask.getDeadline(), Toast.LENGTH_LONG).show();
        //dbManager.insert(newTask);
        Toast.makeText(this, "Task added", Toast.LENGTH_SHORT).show();

        // clear data
        taskEditText.setText("");

    }

    public void goBack(View v) {
        this.finish();
    }
}
