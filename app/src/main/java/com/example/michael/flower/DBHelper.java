package com.example.michael.flower;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Michael on 08.12.2016.
 */

public class DBHelper {

    private static DBHelper INSTANCE;
    public static DBHelper getINSTANCE(){
        if (INSTANCE==null) INSTANCE = new DBHelper();
        return INSTANCE;
    }

    private SQLiteDatabase base;
    private DBHelper(){

        SQLiteHelper helper = new SQLiteHelper(Michael.INSTANCE);
                base = helper.getWritableDatabase();

    }


    public void write (Tsvetok tsvetok){
        ContentValues v = new ContentValues();
        v.put(Constants.DB.COLUMN_CHASTOTA, tsvetok.getChastota());
        v.put(Constants.DB.COLUMN_NAME, tsvetok.getName());
        v.put(Constants.DB.COLUMN_CHASTOTA, tsvetok.getChastota());
        v.put(Constants.DB.COLUMN_CHASTOTA, tsvetok.getChastota());
        base.insert(Constants.DB.NAME, null, v);
    }
}
