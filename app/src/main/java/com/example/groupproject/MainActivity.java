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

    public void proceedDrinksMenu(View v) {
        Intent intent = new Intent(this, DrinksMenuActivity.class);
        startActivity(intent);

    }
    public void proceedAdultsMenu(View v) {
        Intent intent = new Intent(this, AdultsMenuActivity.class);
        startActivity(intent);
    }

    public void proceedDessertsMenu(View v) {
        Intent intent = new Intent(this, DessertsMenuActivity.class);
        startActivity(intent);
    }

    public void proceedKidsMenu(View v) {
        Intent intent = new Intent(this, KidsMenuActivity.class);
        startActivity(intent);
    }

}
