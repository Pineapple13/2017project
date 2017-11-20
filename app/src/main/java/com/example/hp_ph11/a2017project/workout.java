package com.example.hp_ph11.a2017project;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Workout extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView lstitems;
    ArrayList<Item> items = new ArrayList<Item>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);
        lstitems = (ListView) findViewById(R.id.lstitems);
        items.add(new Item("First Item", R.drawable.pineapple));
        items.add(new Item("Second Item", R.drawable.pineapple));
        CustomAdapter custom = new CustomAdapter(this, R.layout.custom_row, items);
        lstitems.setAdapter(custom);
        lstitems.setOnItemClickListener(this);
        Intent intent = getIntent();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu, menu);// shows the menu on this page
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.mnAbout) {// the code that tells every option in the menu what to do
            Intent i = new Intent(this, About.class);
            startActivity(i);
        }
        if (item.getItemId() == R.id.mnWorkout) {
            Intent j = new Intent(this, Workout.class);
            startActivity(j);
        }
        if (item.getItemId() == R.id.mnBMI) {
            Intent o = new Intent(this, BMI.class);
            startActivity(o);
        }
        if (item.getItemId() == R.id.mnExit) {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Are you sure you want to Exit?");
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    finish();
                }
            });
            builder.setNegativeButton("No", null);
            AlertDialog dialog = builder.create();
            dialog.show();
        }
        if (item.getItemId() == R.id.mnMain) {
            Intent w = new Intent(this, MainActivity.class);
            startActivity(w);
        }
        if (item.getItemId() == R.id.mnPersonalInfo) {
            Intent w = new Intent(this, Personalinfo.class);
            startActivity(w);
        }
        if (item.getItemId() == R.id.mnCamera) {
            Intent w = new Intent(this, CameraActivity.class);
            startActivity(w);
        }

        return true;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        if (i == 0) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=VHyGqsPOUHs"));
            startActivity(intent);
        }
        if (i == 1) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=Bs0FmuqUzwU"));
            startActivity(intent);
        }
        if (i == 2) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=Bs0FmuqUzwU"));
            startActivity(intent);
        }
        if (i == 3) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(""));
            startActivity(intent);
        }
    }
}
