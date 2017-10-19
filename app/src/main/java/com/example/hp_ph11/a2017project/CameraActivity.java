package com.example.hp_ph11.a2017project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;

import java.security.PrivateKey;

public class CameraActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    Button btCamera,btGalery;
    private ImageView imagePhoto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        btGalery=(Button)findViewById(R.id.btphoto);
        btCamera=(Button)findViewById(R.id.bttakephoto);
        imagePhoto=(ImageView)findViewById(R.id.imagePhoto);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }
}
