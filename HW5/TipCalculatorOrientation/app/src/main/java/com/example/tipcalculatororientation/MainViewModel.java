package com.example.tipcalculatororientation;

import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    private final TipCalculator tipCalc;

    public MainViewModel() {
        tipCalc = new TipCalculator(0.17f, 100.0f);
    }

    public void setBill(float billAmount) {
        tipCalc.setBill(billAmount);
    }

    public void setTip(int tipPercent) {
        tipCalc.setTip(.01f * tipPercent);
    }

    public float getTipAmount() {
        return tipCalc.tipAmount();
    }

    public float getTotalAmount() {
        return tipCalc.totalAmount();
    }
}
