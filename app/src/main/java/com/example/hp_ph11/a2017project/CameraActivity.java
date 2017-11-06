package com.example.hp_ph11.a2017project;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
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
import java.text.SimpleDateFormat;
import java.util.Date;

public class CameraActivity extends AppCompatActivity implements View.OnClickListener {

    private Bitmap bitmap;
    Button btCamera,btGalery;
    private ImageView imagePhoto;
    static final int SELECT_IMAGE=1;
    static final int TAKE_IMAGE=0;
    SharedPreferences preferences =getSharedPreferences("profile",MODE_PRIVATE);
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
            Intent i = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(i,SELECT_IMAGE);
        }
    }
    //the resultcode will be RESULT_CANCELED if the activity explicity returned that, didnt return any result, or crashed during its operation.
        protected void onActivityresult(int requestCode, int resultcode, Intent data) {
            if (requestCode == TAKE_IMAGE && resultcode == RESULT_OK) {
                Bundle extra = data.getExtras();
                bitmap = (Bitmap) extra.get("data");
                imagePhoto.setImageBitmap(bitmap);
            } else {
                File root = Environment.getExternalStorageDirectory();
                File file = new File(root.getAbsolutePath() + "/DCIM/Camera/img.jpg");
                try {
                    file.createNewFile();
                    FileOutputStream ostream = new FileOutputStream(file);
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, ostream);
                    ostream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(this, "Failed to save image, try again", Toast.LENGTH_LONG).show();
                }
            }
        }


      public File saveImage(Bitmap bitmap){
       File root = Environment.getExternalStorageDirectory();//internal storage  launching.
        String timeStamp = new SimpleDateFormat("yyyMMdd_HHmmss").format(new Date());
        String filePath = root.getAbsolutePath()+"/DCIM/Camera/IMG_"+timeStamp+".jpg";
          File file = new File(filePath);//determining the type of the file and its place.

          try{
              //if gallery not full create a file and save image.
              file.createNewFile();//create new file to save image.
              FileOutputStream ostream = new FileOutputStream(file);// save root in this file.
              bitmap.compress(Bitmap.CompressFormat.JPEG,100,ostream);//compass bitmap in file
              ostream.close();//close.
          }
          catch(Exception e){
              e.printStackTrace();
              Toast.makeText(this,"failed to save image",Toast.LENGTH_SHORT).show();
          }
                return file;
    }
}