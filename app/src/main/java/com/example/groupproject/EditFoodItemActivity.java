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

    private Button deleteBtn, updateBtn;
    private EditText editName;

    private static final String TAG = "EditFoodItemActivity";

    DatabaseHelper mDatabaseHelper;
    private String selectedName;
    private int selectedID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_food_data);

        editName = (EditText) findViewById(R.id.itemName);
        deleteBtn = (Button) findViewById(R.id.buttonDelete);
        updateBtn = (Button) findViewById(R.id.buttonUpdate);
        mDatabaseHelper = new DatabaseHelper(this);

        // get the intent and get the extra info that was put into the intent
        Intent receivedIntent = getIntent();
        selectedID = receivedIntent.getIntExtra(ID, -1);    // -1 is default value
        selectedName = receivedIntent.getStringExtra(NAME);

        Log.d(TAG, "onCreate, selectedID " + selectedID + " selectedName " + selectedName);

        // set the EditText to equal the name they clicked on
        // Later add extra text fields to allow them to edit all areas of this data entry
        editName.setText(selectedName);

        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String item = editName.getText().toString();

                if(!selectedName.equals("")){
                    mDatabaseHelper.updateName(item, selectedID, selectedName);
                    toastMessage("Data updated");

                    // Reload ListView with refreshed info
                    Intent intent = new Intent(EditFoodItemActivity.this, CalculateBillActivity.class);
                    startActivity(intent);
                }
                else {
                    toastMessage("You must enter a name");
                }

            }
        });


        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDatabaseHelper.deleteName(selectedID, selectedName);
                editName.setText("");
                toastMessage("Removed from database");

                // Reload ListView with refreshed info
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
