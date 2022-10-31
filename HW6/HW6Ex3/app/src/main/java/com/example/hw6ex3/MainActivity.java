package com.example.hw6ex3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView red = findViewById(R.id.red);
        red.setText(R.string.red);
        red.setTextColor(getColor(R.color.red));

        FragmentManager fragmentManager = getSupportFragmentManager();
        if (fragmentManager.findFragmentById(R.id.traffic_light_fragment) == null) {
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            TrafficLightFragment fragment = new TrafficLightFragment();
            transaction.add(R.id.traffic_light_fragment, fragment);
            transaction.commit();
        }

        if (fragmentManager.findFragmentById(R.id.button_fragment) == null) {
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            TrafficLightFragment fragment = new TrafficLightFragment();
            transaction.add(R.id.button_fragment, fragment);
            transaction.commit();
        }
    }

    private int state = 2;

    public void clickMe(View view) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        TrafficLightFragment trafficLightFragment = (TrafficLightFragment)
                fragmentManager.findFragmentById(R.id.traffic_light_fragment);
        View trafficLightFragmentView = trafficLightFragment.getView();
        TextView red = trafficLightFragmentView.findViewById(R.id.red);
        TextView yellow = trafficLightFragmentView.findViewById(R.id.yellow);
        TextView green = trafficLightFragmentView.findViewById(R.id.green);

        switch (state) {
            case 1: //setting the label to red
                red.setVisibility(View.VISIBLE);
                yellow.setVisibility(View.INVISIBLE);
                green.setVisibility(View.INVISIBLE);
                red.setText(R.string.red);
                red.setTextColor(getColor(R.color.red));
                //incrementing the state
                state += 1;
                break;
            case 2: //setting the label to green
                red.setVisibility(View.INVISIBLE);
                yellow.setVisibility(View.INVISIBLE);
                green.setVisibility(View.VISIBLE);
                green.setText(R.string.green);
                green.setTextColor(getColor(R.color.green));
                //incrementing the state
                state += 1;
                break;
            case 3: //setting the label to yellow
                red.setVisibility(View.INVISIBLE);
                yellow.setVisibility(View.VISIBLE);
                green.setVisibility(View.INVISIBLE);
                yellow.setText(R.string.yellow);
                yellow.setTextColor(getColor(R.color.yellow));
                state = 1;
                break;
            default: //exception handling
                throw new RuntimeException("Invalid state");
        }
    }
}