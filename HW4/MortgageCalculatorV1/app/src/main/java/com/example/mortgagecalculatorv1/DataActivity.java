package com.example.mortgagecalculatorv1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class DataActivity extends AppCompatActivity {
    public static final String DA = "DataActivity";

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.w(DA, "Inside DataActivity:onCreate\n");
        setContentView(R.layout.activity_data);
    }

    public void goBack(View v) {
        this.finish();
    }

    protected void onStart() {
        super.onStart();
        Log.w(DA, "Inside DataActivity:onStart\n");
    }

    protected void onRestart() {
        super.onRestart();
        Log.w(DA, "Inside DataActivity:onRestart\n");
    }

    protected void onResume() {
        super.onResume();
        Log.w(DA, "Inside DataActivity:onResume\n");
    }

    protected void onPause() {
        super.onPause();
        Log.w(DA, "Inside DataActivity:onPause\n");
    }

    protected void onStop() {
        super.onStop();
        Log.w(DA, "Inside DataActivity:onStop\n");
    }

    protected void onDestroy() {
        super.onDestroy();
        Log.w(DA, "Inside DataActivity:onDestroy\n");
    }
}
