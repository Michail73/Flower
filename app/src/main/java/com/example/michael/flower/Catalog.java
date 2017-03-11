package com.example.michael.flower;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Catalog extends AppCompatActivity {

    final String LOG_TAG = "myLogs";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar); 

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.cat);

        ListView listView = (ListView)findViewById(R.id.listView);

        final String[] flowers = new String[]{
                "Абелиолистник", "Абелия", "Абрикос", "Абутилон", "Аверроа карамбола", "Авокадо приятнейшее", "Агава американская", "Агава королевы Виктории", "Агапантус", "Аглаонема изменчивая", "Адениум",
                "Роза", "Лилия", "Клюква", "МАРИХУАНА"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, flowers);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                    Log.d(LOG_TAG,"itemClick: position = " + position + ", id = "
                            + id);
                Intent intent = new Intent(Catalog.this, Aboutflower.class);
                intent.putExtra("Title", flowers[position]);
                startActivity(intent);
                switch (position){
                    case (0):
                        break;
                    case (1):
                        break;
                }
            }
        });
    }



//    @Override
//    protected void onListItemClick(ListView l, View v, int position, long id) {
//        super.onListItemClick(l, v, position, id);
//        Toast.makeText(getApplicationContext(),
//                "Вы выбрали " + (position + 1) + " элемент", Toast.LENGTH_SHORT).show();
//    }
//

}
