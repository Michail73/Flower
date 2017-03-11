package com.example.michael.flower;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Aboutflower extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutflower);
        //View view = inflater.inflate(R.layout.activity_aboutflower, null);

        String title = getIntent().getStringExtra("Title");

        setTitle(title);


        TextView water_text = (TextView) findViewById(R.id.water);
        water_text.setText("Каждую\n неделю");

        TextView sun_text = (TextView) findViewById(R.id.sun);
        sun_text.setText("среднее");

        TextView temperature = (TextView) findViewById(R.id.gradusnik);
        temperature.setText("15-20");

        RelativeLayout description = (RelativeLayout) findViewById(R.id.short_description);
        final TextView sub_description = (TextView) findViewById(R.id.short_des_text);
        View.OnClickListener oclDescription = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sub_description.setVisibility(View.VISIBLE);
                sub_description.setText("sfdgsg sfgfh sdfhssh shfdhhshssf");
            }

        };
        description.setOnClickListener(oclDescription);

        RelativeLayout lighting = (RelativeLayout) findViewById(R.id.lightning);
        final TextView text_lighting = (TextView) findViewById(R.id.lightning_text);
        View.OnClickListener oclLighting = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text_lighting.setVisibility(View.VISIBLE);
                text_lighting.setText("Оообаа наааа !");
            }
        };
        lighting.setOnClickListener(oclLighting);

        RelativeLayout temperature2 = (RelativeLayout) findViewById(R.id.temperature);
        final TextView text_temperature =(TextView) findViewById(R.id.temperature_text);
        View.OnClickListener oclTemperature = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text_temperature.setVisibility(View.VISIBLE);
                text_temperature.setText("Агонь пожар вызывай 03");
            }
        };
        temperature2.setOnClickListener(oclTemperature);

        RelativeLayout watering =  (RelativeLayout)  findViewById(R.id.watering);
        final TextView water_text2= (TextView) findViewById(R.id.watering_text);
        View.OnClickListener oclWatering = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                water_text2.setVisibility(View.VISIBLE);
                water_text2.setText("Много инфы о том что надо поливать блаб аблабла\n Поливать не забывать \n Пол литра за три дня...");

            }
        };
        watering.setOnClickListener(oclWatering);

        RelativeLayout feeding = (RelativeLayout) findViewById(R.id.feeding);
        final TextView feeding_text = (TextView) findViewById(R.id.feeding_text);
        View.OnClickListener oclFeeding = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                feeding_text.setVisibility(View.VISIBLE);
                feeding_text.setText("А еще нады удобрения подсыпать\n c землей чего-нибудь делать");
            }
        };
        feeding.setOnClickListener(oclFeeding);
    }
}
