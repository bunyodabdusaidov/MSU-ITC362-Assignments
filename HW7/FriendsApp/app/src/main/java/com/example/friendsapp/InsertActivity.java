package com.example.friendsapp;

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
        EditText firstNameEditText = (EditText) findViewById(R.id.input_first_name);
        EditText lastNameEditText = (EditText) findViewById(R.id.input_last_name);
        EditText emailEditText = (EditText) findViewById(R.id.input_email);
        String firstName = firstNameEditText.getText().toString();
        String lastName = lastNameEditText.getText().toString();
        String email = emailEditText.getText().toString();

        // insert new friend in database
        try {
            Friends friend = new Friends(0, firstName, lastName, email);
            dbManager.insert(friend);
            Toast.makeText(this, "Friend added", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(this, "Email Address error", Toast.LENGTH_SHORT).show();
        }

        // clear data
        firstNameEditText.setText("");
        lastNameEditText.setText("");
        emailEditText.setText("");

        ArrayList<Friends> friends = dbManager.selectAll();
        for(Friends friend : friends)
            Log.w("MainActivity", "friend = " + friend.toString());
    }

    public void goBack(View v) {
        this.finish();
    }
}
