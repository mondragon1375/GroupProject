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

public class DessertsMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desserts_menu);
        Intent intent = getIntent();

        final ArrayAdapter<Food> listAdapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1, Food.dessertMenu);

        ListView listFoods = (ListView) findViewById(R.id.list_dessertsChoices);
        listFoods.setAdapter(listAdapter);

        // Create a listener to listen for when a Food item is clicked on
        AdapterView.OnItemClickListener itemClickListener =
                new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> listFoods,
                                            View itemView, int position, long id) {
                        TextView fooditem = (TextView) findViewById(R.id.dessertsItemName);
                        String[] dessertFood = new String[10];

                        //for(int i = 0; i <= position; i++)
                        int i = position;
                        dessertFood[i] = Food.dessertMenu[i].getFoodName();


                        Context context = getApplicationContext();
                        int duration = Toast.LENGTH_SHORT;

                        Toast toast = Toast.makeText(context, dessertFood[i], duration);
                        toast.show();

                        fooditem.setText(dessertFood[i]);
                        // Pass the Food name the user clicks on to BreakfastChoicesActivity
                    }
                };
        // Assign the listener to the list view
        listFoods.setOnItemClickListener(itemClickListener);
    }

    public void goToBill(View v) {
        Intent intent = new Intent(this, CalculateBillActivity.class);
        startActivity(intent);
    }


}