package com.example.trafficlightsimulator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView redLight;
    private ImageView yellowLight;
    private ImageView greenLight;
    private AppCompatButton btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        redLight = findViewById(R.id.red_traffic_light);
        yellowLight = findViewById(R.id.yellow_traffic_light);
        greenLight = findViewById(R.id.green_traffic_light);
        btn = findViewById(R.id.btn);
        btn.setBackgroundColor(Color.RED);
        btn.setOnClickListener(view -> simulateTrafficLight());
    }


    public void simulateTrafficLight() {
        if (btn.getText() == getString(R.string.stop_btn)) {
            greenLight.setVisibility(View.VISIBLE);
            redLight.setVisibility(View.INVISIBLE);
            yellowLight.setVisibility(View.INVISIBLE);
            btn.setText(R.string.go_btn);
            btn.setBackgroundColor(Color.GREEN);
        }

        else if (btn.getText() == getString(R.string.go_btn)) {
            yellowLight.setVisibility(View.VISIBLE);
            redLight.setVisibility(View.INVISIBLE);
            greenLight.setVisibility(View.INVISIBLE);
            btn.setText(R.string.wait_btn);
            btn.setBackgroundColor(Color.YELLOW);
        }

        else {
            redLight.setVisibility(View.VISIBLE);
            yellowLight.setVisibility(View.INVISIBLE);
            greenLight.setVisibility(View.INVISIBLE);
            btn.setText(R.string.stop_btn);
            btn.setBackgroundColor(Color.RED);
        }
    }
}