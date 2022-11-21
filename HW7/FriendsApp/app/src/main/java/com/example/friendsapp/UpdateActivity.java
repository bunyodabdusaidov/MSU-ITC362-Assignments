package com.example.friendsapp;

import android.graphics.Point;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class UpdateActivity extends AppCompatActivity {
    DatabaseManager dbManager;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dbManager = new DatabaseManager(this);
        updateView();
    }

    // build a View dynamically with all the friends
    private void updateView() {
        ArrayList<Friends> friends = dbManager.selectAll();
        if (friends.size() > 0) {
            // create ScrollView and GridLayout
            ScrollView scrollView = new ScrollView(this);
            GridLayout grid = new GridLayout(this);
            grid.setRowCount(friends.size());
            grid.setColumnCount(5);

            // create arrays of components
            TextView[] ids = new TextView[friends.size()];
            EditText[][] friendsList = new EditText[friends.size()][3];
            Button[] buttons = new Button[friends.size()];
            ButtonHandler bh = new ButtonHandler();

            // retrieve width of screen
            Point size = new Point();
            getWindowManager().getDefaultDisplay().getSize(size);
            int width = size.x;

            int i = 0;

            for (Friends friend : friends) {
                // create the TextView for the candy's id
                ids[i] = new TextView(this);
                ids[i].setGravity(Gravity.CENTER);
                ids[i].setText("" + friend.getId());

                // create the two EditTexts for the candy's name and price
                friendsList[i][0] = new EditText(this);
                friendsList[i][1] = new EditText(this);
                friendsList[i][2] = new EditText(this);
                friendsList[i][0].setText(friend.getFirstName());
                friendsList[i][1].setText(friend.getLastName());
                friendsList[i][2].setText(friend.getEmail());
                friendsList[i][0].setId(10 * friend.getId());
                friendsList[i][1].setId(10 * friend.getId() + 1);
                friendsList[i][2].setId(10 * friend.getId() + 2);

                // create the button
                buttons[i] = new Button(this);
                buttons[i].setText("Update");
                buttons[i].setId(friend.getId());

                // set up event handling
                buttons[i].setOnClickListener(bh);

                // add the elements to grid
                grid.addView(ids[i], width / 15,
                        ViewGroup.LayoutParams.WRAP_CONTENT);
                grid.addView(friendsList[i][0], (int) (width * .2),
                        ViewGroup.LayoutParams.WRAP_CONTENT);
                grid.addView(friendsList[i][1], (int) (width * .2),
                        ViewGroup.LayoutParams.WRAP_CONTENT);
                grid.addView(friendsList[i][2], (int) (width * .25),
                        ViewGroup.LayoutParams.WRAP_CONTENT);
                grid.addView(buttons[i], (int) (width * .25),
                        ViewGroup.LayoutParams.WRAP_CONTENT);

                i++;
            }
            scrollView.addView(grid);
            setContentView(scrollView);
        }
    }

    private class ButtonHandler implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            // retrieve firstname, lastname, and email of the friend
            int friendId = v.getId();
            EditText firstNameET = (EditText) findViewById(10 * friendId);
            EditText lastNameET = (EditText) findViewById(10 * friendId + 1);
            EditText emailET = (EditText) findViewById(10 * friendId + 2);
            String firstName = firstNameET.getText().toString();
            String lastName = lastNameET.getText().toString();
            String email = emailET.getText().toString();

            // update friend in database
            try {
                dbManager.updateById(friendId, firstName, lastName, email);
                Toast.makeText(UpdateActivity.this, "Friend updated",
                        Toast.LENGTH_SHORT). show();

                // update screen
                updateView();
            } catch (Exception e) {
                Toast.makeText(UpdateActivity.this, "Email address error",
                        Toast.LENGTH_LONG).show();
            }
        }
    }
}
