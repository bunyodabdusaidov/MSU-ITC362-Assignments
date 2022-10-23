package com.example.hangmanv5;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class GameResultFragment extends Fragment {
    private TextView gameResulTV;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        setUpFragmentFui(container);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    private void setUpFragmentFui(ViewGroup container) {
        if (gameResulTV == null) {
            gameResulTV = new TextView(getActivity());
            gameResulTV.setGravity(Gravity.CENTER);
            gameResulTV.setTextSize(36);
            container.addView(gameResulTV);
        }
    }

    public void setResult(String result) {
        gameResulTV.setText(result);
    }

    public void onStart() {
        super.onStart();
        gameResulTV.setText("GOOD LUCK");
    }
}
