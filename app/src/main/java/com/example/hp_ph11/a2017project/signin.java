package com.example.hp_ph11.a2017project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class signin extends AppCompatActivity {
    EditText etname, etpassword, etemail;
    Button btsignedin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        btsignedin = (Button) findViewById(R.id.signedin);
        etemail = (EditText) findViewById(R.id.etemail);
        etpassword = (EditText) findViewById(R.id.etpassword);
        etemail = (EditText) findViewById(R.id.etname);

    }





}



