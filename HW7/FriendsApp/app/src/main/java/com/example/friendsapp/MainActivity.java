package com.example.friendsapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    DatabaseManager dbManager;
    ListView List;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dbManager = new DatabaseManager(this);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        displayFriends();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch (id) {
            case R.id.action_add:
                Log.w("MainActivity", "Add selected");
                Intent insertIntent = new Intent(this, InsertActivity.class);
                this.startActivity(insertIntent);
                return true;
            case R.id.action_delete:
                Log.w("MainActivity", "Delete selected");
                Intent deleteIntent = new Intent(this, DeleteActivity.class);
                this.startActivity(deleteIntent);
                return true;
            case R.id.action_update:
                Log.w("MainActivity", "Update selected");
                Intent updateIntent = new Intent(this, UpdateActivity.class);
                this.startActivity(updateIntent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void displayFriends() {
        List = (ListView) findViewById(R.id.simpleListView);
        ArrayList<Friends> friends = dbManager.selectAll();
        String[] friendsList = new String[friends.size()];
        if (friends.size() > 0) {
            int i = 0;
            for (Friends friend : friends) {
                friendsList[i] = friend.toString();
                i++;
            }
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.list_view, R.id.textView, friendsList);
            List.setAdapter(arrayAdapter);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        displayFriends();
    }
}