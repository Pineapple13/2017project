package com.example.hp_ph11.a2017project;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;

import java.security.PrivateKey;

public class CameraActivity extends AppCompatActivity implements View.OnClickListener {

    private Bitmap bitmap;
    Button btCamera,btGalery;
    private ImageView imagePhoto;
    static final int SELECT_IMAGE=1;
    static final int TAKE_IMAGE=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        btGalery=(Button)findViewById(R.id.btGalery);
        btCamera=(Button)findViewById(R.id.btCamera);
        imagePhoto=(ImageView)findViewById(R.id.imagePhoto);
        btCamera.setOnClickListener(this);
        btGalery.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if (v==btCamera){
            //start anither activity and recieve a result back in case the activity
            Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(i,TAKE_IMAGE);
        }
        protected void onActivityresult(int requestCode, int resultcode, Intent data){
          if (requestCode==TAKE_IMAGE && resultcode== RESULT_OK){
              Bundle extra = data.getExtras();
              bitmap = (Bitmap)extra.get("data");
              imageView.setImageBitmap(bitmap);
          }
    }
    }
}
