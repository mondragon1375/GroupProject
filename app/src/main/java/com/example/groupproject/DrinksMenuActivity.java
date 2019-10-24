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
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class DrinksMenuActivity extends AppCompatActivity {

    ArrayList<Food> drinksOrdered = new ArrayList<Food>();
    Food[] item = new Food[7];
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinks_menu);
        Intent intent = getIntent();


        final ArrayAdapter<Food> listAdapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1, Food.drinksFood);

        ListView listFoods = (ListView) findViewById(R.id.list_drinkChoices);
        listFoods.setAdapter(listAdapter);

        // Create a listener to listen for when a Food item is clicked on
        AdapterView.OnItemClickListener itemClickListener =
                new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> listFoods,
                                            View itemView, int position, long id) {
                        TextView fooditem = (TextView) findViewById(R.id.drink);
                        TextView costofitem = (TextView) findViewById(R.id.cost);

                        String[] drink = new String[7];
                        Double[] cost = new Double[7];

                        //for(int i = 0; i <= position; i++)
                        i = position;
                        drink[i] = Food.drinksFood[i].getFoodName();
                        cost[i] = Food.drinksFood[i].getPrice();
                        item[i] = Food.drinksFood[i];

                        String costString = Double.toString(cost[i]);



                        Context context = getApplicationContext();
                        int duration = Toast.LENGTH_SHORT;

                        Toast toast = Toast.makeText(context, drink[i], duration);
                        toast.show();

                        fooditem.setText(drink[i]);
                        costofitem.setText(costString);
                        // Pass the Food name the user clicks on to BreakfastChoicesActivity
                    }
                };
        // Assign the listener to the list view
        listFoods.setOnItemClickListener(itemClickListener);


    }

    public void goToKidsMenu(View v) {
        Intent intent = new Intent(this, KidsMenuActivity.class);
        startActivity(intent);
    }

    public void addtoBill(View v) {
        drinksOrdered.add(item[i]);
        Intent intent = new Intent(this, KidsMenuActivity.class);
        startActivity(intent);
    }

    }
