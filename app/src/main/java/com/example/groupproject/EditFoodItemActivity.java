package com.example.groupproject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class EditFoodItemActivity extends AppCompatActivity {

    // Constants used for the intent
    public static final String ID = "id";
    public static final String NAME = "name";

    private Button deleteBtn, returnBtn;
    private EditText editName;

    private static final String TAG = "EditFoodItemActivity";

    DatabaseHelper mDatabaseHelper;
    private String name;
    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate, selectedID " + id + " selectedName " + name);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_food_data);

        editName = (EditText) findViewById(R.id.itemName);
        deleteBtn = (Button) findViewById(R.id.buttonDelete);
        returnBtn = (Button) findViewById(R.id.buttonReturn);
        mDatabaseHelper = new DatabaseHelper(this);

        // get the intent and get the extra info that was put into the intent
        Intent intent = getIntent();
        id = intent.getIntExtra(ID, -1);    // -1 is default value
        name = intent.getStringExtra(NAME);

        Log.d(TAG, "onCreate, selectedID " + id + " selectedName " + name);

        // set the EditText to equal the name they clicked on
        // Later add extra text fields to allow them to edit all areas of this data entry
        editName.setText(name);

        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDatabaseHelper.deleteName(Integer.toString(id));
                editName.setText("");
                toastMessage("Removed from database");

                // Reload ListView with refreshed info
                Intent intent = new Intent(EditFoodItemActivity.this, CalculateBillActivity.class);
                startActivity(intent);
            }
        });

        returnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EditFoodItemActivity.this, CalculateBillActivity.class);
                startActivity(intent);
            }
        });


    }

    // Goes back to screen to add new run data
    public void onClickAddNewItem(View v) {
        Intent intent = new Intent(EditFoodItemActivity.this, MainActivity.class);
        startActivity(intent);
    }


    /**
     * Customizable toast message
     * @param message
     */

    private void toastMessage(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}
