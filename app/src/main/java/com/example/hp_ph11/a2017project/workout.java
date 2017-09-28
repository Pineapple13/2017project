package com.example.hp_ph11.a2017project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;

import java.util.ArrayList;

public class workout extends AppCompatActivity {
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
    }
}
