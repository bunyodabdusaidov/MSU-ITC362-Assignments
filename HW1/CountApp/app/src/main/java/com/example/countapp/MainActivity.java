package com.example.countapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;

import com.example.countapp.databinding.ActivityMainBinding;
import androidx.databinding.DataBindingUtil;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        Log.i("MainActivity", "MainViewModel is Initialized");
        binding.counter.setText(String.valueOf(mainViewModel.counter));

        binding.tapButton.setOnClickListener((v) -> {
            mainViewModel.increment();
            binding.counter.setText(String.valueOf(mainViewModel.counter));
        });
    }
}