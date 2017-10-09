package com.example.hp_ph11.a2017project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Workout extends AppCompatActivity implements AdapterView.OnItemClickListener{
    ListView lstitems;
    ArrayList<Item> items= new ArrayList<Item>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);
        lstitems=(ListView)findViewById(R.id.lstitems);
        items.add(new Item("First Item",R.drawable.pineapple));
        items.add(new Item("Second Item",R.drawable.pineapple));
        CustomAdapter custom  =new CustomAdapter(this, R.layout.custom_row,items);
        lstitems.setAdapter(custom);
        Intent intent= getIntent();
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        if(i == 0){
            Toast.makeText(this,"first item",Toast.LENGTH_SHORT).show();
        }
        if(i == 1){
            Toast.makeText(this,"second item",Toast.LENGTH_SHORT).show();
        }
    }
}
