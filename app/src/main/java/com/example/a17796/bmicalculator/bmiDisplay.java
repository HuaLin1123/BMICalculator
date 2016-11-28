package com.example.a17796.bmicalculator;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.widget.TextView;

public class bmiDisplay extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bmi_display);

        // begins to get data from MainActivity
        Intent intent = getIntent();
        // gets String associated with EXTRA_MESSAGE from MainActivity
        String bmiMessage = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        String bmiValue = intent.getStringExtra(MainActivity.EXTRA_VALUE);
        String bmiColor = intent.getStringExtra(MainActivity.EXTRA_COLOR);
        // outputs bmi in textfield
        TextView text = new TextView(this);
        text.setTextSize(25);
        text.setTextColor(Color.parseColor(bmiColor));
        text.setText(bmiMessage+" with a BMI of \r\n"+bmiValue);

        // adds textfield to layout in bmiDisplay
        ViewGroup layout = (ViewGroup) findViewById(R.id.bmi_display);
        layout.addView(text);
    }
}
