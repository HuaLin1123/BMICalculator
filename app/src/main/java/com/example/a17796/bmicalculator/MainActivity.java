package com.example.a17796.bmicalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import java.text.*;

public class MainActivity extends AppCompatActivity {
    // creates keys for bmiDisplay to receive data from MainActivity
    public final static String EXTRA_VALUE="com.example.a17796.bmicalculator.VALUE";
    public final static String EXTRA_MESSAGE="com.example.a17796.bmicalculator.MESSAGE";
    public final static String EXTRA_COLOR="com.example.a17796.bmicalculator.COLOR";

    // initial startup of MainActivity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // called when getBMI button is pressed
    public void getBMI(View view) {
        String bmiMessage;
        String bmiColor;
        // adds intent to be called in order to start bmiDisplay
        Intent intent = new Intent(this, bmiDisplay.class);
        // gets weight and height measurements from textfields
        EditText pound = (EditText) findViewById(R.id.pounds);
        EditText foot = (EditText) findViewById(R.id.feet);
        EditText inch = (EditText) findViewById(R.id.inches);
        int totalInch = Integer.parseInt(foot.getText().toString())*12+Integer.parseInt(inch.getText().toString());
        // gets bmi value
        double bmi =  (Integer.parseInt(pound.getText().toString())/(Math.pow(totalInch,2)))*703;
        if (bmi>=30) {
            bmiMessage="You are obese";
            // sets black color
            bmiColor="#000000";
        } else if (bmi>=25) {
            bmiMessage="You are overweight";
            // sets blue color
            bmiColor="#0000FF";
        } else if (bmi>=18.5) {
            bmiMessage="You are normal weight";
            // sets green color
            bmiColor="#008000";
        } else {
            bmiMessage="You are underweight";
            // sets red color
            bmiColor="#FF0000";
        }
        // rounds bmi to hundredths digit
        String bmiString = new DecimalFormat("###.##").format(bmi);
        // sends bmi category to bmiDisplay
        intent.putExtra(EXTRA_MESSAGE, bmiMessage);
        // sends bmi value to bmiDisplay
        intent.putExtra(EXTRA_VALUE, bmiString);
        // sends color according to bmiValue to bmiDisplay
        intent.putExtra(EXTRA_COLOR, bmiColor);
        // starts bmiDisplay
        startActivity(intent);
    }
}
