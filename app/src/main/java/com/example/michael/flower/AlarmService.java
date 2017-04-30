package com.example.michael.flower;

import android.app.AlarmManager;
import android.app.Service;
import android.content.Context;

import android.content.Intent;
import android.os.IBinder;
import android.os.SystemClock;
import android.support.annotation.Nullable;

import java.util.Calendar;


/**
 * Created by Michael on 29.04.2017.
 */

public abstract class AlarmService extends Service {
    AlarmManager manager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);

//    Intent intent = new Intent(this)
//    Calendar calendar = Calendar.getInstance();
//    public AlarmService(){
//        calendar.setTimeInMillis(System.currentTimeMillis());
//        calendar.add(Calendar.SECOND, 10);
//        long time = calendar.getTimeInMillis();
//
//
//        manager.setRepeating(AlarmManager.RTC_WAKEUP, time,
//                AlarmManager.INTERVAL_HOUR, pendingIntent);
//    }



}
