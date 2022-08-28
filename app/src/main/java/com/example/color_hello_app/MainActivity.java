package com.example.color_hello_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView mHelloTextView;
    private String[] mColorArray = {"red", "pink", "purple", "deep-purple", "indigo", "blue", "light_blue",
    "cyan", "teal", "green", "light_green", "lime", "yellow", "amber", "orange", "deep_orange", "brown",
    "grey", "blue_grey", "black"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mHelloTextView = findViewById(R.id.hello_textview);
        if (savedInstanceState != null) {
            mHelloTextView.setTextColor(savedInstanceState.getInt("color"));
        }
    }
    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putInt("color", mHelloTextView.getCurrentTextColor());  // save the current text color
        super.onSaveInstanceState(outState);
    }

    public void changeColor(View view) {
        Random random = new Random();
        String colorName = mColorArray[random.nextInt(20)]; // Conscripting the array inside the random number

        // Get the color identifier that matches the color name
        int colorResource = getResources().getIdentifier(colorName, "color",
                getApplicationContext().getPackageName());

        // Get the color ID from the resources
        int colorRes = ContextCompat.getColor(this, colorResource);

        // Set the text color
        mHelloTextView.setTextColor(colorRes);
    }
}