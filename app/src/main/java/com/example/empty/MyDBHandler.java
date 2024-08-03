package com.example.empty;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;
public class MyDBHandler extends SQLiteOpenHelper {
    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "MY_DATABASE";
    // User table name
    private static final String TABLE_NAME = "GABBAGE_RECORD";
    // User Table Columns names
    private static final String NAME = "user_name";
    private static final String PHONE = "phone_number";
    private static final String DESCRIBE = "description";
    private static final String COUNTY = "county";

    private static final String WARD = "ward";

    private static final String POLYGON = "polygon";
    private final Context context;

    public MyDBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "(" + NAME
                + " TEXT," + PHONE + " TEXT," + DESCRIBE + " TEXT," + COUNTY + "TEXT " + WARD + "TEXT" + POLYGON + "TEXT" + ")";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(DROP_TABLE);
        onCreate(db);
    }

    public void addemp(String name, String phone, String description, String county, String ward, String polygon) {
        System.out.println("--------Inserting Data________ ");
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(MyDBHandler.NAME, name);
        values.put(MyDBHandler.PHONE, phone);
        values.put(MyDBHandler.DESCRIBE, description);
        values.put(MyDBHandler.COUNTY, county);
        values.put(MyDBHandler.WARD, ward);
        values.put(MyDBHandler.POLYGON, polygon);
        long status = db.insert(TABLE_NAME, null, values);
        if (status <= 0) {
            Toast.makeText(context, "Insertion Unsuccessful",
                    Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "DB Insertion Successful",
                    Toast.LENGTH_SHORT).show();
        }
        db.close();
        System.out.println("--------Done Inserting Data________ ");
    }
}
//    public void deleteUser(String id) {
//        SQLiteDatabase db = this.getWritableDatabase();
//// delete user record by id
//        long s = db.delete(TABLE_NAME, NAME + " = ?",
//                new String[]{String.valueOf(id)});
//        if (s <= 0) {
//            Toast.makeText(context, "Deletion Unsuccessful",
//                    Toast.LENGTH_SHORT).show();
//        } else {
//            Toast.makeText(context, "Deletion Successful",
//                    Toast.LENGTH_SHORT).show();
//        }
//        db.close();
//    }

//    public String load() {
//        System.out.println("--------Data Viewing____ ");
//        StringBuilder result = new StringBuilder();
//        String query = "Select * FROM " + TABLE_NAME;
//        SQLiteDatabase db = this.getWritableDatabase();
//        Cursor cursor = db.rawQuery(query, null);
//        while (cursor.moveToNext()) {
//            int result_0 = cursor.getInt(0);
//            String result_1 = cursor.getString(1);
//            String result_2 = cursor.getString(2);
//            String result_3 = cursor.getString(3);
//            result.append(result_0).append(" ").append(result_1).append(" ").append(result_2).append(" ").append(result_3).append("\n");
//            System.lineSeparator();
//        }
//        cursor.close();
//        db.close();
//        System.out.println("Shibs Viewing data: " + result);
//        return result.toString();
//    }
//}