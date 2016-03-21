package com.scib.isratjahan.mchipsurvey.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.scib.isratjahan.mchipsurvey.R;

public class FormActivity extends AppCompatActivity {
Button Save,Submit;
    RadioGroup q1,q2,q3,q4,q5,q6,q7,q8,q9,q10;
    RadioButton qrb1,qrb2,qrb3;
    TextView t1,t2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnButton();


    }
    private void addListenerOnButton() {
        Save= (Button) findViewById(R.id.Savebtn);
        Submit= (Button) findViewById(R.id.Submitbtn);
        q1=(RadioGroup)findViewById(R.id.radioGroupq1);
        q2=(RadioGroup)findViewById(R.id.radioGroupq2);
        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedq1=q1.getCheckedRadioButtonId();
                qrb1=(RadioButton)findViewById(selectedq1);
                int selectedq2=q2.getCheckedRadioButtonId();
                qrb2=(RadioButton)findViewById(selectedq2);
            }
        });
    }

}
