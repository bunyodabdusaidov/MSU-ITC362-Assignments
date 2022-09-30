package com.example.countapp;

import android.util.Log;

import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel
{
    int counter = 0;
    public MainViewModel()
    {
        Log.i( "MainViewModel", "ViewModel is Created!");
    }

    public void increment()
    {
        counter++;
    }
}

