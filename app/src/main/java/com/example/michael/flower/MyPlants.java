package com.example.michael.flower;


import android.app.AlarmManager;
import android.app.PendingIntent;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Date;

import static com.example.michael.flower.R.attr.colorPrimaryDark;
import static com.example.michael.flower.R.layout.activity_my_plants;

public class MyPlants extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_my_plants);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String Description = getIntent().getStringExtra("Description");
        TextView Test = (TextView) findViewById(R.id.test);

        Test.setText(Description);

        // получаем экземпляр элемента ListView
        ListView listView = (ListView)findViewById(R.id.listView);
        toolbar.setTitle(Description);
// определяем массив типа String
        final String[] catNames = new String[] {
                "Рыжик", Description, "Мурзик", "Мурка", "Васька",
                "Томасина", "Кристина", "Пушок", "Дымка", "Кузя",
                "Китти", "Масяня", "Симба"
        };

// используем адаптер данных
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, catNames);

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
