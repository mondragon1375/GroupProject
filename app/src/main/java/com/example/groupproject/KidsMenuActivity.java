package com.example.groupproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class KidsMenuActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    DatabaseHelper mDatabaseHelper;
    private Button btnAdd, btnView;
    private TextView foodNameTextView, foodCostTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kids_menu);
        Intent intent = getIntent();

        btnAdd = (Button) findViewById(R.id.addtoBill);
        btnView = (Button) findViewById(R.id.viewBill);
        foodNameTextView = (TextView) findViewById(R.id.kidsItemName);
        foodCostTextView = (TextView) findViewById(R.id.kidsItemCost);

        // reference to DatabaseHelper object that will be used
        mDatabaseHelper = new DatabaseHelper(this);

        final ArrayAdapter<Food> listAdapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1, Food.kidsMenu);

        ListView listFoods = (ListView) findViewById(R.id.list_kidsChoices);
        listFoods.setAdapter(listAdapter);

        // Create a listener to listen for when a Food item is clicked on
        AdapterView.OnItemClickListener itemClickListener =
                new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> listFoods,
                                            View itemView, int position, long id) {
                        String[] kidsFood = new String[8];
                        Double[] cost = new Double[8];

                        //for(int i = 0; i <= position; i++)
                        int i = position;
                        kidsFood[i] = Food.kidsMenu[i].getFoodName();
                        cost[i] = Food.drinksFood[i].getPrice();

                        String costString = Double.toString(cost[i]);


                        Context context = getApplicationContext();
                        int duration = Toast.LENGTH_SHORT;

                        Toast toast = Toast.makeText(context, kidsFood[i], duration);
                        toast.show();

                        foodNameTextView.setText(kidsFood[i]);
                        foodCostTextView.setText(costString);
                        // Pass the Food name the user clicks on to BreakfastChoicesActivity
                    }
                };
        // Assign the listener to the list view
        listFoods.setOnItemClickListener(itemClickListener);
    }

    public void onClickAddButton(View v) {

        // Gets data the user entered
        String name = foodNameTextView.getText().toString();
        String cost = foodCostTextView.getText().toString();

        Log.d(TAG, "onClickAddButton: " + name + ", " + cost);

        // Make sure that none of the fields are empty
        if (name.length()!= 0 && cost.length() != 0) {

            addData(name, cost);

            // clears the edit text fields in case more data entry follows
            foodNameTextView.setText("");
            foodCostTextView.setText("");
        }
        else
            toastMessage("Please fill in all text fields");
    }

    public void addData(String name, String cost) {
        boolean insertData = mDatabaseHelper.addData(name, cost);

        if(insertData) {
            toastMessage("Data inserted successfully");
        }
        else
            toastMessage("Something went wrong");
    }

    // This method will load the page with the ListView that shows all the values in the database
    public void onClickViewButton(View v) {
        Intent intent = new Intent(KidsMenuActivity.this, CalculateBillActivity.class);
        startActivity(intent);
    }


    /**
     * Customizable toast message
     * @param message
     */

    private void toastMessage(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    public void goToAdultMenu(View v) {
        Intent intent = new Intent(this, AdultsMenuActivity.class);
        startActivity(intent);
    }


}