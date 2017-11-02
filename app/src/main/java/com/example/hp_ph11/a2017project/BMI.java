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
        if (view==btBMI){
            bmi=(etweight/(etheight*etheight));

          tvanswer.setText(etweight/("Your BMI is:"etweight/(etheight*etheight),"");
        }

    }
}
