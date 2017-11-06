package com.example.hp_ph11.a2017project;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button BMI;
    TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu,menu);// shows the menu on this page
        return true;


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.Main){// the code that tells every option in the menu what to do
            Intent i = new Intent(this,About.class);
            startActivity(i);
        }
        if (item.getItemId() ==R.id.mnAbout) {
            Intent j = new Intent(this,Workout.class);
            startActivity(j);
        }
         if (item.getItemId()==R.id.mnBMI){
             Intent o = new Intent(this,BMI.class);
             startActivity(o);
         }
        if (item.getItemId()==R.id.mnExit){

            AlertDialog.Builder builder=new AlertDialog.Builder(this);
            builder.setMessage("Are you sure you want to Exit?");
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    finish();
                }
            });
            builder.setNegativeButton("No",null);
            AlertDialog dialog = builder.create();
            dialog.show();
            }
        if (item.getItemId()==R.id.mnPersonalInfo){
            Intent w = new Intent(this,MainActivity.class);
            startActivity(w);
        }
        if (item.getItemId()==R.id.mnCamera){
            Intent c = new Intent(this,MainActivity.class);
            startActivity(c);
        }
        if (item.getItemId()==R.id.mnWorkout){
            Intent e = new Intent(this,MainActivity.class);
            startActivity(e);
        }

        return true;
        }

    }


