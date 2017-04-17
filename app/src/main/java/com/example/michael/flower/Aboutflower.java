package com.example.michael.flower;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import static com.example.michael.flower.R.id.toolbar;

public class Aboutflower extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutflower);
        //View view = inflater.inflate(R.layout.activity_aboutflower, null);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        String title = getIntent().getStringExtra("Title");

        //setTitle(title);
        toolbar.setTitle(title);

        TextView water_text = (TextView) findViewById(R.id.water);
        water_text.setText("Каждую\n неделю");

        TextView sun_text = (TextView) findViewById(R.id.sun);
        sun_text.setText("среднее");

        TextView temperature = (TextView) findViewById(R.id.gradusnik);
        temperature.setText("15-20");

        boolean flag = false;
        RelativeLayout description = (RelativeLayout) findViewById(R.id.short_description);
        final TextView sub_description = (TextView) findViewById(R.id.short_des_text);

        switch (title){
            case "Абелия":
                View.OnClickListener oclDescription = new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        if(sub_description.getVisibility() != view.VISIBLE) {
                            sub_description.setVisibility(View.VISIBLE);
                            sub_description.setText("тест тест");
                        }
                        else
                        {
                            sub_description.setVisibility(View.GONE);
                        }
                    }

                };
                description.setOnClickListener(oclDescription);
                break;

        }
//        View.OnClickListener oclDescription = new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                    if(sub_description.getVisibility() != view.VISIBLE) {
//                        sub_description.setVisibility(View.VISIBLE);
//                        sub_description.setText("sfdgsg sfgfh sdfhssh shfdhhshssf");
//                    }
//                    else
//                    {
//                        sub_description.setVisibility(View.GONE);
//                    }
//            }
//
//        };
//        description.setOnClickListener(oclDescription);

        RelativeLayout lighting = (RelativeLayout) findViewById(R.id.lightning);
        final TextView text_lighting = (TextView) findViewById(R.id.lightning_text);
        View.OnClickListener oclLighting = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (text_lighting.getVisibility() != view.VISIBLE) {
                    text_lighting.setVisibility(View.VISIBLE);
                    text_lighting.setText("Оообаа наааа !");
                }
                else{
                    text_lighting.setVisibility(View.GONE);
                }
            }
        };
        lighting.setOnClickListener(oclLighting);

        RelativeLayout temperature2 = (RelativeLayout) findViewById(R.id.temperature);
        final TextView text_temperature =(TextView) findViewById(R.id.temperature_text);
        View.OnClickListener oclTemperature = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(text_temperature.getVisibility() != View.VISIBLE) {
                    text_temperature.setVisibility(View.VISIBLE);
                    text_temperature.setText("Агонь пожар вызывай 03");
                }
                else {
                    text_temperature.setVisibility(View.GONE);
                }
            }
        };
        temperature2.setOnClickListener(oclTemperature);

        RelativeLayout watering =  (RelativeLayout)  findViewById(R.id.watering);
        final TextView water_text2= (TextView) findViewById(R.id.watering_text);
        View.OnClickListener oclWatering = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(water_text2.getVisibility() != View.VISIBLE){
                water_text2.setVisibility(View.VISIBLE);
                water_text2.setText("Много инфы о том что надо поливать блаб аблабла\n Поливать не забывать \n Пол литра за три дня...");}
                else {
                    water_text2.setVisibility(View.GONE);
                }

            }
        };
        watering.setOnClickListener(oclWatering);

        RelativeLayout feeding = (RelativeLayout) findViewById(R.id.feeding);
        final TextView feeding_text = (TextView) findViewById(R.id.feeding_text);
        View.OnClickListener oclFeeding = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(feeding_text.getVisibility() != View.VISIBLE){
                feeding_text.setVisibility(View.VISIBLE);
                feeding_text.setText("А еще нады удобрения подсыпать\n c землей чего-нибудь делать");}
                else {
                    feeding_text.setVisibility(View.GONE);
                }
            }
        };
        feeding.setOnClickListener(oclFeeding);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.float_button);
        View.OnClickListener oclfab = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Aboutflower.this, Addition.class);
                startActivity(intent);
            }
        };

        fab.setOnClickListener(oclfab);
    }



}
