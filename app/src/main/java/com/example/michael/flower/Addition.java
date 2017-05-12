package com.example.michael.flower;

import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.icu.text.AlphabeticIndex;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Display;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.StringTokenizer;

public class Addition extends AppCompatActivity {

    private EditText editTextDate, editTextDate2,editTextDiscr;


    // делаем переменные даты/времени полями, т.к. в реальных

    private int mYear, mMonth, mDay;

    int mode = 0;  //переменная для переключения на нужную часть кода в callbackdate для отображения editext
    int hr = 0, day = 0, week = 0;
    int min = 0;
    int sec = 0;
    int result = 0;
    AlarmManager alarmManager;
    PendingIntent pendingIntent;
    BroadcastReceiver mReceiver;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addition);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbaredit);
        setSupportActionBar(toolbar);
//        Toolbar mActionBarToolbar = (Toolbar) findViewById(R.id.toolbar_actionbar);
//        setSupportActionBar(mActionBarToolbar);
        setTitle("Добавление");

        RegisterAlarmBroadcast();


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final EditText edDays = (EditText) findViewById(R.id.day);
        final EditText edWeeks = (EditText) findViewById(R.id.week);
        editTextDate = (EditText) findViewById(R.id.date1);
        editTextDate2 = (EditText) findViewById(R.id.date2);
        TextView nameofplant = (TextView) findViewById(R.id.name);
        editTextDiscr = (EditText) findViewById(R.id.description);

        final String title = getIntent().getStringExtra("Title");

        final String[] descrp = new String[1];

        nameofplant.setText(title);
        editTextDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callDatePicker();
                mode = 1;
            }
        });


        editTextDate.setShowSoftInputOnFocus(false);

        editTextDate2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callDatePicker();
                mode = 2;
            }
        });



        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.days, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);


        Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.mode, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);

        Button savebtn = (Button) findViewById(R.id.save);


                View.OnClickListener oclbtn = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String sday = edDays.getText().toString();
                String sweek = edWeeks.getText().toString();

                if(sday.equals(""))
                    day = 0;
                else {
                    day = Integer.parseInt(edDays.getText().toString());

                    //day=day*1000;
                     day=day*60*60*1000*24;
                }
                if(sweek.equals(""))
                    week = 0;
                else {
                    week = Integer.parseInt(edWeeks.getText().toString());
                    week = week*60*60*1000*24*7;
                }
                result = day+week;
                alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), result , pendingIntent);


                descrp[0] = editTextDiscr.getText().toString();
                Intent intent = new Intent(Addition.this, MyPlants.class);
                intent.putExtra("Title", title);
                intent.putExtra("Description", descrp[0]);
                startActivity(intent);





                sendActionNotification();

            }
        final int NOTIFY_ID = 101;
                    private void sendActionNotification() {
            Context context = getApplicationContext();

            Intent notificationIntent = new Intent(context, Addition.class);
            PendingIntent contentIntent = PendingIntent.getActivity(context,
                    0, notificationIntent,
                    PendingIntent.FLAG_CANCEL_CURRENT);

            Resources res = context.getResources();
            Notification.Builder builder = new Notification.Builder(context);

            builder.setContentIntent(contentIntent)
                    .setSmallIcon(R.drawable.ic_local_florist_black_24dp)
                    // большая картинка
                    .setLargeIcon(BitmapFactory.decodeResource(res, R.drawable.ic_local_florist_black_48dp))
                    //.setTicker(res.getString(R.string.warning)) // текст в строке состояния
                    .setTicker("Последнее китайское предупреждение!")
                    .setWhen(System.currentTimeMillis())
                    .setAutoCancel(true)
                    //.setContentTitle(res.getString(R.string.notifytitle)) // Заголовок уведомления
                    .setContentTitle("Напоминание")
                    //.setContentText(res.getString(R.string.notifytext))
                    .setContentText("Скоро нужно будет полить свои растения"); // Текст уведомления

            // Notification notification = builder.getNotification(); // до API 16
            Notification notification = builder.build();

            NotificationManager notificationManager = (NotificationManager) context
                    .getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.notify(NOTIFY_ID, notification);
                    }
                };

        savebtn.setOnClickListener(oclbtn);

    }




    private void callDatePicker() {
        // получаем текущую дату
        final Calendar cal = Calendar.getInstance();
        mYear = cal.get(Calendar.YEAR);
        mMonth = cal.get(Calendar.MONTH);
        mDay = cal.get(Calendar.DAY_OF_MONTH);

        // инициализируем диалог выбора даты текущими значениями
        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        if(mode==1) {
                            String editTextDateParam = dayOfMonth + "." + (monthOfYear + 1) + "." + year;
                            editTextDate.setText(editTextDateParam);
                        }
                        else {
                            if(mode==2) {
                                String editTextDateParam = dayOfMonth + "." + (monthOfYear + 1) + "." + year;
                                editTextDate2.setText(editTextDateParam);
                            }
                        }
                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_activity_main, menu);
//        return true;
//    }





    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void sendBigTextStyleNotification(View view) {
        String bigText = "Это я, почтальон Печкин. Принес для вас посылку. "
                + "Только я вам ее не отдам. Потому что у вас документов нету. ";

        Intent intent = new Intent(this, Addition.class);
        PendingIntent pIntent = PendingIntent.getActivity(this, 0, intent, 0);

        Notification.Builder builder = new Notification.Builder(this)
                .setTicker("Пришла посылка!")
                .setContentTitle("Уведомление с большим текстом")
                .setContentText(
                        "Это я, почтальон Печкин. Принес для вас посылку")
                .setSmallIcon(R.drawable.ic_local_florist_black_24dp)
                .addAction(R.drawable.ic_local_florist_black_48dp, "Запустить активность",
                        pIntent).setAutoCancel(true);

        Notification notification = new Notification.BigTextStyle(builder)
                .bigText(bigText).build();

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(1, notification);
    }



    @Override
    protected void onDestroy() {
       unregisterReceiver(mReceiver);
        super.onDestroy();
    }



    private void RegisterAlarmBroadcast() {
        mReceiver = new BroadcastReceiver() {
            // private static final String TAG = "Alarm Example Receiver";
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onReceive(Context context, Intent intent) {
                Toast.makeText(context, "Время поливать свои растения! ", Toast.LENGTH_LONG).show();
            }
        };

        registerReceiver(mReceiver, new IntentFilter("sample"));
        pendingIntent = PendingIntent.getBroadcast(this, 0, new Intent("sample"), 0);
        alarmManager = (AlarmManager)(this.getSystemService(Context.ALARM_SERVICE));
    }

    private void UnregisterAlarmBroadcast() {
        alarmManager.cancel(pendingIntent);
        getBaseContext().unregisterReceiver(mReceiver);
    }


}
