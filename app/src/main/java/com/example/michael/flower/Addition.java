package com.example.michael.flower;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.Calendar;

public class Addition extends AppCompatActivity implements View.OnClickListener {


//    Spinner spinnerdate1;
//    Button btn;
//    int year_x,moth_x,day_x;
//    static final  int DIALOG_ID = 0;
    private Button btnDatePicker;
    private EditText editTextDate;

    // делаем переменные даты/времени полями, т.к. в реальных

    private int mYear, mMonth, mDay, mHour, mMinute;


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addition);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Добавление");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btnDatePicker = (Button) findViewById(R.id.btn_date);
        editTextDate = (EditText) findViewById(R.id.date1);


//        View.OnClickListener datebtn {
//                callDatePicker();
//        }

        btnDatePicker.setOnClickListener(this);

//        final Calendar cal = Calendar.getInstance();
//        year_x = cal.get(Calendar.YEAR);
//        moth_x = cal.get(Calendar.MONTH);
//        day_x = cal.get(Calendar.DAY_OF_MONTH);

        //showDialogOnSpinner();

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

        Button savebtn = (Button) findViewById(R.id.button3);


                View.OnClickListener oclbtn = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Addition.this, MyPlants.class);
                startActivity(intent);
            }
        };

        savebtn.setOnClickListener(oclbtn);

    }



    public void onClick(View v) {
        int id = v.getId();

        switch (id) {
            case R.id.btn_date:
                // вызываем диалог с выбором даты
                callDatePicker();
                break;


        }
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
                        String editTextDateParam = dayOfMonth + "." + (monthOfYear + 1) + "." + year;
                        editTextDate.setText(editTextDateParam);
                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }

//    public void showDialogOnSpinner(){
//        btn = (Button) findViewById(R.id.button4);
//        //spinnerdate1 = (Spinner) findViewById(R.id.date1);
//        btn.setOnClickListener(
//                new View.OnClickListener(){
//                    @Override
//                    public  void onClick(View v){
//                        showDialog(DIALOG_ID);
//                    }
//                }
//        );
//    }

//    @Override
//    protected Dialog onCreateDialog(int id){
//     if (id == DIALOG_ID)
//         return new DatePickerDialog(this, dpickerListener, year_x, moth_x, day_x);
//        return null;
//    }
//
//    private DatePickerDialog.OnDateSetListener dpickerListener = new DatePickerDialog.OnDateSetListener(){
//        @Override
//        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth){
//           year_x=year;
//            moth_x= monthOfYear+1;
//            day_x= dayOfMonth;
//            Toast.makeText(Addition.this, year_x +"/" + moth_x + "/" + day_x, Toast.LENGTH_LONG);
//        }
//    };


}
