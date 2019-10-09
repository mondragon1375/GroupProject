package com.example.groupproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class DrinksMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinks_menu);
        Intent intent = getIntent();

        ArrayAdapter<Food> listAdapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1, Food.drinksFood);

        ListView listFoods = (ListView) findViewById(R.id.list_drinkChoices);
        listFoods.setAdapter(listAdapter);

        // Create a listener to listen for when a Food item is clicked on
        AdapterView.OnItemClickListener itemClickListener =
                new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> listFoods,
                                            View itemView, int position, long id) {



                        // Pass the Food name the user clicks on to BreakfastChoicesActivity
                    }
                };
        // Assign the listener to the list view
        listFoods.setOnItemClickListener(itemClickListener);


    }

}
