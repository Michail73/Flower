package com.example.michael.flower;


import android.app.AlarmManager;
import android.app.PendingIntent;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;


import static com.example.michael.flower.R.layout.activity_my_plants;

public class MyPlants extends AppCompatActivity {


    private ArrayList<HashMap<String, Object>> mPlantList;
    private static final String TITLE = "plantname"; // Верхний текст
    private static final String DESCRIPTION = "description"; // ниже главного

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_my_plants);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String Description = getIntent().getStringExtra("Description");
        String Title = getIntent().getStringExtra("Title");

        // получаем экземпляр элемента ListView
        ListView listView = (ListView)findViewById(R.id.listView);




        // создаем массив списков
        mPlantList = new ArrayList<HashMap<String, Object>>();
        HashMap<String, Object> hm;

        hm = new HashMap<>();
        hm.put(TITLE, Title); // Название
        hm.put(DESCRIPTION, Description); // Описание
        mPlantList.add(hm);
        SimpleAdapter adapter = new SimpleAdapter(this, mPlantList,
                R.layout.list_item, new String[]{TITLE, DESCRIPTION},
                new int[]{R.id.text1, R.id.text2});

        listView.setAdapter(adapter);


        int alarmType = AlarmManager.ELAPSED_REALTIME_WAKEUP;
        long timeOrLengthofWait = 10000;
        String ALARM_ACTION = "ALARM_ACTION";
        Intent intentToFire = new Intent(ALARM_ACTION);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0,
                intentToFire, 0);

        AlarmManager alarms =
                (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        alarms.set(alarmType, timeOrLengthofWait, pendingIntent);
        alarms.cancel(pendingIntent);
        String MY_RTC_ALARM = "MY_RTC_ALARM";
        //String ALARM_ACTION = "MY_ELAPSED_ALARM";
        PendingIntent rtcIntent = PendingIntent.getBroadcast(this, 0,
                new Intent(MY_RTC_ALARM), 1);
        PendingIntent elapsedIntent =
                PendingIntent.getBroadcast(this, 0,
                        new Intent(ALARM_ACTION), 1);
        // Пробудить устройство и запустить Намерение через 5 часов.
        Date t = new Date();
        t.setTime(java.lang.System.currentTimeMillis() + 1000 );
        alarms.set(AlarmManager.RTC_WAKEUP, t.getTime(), rtcIntent);
// Запустить Намерение через 30 минут, если устройство не находится
// в спящем режиме.
        alarms.set(AlarmManager.ELAPSED_REALTIME, 5000, elapsedIntent);
// Отменить первую Сигнализацию.
        alarms.cancel(rtcIntent);
    }


}
