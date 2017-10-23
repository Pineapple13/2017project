package com.example.hp_ph11.a2017project;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
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
        if (v == btCamera) {
            //start another activity and recieve a result back in case the activity exists return 0
            Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(i, TAKE_IMAGE);
        }
        else {
            Intent i = new Intent(MediaStore.ACTION_PICK,
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivity(i,SELECT_IMAGE);
        }
    }
    //the resultcode will be RESULT_CANCELED if the activity explicity returned that, didnt return any result, or crashed during its operation.
        protected void onActivityresult(int requestCode, int resultcode, Intent data){
          if (requestCode==TAKE_IMAGE && resultcode== RESULT_OK){
              Bundle extra = data.getExtras();
              bitmap = (Bitmap)extra.get("data");
              imageView.setImageBitmap(bitmap);
          }
            File root = Environment.getExternalStorageDirectory();
            File file = new File(root.getAbsolutePath()+"/DCIM/Camera/img.jpg");
            try
            {
                file.createNewFile();
                FileOutputStream ostream = new FileOutputStream(file);
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, ostream);
                ostream.close();
            }
            catch (Exception e)
            {
                e.printStackTrace();
                Toast.makeText(this,"Failed to save image, try again",Toast.LENGTH_LONG).show();
            }
    }
    }

