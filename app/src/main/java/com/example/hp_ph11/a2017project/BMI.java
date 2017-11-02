package com.example.hp_ph11.a2017project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
