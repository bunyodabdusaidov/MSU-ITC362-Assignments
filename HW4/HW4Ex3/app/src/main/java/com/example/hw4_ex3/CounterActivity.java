package com.example.hw4_ex3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class CounterActivity extends AppCompatActivity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_back);
    }

    private void updateCounterObject() {
        Counter counter = MainActivity.counter;
        counter.increment();
    }

    public void goBack(View v) {
        updateCounterObject();
        this.finish();
    }
}
