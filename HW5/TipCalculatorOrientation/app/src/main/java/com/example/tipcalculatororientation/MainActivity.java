package com.example.tipcalculatororientation;

import android.content.res.Configuration;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.example.tipcalculatororientation.databinding.ActivityMainBinding;
import com.example.tipcalculatororientation.databinding.ActivityMainLandscapeBinding;
import java.text.NumberFormat;


public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding_portrait;
    private ActivityMainLandscapeBinding binding_landscape;
    private MainViewModel mainViewModel;
    public NumberFormat money = NumberFormat.getCurrencyInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Configuration config = getResources().getConfiguration();
        modifyLayout(config);

        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);

        TextChangeListenerPortrait tch_portrait = new TextChangeListenerPortrait();
        TextChangeListenerLandscape tch_landscape = new TextChangeListenerLandscape();

        binding_portrait.amountBill.addTextChangedListener(tch_portrait);
        binding_portrait.amountTipPercent.addTextChangedListener(tch_portrait);

        binding_landscape.amountBill.
                addTextChangedListener(tch_landscape);
        binding_landscape.amountTipPercent.addTextChangedListener(tch_landscape);
    }

    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        modifyLayout(newConfig);
    }

    private void modifyLayout(Configuration newConfig) {
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE)
            binding_landscape = DataBindingUtil.setContentView(this, R.layout.activity_main_landscape);
        else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT)
            binding_portrait = DataBindingUtil.setContentView(this, R.layout.activity_main);
    }

    public void calculate_portrait() {
        try {
            float billAmount = Float.parseFloat(String.valueOf(binding_portrait.amountBill.getText()));
            int tipPercent = Integer.parseInt(String.valueOf(binding_portrait.amountTipPercent.getText()));
            // update the Model
            mainViewModel.setBill(billAmount);
            mainViewModel.setTip(tipPercent);
            // ask Model to calculate tip and total amounts, and update the view
            binding_portrait.amountTip.setText(money.format(mainViewModel.getTipAmount()));
            binding_portrait.amountTotal.setText(money.format(mainViewModel.getTotalAmount()));
        } catch (NumberFormatException nfe) {
            // pop up an alert
        }
    }

    public void calculate_landscape() {
        try {
            float billAmount = Float.parseFloat(String.valueOf(binding_landscape.amountBill.getText()));
            int tipPercent = Integer.parseInt(String.valueOf(binding_landscape.amountTipPercent.getText()));
            // update the Model
            mainViewModel.setBill(billAmount);
            mainViewModel.setTip(tipPercent);
            // ask Model to calculate tip and total amounts, and update the view
            binding_landscape.amountTip.setText(money.format(mainViewModel.getTipAmount()));
            binding_landscape.amountTotal.setText(money.format(mainViewModel.getTotalAmount()));
        } catch (NumberFormatException nfe) {
            // pop up an alert
        }
    }

    private class TextChangeListenerPortrait implements TextWatcher {

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {calculate_portrait();}
    }

    private class TextChangeListenerLandscape implements TextWatcher {

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {calculate_landscape();}
    }

}