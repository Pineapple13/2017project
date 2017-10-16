package com.example.hp_ph11.a2017project;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
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
}
