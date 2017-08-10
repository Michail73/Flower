package com.example.michael.flower;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;



public class Aboutflower extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutflower);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        final String title = getIntent().getStringExtra("Title");

        //setTitle(title);
        toolbar.setTitle(title);

        TextView water_text = (TextView) findViewById(R.id.water);
        water_text.setText("Каждую\n неделю");

        TextView sun_text = (TextView) findViewById(R.id.sun);
        sun_text.setText("среднее");

        TextView temperature = (TextView) findViewById(R.id.gradusnik);
        temperature.setText("15-20");


        RelativeLayout description = (RelativeLayout) findViewById(R.id.short_description);
        final TextView sub_description = (TextView) findViewById(R.id.short_des_text);
        final TextView text_lighting = (TextView) findViewById(R.id.lightning_text);
        final TextView text_temperature =(TextView) findViewById(R.id.temperature_text);
        final TextView water_text2= (TextView) findViewById(R.id.watering_text);
        final TextView feeding_text = (TextView) findViewById(R.id.feeding_text);

        switch (title){
            case "Абелия":
                sub_description.setText(getString(R.string.abelia_description));
                text_lighting.setText(R.string.abelia_lighting);
                text_temperature.setText(R.string.abelia_temperature);
                water_text2.setText(R.string.abelia_water);
                feeding_text.setText(R.string.abelia_feeding);
                break;

            case "Абелиолистник":
                sub_description.setText(R.string.abeliolistnik_description);
                text_lighting.setText(R.string.abeliolistnik_lighting);
                text_temperature.setText(R.string.abeliolistnik_temp);
                water_text2.setText("Обильный полив 2-3 раза в неделю");
                feeding_text.setText("Редкие подкормки");
                break;
            case "Абрикос":
                sub_description.setText(R.string.abrikos_desription);
                text_lighting.setText(R.string.abrikos_lighting);
                text_temperature.setText(R.string.abrikos_temp);
                water_text2.setText(R.string.abrikos_water);
                feeding_text.setText(R.string.abrikos_feeding);
                break;
            case "Абутилон":
                sub_description.setText(R.string.abutulion_description);
                text_lighting.setText(R.string.abutulion_lighting);
                text_temperature.setText(R.string.abutulion_temp);
                water_text2.setText(R.string.abutulion_water);
                feeding_text.setText(R.string.abutulion_feeding);
                break;
            case "Аверроа карамбола":
                sub_description.setText(R.string.carambola_description);
                text_lighting.setText(R.string.carambola_lighting);
                text_temperature.setText(R.string.carambola_temp);
                water_text2.setText(R.string.carambola_water);
                feeding_text.setText(R.string.carambola_feeding);
                break;
            case "Авокадо приятнейшее":
                sub_description.setText(R.string.avokado_description);
                text_lighting.setText(R.string.avokado_lighting);
                text_temperature.setText(R.string.avokado_temp);
                water_text2.setText(R.string.avokado_water);
                feeding_text.setText(R.string.avokado_feeding);
                break;
            case "Агава американская":
                sub_description.setText(R.string.agava_description);
                text_lighting.setText(R.string.agava_lighting);
                text_temperature.setText(R.string.agava_temp);
                water_text2.setText(R.string.agava_water);
                feeding_text.setText(R.string.agava_feeding);
                break;
            case "Агава королевы Виктории":
                sub_description.setText(R.string.agavaVic_description);
                text_lighting.setText(R.string.agavaVic_lighting);
                text_temperature.setText(R.string.agavaVic_temp);
                water_text2.setText(R.string.agavaVic_water);
                feeding_text.setText(R.string.agavaVic_feeding);
                break;

            case "Агапантус":
                sub_description.setText(R.string.Agapantus_description);
                text_lighting.setText(R.string.Agapantus_lighting);
                text_temperature.setText(R.string.Agapantus_temp);
                water_text2.setText(R.string.Agapantus_water);
                feeding_text.setText(R.string.Agapantus_feeding);
                break;
            case "Аглаонема изменчивая":
                sub_description.setText(R.string.aglaonema_description);
                text_lighting.setText(R.string.aglaonema_lighting);
                text_temperature.setText(R.string.aglaonema_temp);
                water_text2.setText(R.string.aglaonema_water);
                feeding_text.setText(R.string.aglaonema_feeding);
                break;
            case "Адениум":
                sub_description.setText(R.string.adenium_description);
                text_lighting.setText(R.string.adenium_lighting);
                text_temperature.setText(R.string.adenium_temp);
                water_text2.setText(R.string.adenium_water);
                feeding_text.setText(R.string.adenium_feeding);
                break;
            case "Роза":
                sub_description.setText(R.string.rose_description);
                text_lighting.setText(R.string.rose_lighting);
                text_temperature.setText(R.string.rose_temp);
                water_text2.setText(R.string.rose_water);
                feeding_text.setText(R.string.rose_feeding);
                break;
            case "Лилия":
                sub_description.setText(R.string.lílium_description);
                text_lighting.setText(R.string.lílium_lighting);
                text_temperature.setText(R.string.lílium_temp);
                water_text2.setText(R.string.lílium_water);
                feeding_text.setText(R.string.lílium_feeding);
                break;
            case "Клюква":
                sub_description.setText(R.string.klukva_description);
                text_lighting.setText(R.string.klukva_lighting);
                text_temperature.setText(R.string.klukva_temp);
                water_text2.setText(R.string.klukva_water);
                feeding_text.setText(R.string.klukva_feeding);
                break;
            case "МАРИХУАНА":
                sub_description.setText(R.string.weed_description);
                text_lighting.setText(R.string.weed_lighting);
                text_temperature.setText(R.string.weed_temp);
                water_text2.setText(R.string.weed_water);
                feeding_text.setText(R.string.weed_feeding);
                break;
        }

        View.OnClickListener oclDescription = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(sub_description.getVisibility() != view.VISIBLE) {
                    sub_description.setVisibility(View.VISIBLE);

                }
                else
                {
                    sub_description.setVisibility(View.GONE);
                }
            }

        };
        description.setOnClickListener(oclDescription);

        RelativeLayout lighting = (RelativeLayout) findViewById(R.id.lightning);

        View.OnClickListener oclLighting = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (text_lighting.getVisibility() != view.VISIBLE) {
                    text_lighting.setVisibility(View.VISIBLE);

                }
                else{
                    text_lighting.setVisibility(View.GONE);
                }
            }
        };
        lighting.setOnClickListener(oclLighting);

        RelativeLayout temperature2 = (RelativeLayout) findViewById(R.id.temperature);

        View.OnClickListener oclTemperature = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(text_temperature.getVisibility() != View.VISIBLE) {
                    text_temperature.setVisibility(View.VISIBLE);

                }
                else {
                    text_temperature.setVisibility(View.GONE);
                }
            }
        };
        temperature2.setOnClickListener(oclTemperature);

        RelativeLayout watering =  (RelativeLayout)  findViewById(R.id.watering);

        View.OnClickListener oclWatering = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(water_text2.getVisibility() != View.VISIBLE){
                    water_text2.setVisibility(View.VISIBLE);
                   }
                else {
                    water_text2.setVisibility(View.GONE);
                }

            }
        };
        watering.setOnClickListener(oclWatering);

        RelativeLayout feeding = (RelativeLayout) findViewById(R.id.feeding);

        View.OnClickListener oclFeeding = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(feeding_text.getVisibility() != View.VISIBLE){
                    feeding_text.setVisibility(View.VISIBLE);
                   }
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
                intent.putExtra("Title", title);
                startActivity(intent);
            }
        };

        fab.setOnClickListener(oclfab);
    }



}
