package com.example.hw3ex2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import static com.example.hw3ex2.R.*;

public class MainActivity extends AppCompatActivity {
    private ConstraintSet set;
    private ConstraintLayout layout;
    Button btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layout = (ConstraintLayout) findViewById(id.CL);
        layout.setBackgroundColor(Color.parseColor("#C89B6D"));
        set = new ConstraintSet();
        set.clone(layout);

        Button btn1 = new Button(this);
        btn1.setText(getString(string.plum));
        btn1.setId(View.generateViewId());
        btn1.setTag("btn1");
        btn1.setBackgroundColor(Color.parseColor("#AC7D50"));
        btn1.setOnClickListener(ColorChangeListener);
        layout.addView(btn1);
        set.connect(btn1.getId(), ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP, 50);
        set.connect(btn1.getId(), ConstraintSet.RIGHT, ConstraintSet.PARENT_ID, ConstraintSet.RIGHT, 0);
        set.connect(btn1.getId(), ConstraintSet.LEFT, ConstraintSet.PARENT_ID, ConstraintSet.LEFT, 0);
        set.constrainHeight(btn1.getId(), 200);
        set.applyTo(layout);

        Button btn2 = new Button(this);
        btn2.setText(getString(string.blue));
        btn2.setId(View.generateViewId());
        btn2.setTag("btn2");
        btn2.setBackgroundColor(Color.parseColor("#AC7D50"));
        btn2.setOnClickListener(ColorChangeListener);
        layout.addView(btn2);
        set.connect(btn2.getId(), ConstraintSet.TOP, btn1.getId(), ConstraintSet.BOTTOM, 10);
        set.connect(btn2.getId(), ConstraintSet.RIGHT, ConstraintSet.PARENT_ID, ConstraintSet.RIGHT, 0);
        set.connect(btn2.getId(), ConstraintSet.LEFT, ConstraintSet.PARENT_ID, ConstraintSet.LEFT, 0);
        set.constrainHeight(btn2.getId(), 200);
        set.applyTo(layout);

        btn3 = new Button(this);
        btn3.setText(getString(string.gold));
        btn3.setId(View.generateViewId());
        btn3.setTag("btn3");
        btn3.setBackgroundColor(Color.parseColor("#AC7D50"));
        btn3.setOnClickListener(ColorChangeListener);
        layout.addView(btn3);
        set.connect(btn3.getId(), ConstraintSet.TOP, btn2.getId(), ConstraintSet.BOTTOM, 10);
        set.connect(btn3.getId(), ConstraintSet.RIGHT, ConstraintSet.PARENT_ID, ConstraintSet.RIGHT, 0);
        set.connect(btn3.getId(), ConstraintSet.LEFT, ConstraintSet.PARENT_ID, ConstraintSet.LEFT, 0);
        set.constrainHeight(btn3.getId(), 200);
        set.applyTo(layout);
    }

    private View.OnClickListener ColorChangeListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String description = (String) v.getTag();

            TextView textView = new TextView(MainActivity.this);
            textView.setLayoutParams(new ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            textView.setGravity(Gravity.CENTER);
            switch ((String) v.getTag()) {
                case "btn1":
                    textView.setText(string.plum_is);
                    break;
                case "btn2":
                    textView.setText(string.blue_is);
                    break;
                case "btn3":
                    textView.setText(string.gold_is);
                    break;
            }

            textView.setBackgroundColor(Color.parseColor("#AC7D50"));
            textView.setId(View.generateViewId());
            layout.addView(textView);

            set.connect(textView.getId(), ConstraintSet.TOP, btn3.getId(), ConstraintSet.BOTTOM, 50);
            set.connect(textView.getId(), ConstraintSet.RIGHT, ConstraintSet.PARENT_ID, ConstraintSet.RIGHT, 0);
            set.connect(textView.getId(), ConstraintSet.LEFT, ConstraintSet.PARENT_ID, ConstraintSet.LEFT, 0);
            set.constrainHeight(textView.getId(), 400);
            set.applyTo(layout);
        }
    };
}