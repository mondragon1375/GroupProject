package com.example.groupproject;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

// resources https://codinginflow.com/tutorials/android/slide-animation-between-activities
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void nextPage(View v) {
        Intent intent = new Intent(this, DrinksMenuActivity.class);
        startActivity(intent);
    }
}
