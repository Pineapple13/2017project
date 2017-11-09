package com.example.hp_ph11.a2017project;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BMI extends AppCompatActivity implements View.OnClickListener{

    TextView tvtitle,tvanswer;
    EditText etweight,etheight;
    Button btBMI;
    double bmi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);
        Intent intent = getIntent();
        tvtitle=(TextView)findViewById(R.id.tvtitle);
        etweight=(EditText)findViewById(R.id.etweight);
        etheight=(EditText)findViewById(R.id.etheight);
        tvanswer=(TextView)findViewById(R.id.tvanswer);
        btBMI=(Button) findViewById(R.id.btBMI);
        btBMI.setOnClickListener(this);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu,menu);// shows the menu on this page
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
            Intent w = new Intent(this,Personalinfo.class);
            startActivity(w);
        }
        if (item.getItemId() == R.id.mnCamera) {
            Intent w = new Intent(this,CameraActivity.class);
            startActivity(w);
        }

        return true;
    }

    @Override
    public void onClick(View view) {
        if (view==btBMI) {
            double weight = Double.parseDouble(etweight.getText().toString());
            double height = Double.parseDouble(etheight.getText().toString());
            bmi = (weight / (height * height));
            if (bmi < 18.5){
                tvanswer.setText("your bmi is:" + bmi + ",which means your very skinny you need a better food style and excersises");
        }
            if (18.5<bmi && bmi<24.99){
                tvanswer.setText("your bmi is"+bmi+"which means you have a health weight keep on with your food and excersise life style");
            }
            if (25.0<bmi && bmi<29.99){
                tvanswer.setText("your bmi is"+bmi+" which means your overweight, you need a healthier food style and excersise more");
            }
            else{
                tvanswer.setText("your bmi is"+bmi+"you're obesive,you must start losing weight and eating a lot healthier");
            }
        }

    }
}
