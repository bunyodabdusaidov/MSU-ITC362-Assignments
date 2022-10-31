package com.example.hw6ex2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView traffic = findViewById(R.id.traffic_light_text);
        traffic.setText(R.string.red);
        traffic.setTextColor(getColor(R.color.red));

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
        TextView trafficLightTV = trafficLightFragmentView.findViewById(R.id.traffic_light_text);
        switch (state) {
            case 1: //setting the label to red
                trafficLightTV.setText(R.string.red);
                trafficLightTV.setTextColor(getColor(R.color.red));
                //incrementing the state
                state += 1;
                break;
            case 2: //setting the label to yellow
                trafficLightTV.setText(R.string.yellow);
                trafficLightTV.setTextColor(getColor(R.color.yellow));
                //incrementing the state
                state += 1;
                break;
            case 3: //setting the label to green
                trafficLightTV.setText(R.string.green);
                trafficLightTV.setTextColor(getColor(R.color.green));
                state = 1;
                break;
            default: //exception handling
                throw new RuntimeException("Invalid state");
        }
    }

}