package com.example.groupproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class KidsMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kids_menu);
        Intent intent = getIntent();

        final ArrayAdapter<Food> listAdapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1, Food.kidsMenu);

        ListView listFoods = (ListView) findViewById(R.id.list_kidsChoices);
        listFoods.setAdapter(listAdapter);

        // Create a listener to listen for when a Food item is clicked on
        AdapterView.OnItemClickListener itemClickListener =
                new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> listFoods,
                                            View itemView, int position, long id) {
                        EditText fooditem = (EditText) findViewById(R.id.kidsItem);
                        String[] kidsFood = new String[8];

                        //for(int i = 0; i <= position; i++)
                        int i = position;
                        kidsFood[i] = Food.kidsMenu[i].getFoodName();


                        Context context = getApplicationContext();
                        int duration = Toast.LENGTH_SHORT;

                        Toast toast = Toast.makeText(context, kidsFood[i], duration);
                        toast.show();

                        fooditem.setText(kidsFood[i]);
                        // Pass the Food name the user clicks on to BreakfastChoicesActivity
                    }
                };
        // Assign the listener to the list view
        listFoods.setOnItemClickListener(itemClickListener);
    }

    public void goToAdultMenu(View v) {
        Intent intent = new Intent(this, AdultsMenuActivity.class);
        startActivity(intent);
    }


}