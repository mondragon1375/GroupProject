package com.example.groupproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String TAG = "DatabaseHelper";
    private static final String DB_NAME = "bill";
    private static final String TABLE_NAME = "run_table";
    private static final String COL0 = "_id";
    private static final String COL1 = "FOODNAME";
    private static final String COL2 = "FOODCOST";

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (" + COL0
                + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL1 + " TEXT, "
                + COL2 + " TEXT); ";
        Log.d(TAG, "onCreate: " + createTable);
        db.execSQL(createTable);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean addData(String foodName, String foodCost) {
        SQLiteDatabase db = this.getWritableDatabase();         // This will get an object tor the database
        ContentValues contentValues = new ContentValues();      // This will help us write to the database
        contentValues.put(COL1, foodName);
        contentValues.put(COL2, foodCost);

        // this will display info to help us in Logcat to see where we are
        Log.d(TAG, "addData: Adding " + foodName + " " + foodCost + " to " + TABLE_NAME);

        // insert value into table.  Returns -1 if not successful
        long result = db.insert(TABLE_NAME, null, contentValues);

        if (result == -1)
            return false;       // didn't insert correctly
        else
            return true;        // successful add to table
    }

    public Cursor getData() {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor data = db.rawQuery(query, null);
        return data;
    }

    public Cursor getItemID(String foodName) {
        SQLiteDatabase db = this.getWritableDatabase();
        // query is essentially saying
        // "select the id from the table where the name is equal to the name passed in"

        String query = "SELECT " + COL0 + " FROM " + TABLE_NAME + " WHERE " + COL1 +
                " = '" + foodName + "'";
        // Note there are single quotes around the name variable inside of double quotes
        Cursor data = db.rawQuery(query, null);
        return  data;
    }

    public void updateName(String newFoodName, int id, String oldFoodName) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "UPDATE " + TABLE_NAME + " SET " + COL1 +
                " = '" + newFoodName + "' WHERE " + COL0 + " = '" + id + "'" +
                " AND " + COL1 + " = '" + oldFoodName + "'";

        Log.d(TAG, "updateName: query " + query);
        Log.d(TAG, "updateName: Setting name to " + newFoodName);
        db.execSQL(query);
    }

    public void deleteName(int id, String foodName) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "DELETE FROM " + TABLE_NAME + " WHERE " +
                COL0 + " = '" + id + "'" + " AND " + COL1 + " = '" + foodName + "'";
        Log.d(TAG, "deleteName: query " + query);
        Log.d(TAG, "deleteName: Deleting " + foodName + " from database");
        db.execSQL(query);
    }

}