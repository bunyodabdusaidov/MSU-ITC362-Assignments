package com.example.candystorev3;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class InsertActivity extends AppCompatActivity {
    private DatabaseManager dbManager;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dbManager = new DatabaseManager(this);
        setContentView(R.layout.activity_insert);
    }

    public void insert(View v) {
        // Retrieve name and price
        EditText nameEditText = (EditText) findViewById(R.id.input_name);
        EditText priceEditText = (EditText) findViewById(R.id.input_price);
        String name = nameEditText.getText().toString();
        String priceString = priceEditText.getText().toString();

        // insert new candy in database
        try {
            double price = Double.parseDouble(priceString);
            Candy candy = new Candy(0, name, price);
            dbManager.insert(candy);
            Toast.makeText(this, "Candy added", Toast.LENGTH_SHORT).show();
        } catch (NumberFormatException nfe) {
            Toast.makeText(this, "Price error", Toast.LENGTH_LONG).show();
        }

        // clear data
        nameEditText.setText("");
        priceEditText.setText("");

        ArrayList<Candy> candies = dbManager.selectAll();
        for(Candy candy : candies)
            Log.w("MainActivity", "candy = " + candy.toString());
    }

    public void goBack(View v) {
        this.finish();
    }
}
