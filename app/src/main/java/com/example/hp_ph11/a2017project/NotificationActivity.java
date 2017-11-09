package com.example.hp_ph11.a2017project;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class NotificationActivity extends AppCompatActivity {
    private NotificationCompat.Builder builder;
    private Button btnNotify;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        btnNotify = (Button) findViewById(R.id.btnNotify);

        //create builder object
        builder = new NotificationCompat.Builder(this);

        //customize the builder
        builder.setSmallIcon(R.drawable.run);
        builder.setContentTitle("lets runn");
        builder.setContentText("yla starts running");

        //
        Intent bIntent = new Intent(this, MainActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, bIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(contentIntent);

        btnNotify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Add as notification
                NotificationManager manager = (NotificationManager) getSystemService(getApplicationContext().NOTIFICATION_SERVICE);
                manager.notify(0, builder.build());
            }
        });
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
            Intent w = new Intent(this,Personalinfo.class);
            startActivity(w);
        }
        if (item.getItemId() == R.id.mnCamera) {
            Intent w = new Intent(this,CameraActivity.class);
            startActivity(w);
        }

        return true;
    }

}
