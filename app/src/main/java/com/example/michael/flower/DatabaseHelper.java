package com.example.michael.flower;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by Michael on 07.12.2016.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    private static String DB_PATH = "C:\\Users\\Michael\\Desktop\\Flower_manager\\ViewPager\\app\\src\\main\\assets";
    private static String DB_NAME = "flower_list";
    private static final int SCHEMA = 1; // версия базы данных

    static final String TABLE = "flowers";

    public static final String COLUMN_ID = "name";
    public static final String COLUMN_NAME = "descrition";
    public static final String COLUMN_YEAR = "humidity";
    public SQLiteDatabase database;
    private Context myContext;

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, SCHEMA);
        this.myContext=context;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){}


    public void create_db() {
        InputStream myInput = null;
        OutputStream myOutput = null;
        try {
            File file = new File(DB_PATH + DB_NAME);
            if (!file.exists()) {
                this.getReadableDatabase();
                //получаем локальную бд как поток
                myInput = myContext.getAssets().open(DB_NAME);
                // Путь к новой бд
                String outFileName = DB_PATH + DB_NAME;

                // Открываем пустую бд
                myOutput = new FileOutputStream(outFileName);

                // побайтово копируем данные
                byte[] buffer = new byte[1024];
                int length;
                while ((length = myInput.read(buffer)) > 0) {
                    myOutput.write(buffer, 0, length);
                }

                myOutput.flush();
                myOutput.close();
                myInput.close();
            }
        } catch (IOException ex) {

        }
    }

    public void open() throws SQLException{
        String path = DB_PATH + DB_NAME;
        database = SQLiteDatabase.openDatabase(path, null,
                SQLiteDatabase.OPEN_READWRITE);

    }

    @Override
    public synchronized void close() {
        if (database != null){
            database.close();
        }
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }
}
