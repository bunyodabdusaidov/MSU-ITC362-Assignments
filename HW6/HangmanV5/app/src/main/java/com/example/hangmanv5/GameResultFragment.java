package com.example.hangmanv5;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class GameResultFragment extends Fragment {
    private TextView gameResultTV;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        setUpFragmentFui(container);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    private void setUpFragmentFui(ViewGroup container) {
        if (gameResultTV == null) {
            gameResultTV = new TextView(getActivity());
            gameResultTV.setGravity(Gravity.CENTER);
            gameResultTV.setTextSize(36);
            container.addView(gameResultTV);
        }
    }

    public void setResult(String result) {
        gameResultTV.setText(result);
    }

    public void onStart() {
        super.onStart();
        gameResultTV.setText("GOOD LUCK");
    }
}
