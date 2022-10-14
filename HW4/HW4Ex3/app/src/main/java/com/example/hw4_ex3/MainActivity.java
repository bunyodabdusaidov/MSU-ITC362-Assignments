package com.example.hw4_ex3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    public static Counter counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        counter = new Counter();
        setContentView(R.layout.activity_main);
    }

    public void onStart() {
        super.onStart();
        updateView();
    }

    public void updateView() {
        Button counterBtn = (Button) findViewById(R.id.counter_btn);
        counterBtn.setText(String.valueOf(counter.getCounter()));
    }

    public void incrementCounter(View v) {
        Intent myIntent = new Intent(this, CounterActivity.class);
        this.startActivity(myIntent);
    }
}