package com.example.hellogoodbyeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void hello_goodbye(View v)
    {
        View hello_text = findViewById(R.id.HelloText);
        View hello_image = findViewById(R.id.HelloImage);
        View goodbye_text = findViewById(R.id.GoodbyeText);
        View goodbye_image = findViewById(R.id.GoodbyeImage);

        hello_text.setVisibility(View.INVISIBLE);
        hello_image.setVisibility(View.INVISIBLE);
        goodbye_text.setVisibility(View.VISIBLE);
        goodbye_image.setVisibility(View.VISIBLE);
    }
}